/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Funcionario;
import datos.entidades.usuario_denuncia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
/**
 *
 * @author JHONATAN
 */
public class usuario_denunciaDAO implements DAOInterface<usuario_denuncia>{

    @Override
    public boolean save(usuario_denuncia entity) {
        String sql="";
         boolean exito = false;
        
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getDocumento_usuario_denuncia())==null) 
            {    
             statement=
                    c.prepareStatement("insert into usuario_denuncia values(?,?,?,?,?,?,?,?)");
            
            statement.setString(1, entity.getDocumento_usuario_denuncia());
            statement.setString(2, entity.getNombres());
            statement.setString(3, entity.getApellido1());
            statement.setString(4, entity.getApellido2());
            statement.setDate(5, entity.getFecha_nacimiento());
            statement.setString(6, entity.getDireccion());
            statement.setString(7, entity.getTelefono());
            statement.setString(8, entity.getCorreo());
            }
            else
            {
                 statement=
                    c.prepareStatement("update  usuario_denuncia set Documento_usuario_denuncia=?, nombres=?,apellido1=?,apellido2=?,Fecha_nacimiento=?,Direccion=?,Telefono=?,Correo=? where Documento_usuario_denuncia=?");
            statement.setString(1, entity.getDocumento_usuario_denuncia());
            statement.setString(2, entity.getNombres());
            statement.setString(3, entity.getApellido1());
            statement.setString(4, entity.getApellido2());
            statement.setDate(5, entity.getFecha_nacimiento());
            statement.setString(6, entity.getDireccion());
            statement.setString(7, entity.getTelefono());
            statement.setString(8, entity.getCorreo());
            statement.setString(9, entity.getDocumento_usuario_denuncia());
            }    
            
            exito = statement.execute();
            
            exito=true;
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(usuario_denunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        return exito;
    }
    @Override
    public void delete(usuario_denuncia entity) {
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from usuario_denuncia where Documento_usuario_denuncia=?");
            
            statement.setString(1, entity.getDocumento_usuario_denuncia());
           
            
            statement.execute();
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(usuario_denunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    @Override
    public usuario_denuncia findById(Object id) {
         usuario_denuncia entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select Documento_usuario_denuncia, nombres,apellido1,apellido2,Fecha_nacimiento,Direccion,Telefono,Correo  from usuario_denuncia where Documento_usuario_denuncia=?"
                    );
            statement.setString(1, (String)id);
            
            ResultSet results =  statement.executeQuery();
            if(results.next())
            {
                entity = new usuario_denuncia();
                 entity.setDocumento_usuario_denuncia(results.getString(1));
                 entity.setNombres(results.getString(2));
                 entity.setApellido1(results.getString(3));
                 entity.setApellido2(results.getString(4));
                 entity.setFecha_nacimiento(results.getDate(5));
                 entity.setDireccion(results.getString(6));
                 entity.setTelefono(results.getString(7));
                 entity.setCorreo(results.getString(8));
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(usuario_denunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entity;
    }

    @Override
    public ArrayList<usuario_denuncia> findAll(){
        ArrayList<usuario_denuncia> entities = new ArrayList<usuario_denuncia>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select Documento_usuario_denuncia, nombres,apellido1,apellido2,Fecha_nacimiento,Direccion,Telefono,Correo  from usuario_denuncia"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 usuario_denuncia entity = new usuario_denuncia();
                 entity.setDocumento_usuario_denuncia(results.getString(1));
                 entity.setNombres(results.getString(2));
                 entity.setApellido1(results.getString(3));
                 entity.setApellido2(results.getString(4));
                 entity.setFecha_nacimiento(results.getDate(5));
                 entity.setTelefono(results.getString(6));
                 entity.setDireccion(results.getString(7));
                 entity.setCorreo(results.getString(8));
                 entities.add(entity);
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(usuario_denunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entities;
    }
    
    public static void  main(String args[]) {
        usuario_denuncia a=new usuario_denuncia();
        a.setDocumento_usuario_denuncia("12345");
        a.setNombres("jose Bonifacio");
        a.setApellido1("elias");
        a.setApellido2("parra");
        //a.setFecha_nacimiento(null);
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf=new  java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(date);
        a.setDireccion("calle 135 # 45-54");
        a.setTelefono("6754895");
        a.setCorreo("jose124@hotmail.com");
        usuario_denunciaDAO w=new usuario_denunciaDAO();
        w.save(a);
    }
}
