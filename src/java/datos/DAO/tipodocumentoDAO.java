/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Tipodocumento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JHONATAN
 */
public class tipodocumentoDAO  implements DAOInterface<Tipodocumento>{

    @Override
    public boolean save(Tipodocumento entity) {
         String sql="";
         boolean exito = false;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getId_documento())==null){    
             statement=
                    c.prepareStatement("insert into tipo_documento values(?,?,?)");
            statement.setInt(1, entity.getId_documento());
            statement.setString(2, entity.getNombre());
            statement.setString(3, entity.getDescripcion());
            }
            else
            {
                 statement=
                    c.prepareStatement("update  tipo_documento set id_tipo=?, nombre=?,descripcion=? where id_tipo=?");
            statement.setInt(1, entity.getId_documento());
            statement.setString(2, entity.getNombre());
            statement.setString(3, entity.getDescripcion());
            statement.setInt(4, entity.getId_documento());
            }    
            exito = statement.execute();
            exito=true;
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(tipodocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        return exito;
    }
    @Override
    public void delete(Tipodocumento entity) {
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from tipo_documento where id_tipo=?");
            
            statement.setInt(1, entity.getId_documento());
           
            
            statement.execute();
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(tipodocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    @Override
    public Tipodocumento findById(Object id) {
        Tipodocumento entity=null ;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select id_tipo,nombre,descripcion from tipo_documento where id_tipo?");
            statement.setString(1, (String)id);
            ResultSet results =  statement.executeQuery();
            if(results.next())
            {
                entity = new Tipodocumento();
                 entity.setId_documento(results.getInt(1));
                 entity.setNombre(results.getString(2));
                 entity.setDescripcion(results.getString(3));
            }
            c.close();      
        } catch (SQLException ex) {
            Logger.getLogger(tipodocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entity;
    }

    @Override
    public ArrayList<Tipodocumento> findAll() {
        ArrayList<Tipodocumento> entities = new ArrayList<Tipodocumento>();
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select id_tipo, nombre,descripcion from tipo_documento"
                    );
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 Tipodocumento entity = new Tipodocumento();
                 entity.setId_documento(results.getInt(1));
                 entity.setNombre(results.getString(2));
                 entity.setDescripcion(results.getString(3));
                 entities.add(entity);
            }    
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(tipodocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return entities;
    }
    public static void  main(String args[]) {
        Tipodocumento x;
        Tipodocumento a=new Tipodocumento();
        a.setId_documento(1);
        a.setNombre("cedula");
        a.setDescripcion("sf");
        tipodocumentoDAO dao=new tipodocumentoDAO();
        dao.save(a);
        //dao.delete(a);
        /*x=dao.findById("1");
        if(x==null){
            System.out.println("Se encontró a nadie con ese documento");
        }
        else{
            System.out.println(x);
        }*/
    }
}