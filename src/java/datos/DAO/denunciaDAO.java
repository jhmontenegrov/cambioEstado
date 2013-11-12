/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;
import datos.configuracion.Conexion;
import datos.entidades.denuncia;
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
/**
 *
 * @author JHONATAN
 */
public class denunciaDAO implements DAOInterface<denuncia>{

    @Override
    public boolean save(denuncia entity) {
        String sql="";

        boolean exito = false;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getIdDenuncia())==null)
            {    
                statement=c.prepareStatement("insert into denuncia values(?,?,?,?)");
            statement.setInt(1, entity.getIdDenuncia());
            statement.setDate(2, entity.getFechaDenuncia());
            statement.setDate(3, entity.getFechaPerdida());
            statement.setTime(4, entity.getHoraPerdida());
            }
            else
            {
                statement=c.prepareStatement("update  denuncia set id_denuncia=?, fecha_denuncia=?,fecha_perdida=?,hora_perdida=? where id_denuncia=?");
            statement.setInt(1, entity.getIdDenuncia());
            statement.setDate(2, entity.getFechaDenuncia());
            statement.setDate(3, entity.getFechaPerdida());
            statement.setTime(4, entity.getHoraPerdida());
            statement.setInt(5, entity.getIdDenuncia());
            }
            exito = statement.execute();
            exito=true;
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        return exito;
    }
    @Override
    public void delete(denuncia entity) {
        try {

            Connection c = Conexion.getConexion();

            PreparedStatement statement=
                    c.prepareStatement("delete from denuncia where id_denuncia=?");
            statement.setInt(1, entity.getIdDenuncia());
            statement.execute();
            c.close();
        } catch (SQLException ex) {

            Logger.getLogger(denunciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    @Override
    public denuncia findById(Object id) {
        denuncia entity =null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select  id_denuncia,fecha_denuncia,fecha_perdida,hora_perdida from denuncia where id_denuncia=?");
            statement.setInt(1, (Integer)id);
            ResultSet results =   statement.executeQuery();
            if(results.next()){
                entity = new denuncia();
                 entity.setIdDenuncia(results.getInt(1));
                 entity.setFechaDenuncia(results.getDate(2));
                 entity.setFechaPerdida(results.getDate(3));
                 entity.setHoraPerdida(results.getTime(4));
            }    
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return entity;
    }
    @Override
    public ArrayList<denuncia> findAll() {
        ArrayList<denuncia> entities = new ArrayList<denuncia>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select  id_denuncia,fecha_denuncia,fecha_perdida,hora_perdida from denuncia"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 denuncia entity = new denuncia();
                 entity.setIdDenuncia(results.getInt(1));
                 entity.setFechaDenuncia(results.getDate(2));
                 entity.setFechaPerdida(results.getDate(3));
                 entity.setHoraPerdida(results.getTime(4));
                 entities.add(entity);
            }    
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return entities;
    }
     public static void  main(String args[])
    {
        denuncia x;
        Calendar c=Calendar.getInstance();
        c.set(1999,12,10);
        java.util.Date w=c.getTime();
        java.sql.Date z= new Date(w.getTime());
        Time time=new Time(10, 20, 10); 
        denunciaDAO dao=new denunciaDAO();
       x=new denuncia(123,z,z,time);
        dao.save(x);/* 
       Denuncia j=dao.findById(123);
       
       if(j==null)
        {
        System.out.println("No se encontro a nadie con ese documento");
        }
        else
        {
        System.out.println(j);
        
        */
    /*ArrayList<denuncia> y=dao.findAll();
    for(int i=0;i<y.size();i++)
    {
      System.out.println(y.get(i));
    }*/
    }
}


    
    