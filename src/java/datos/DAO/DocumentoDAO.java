/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;
import datos.configuracion.Conexion;
import datos.entidades.Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 201
 */
public class DocumentoDAO implements DAOInterface<Documento>{
    @Override
    public boolean save(Documento entity) {
    String sql="";
         boolean exito = false; 
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getId_documento())==null){    
                statement=c.prepareStatement("insert into documento values(?,?,?,?,?,?,?,?)");
                statement.setInt(1, entity.getId_documento());
                statement.setString(2, entity.getNo_doumento());
                statement.setInt(3, entity.getId_tipo_documento());
                statement.setInt(4, entity.getId_denuncia());
                statement.setString(5, entity.getDocumento_funcionario());
                statement.setString(6, entity.getDocumento_usuario_reporta());
                statement.setString(7, entity.getDocumen_usuario_denuncia());
                statement.setInt(8, entity.getId_estado());
            }else{
                 statement=c.prepareStatement("update  documento set id_documento=?, no_documento=?,id_tipo_documento=?,id_denuncia=?,documento_funcionario=? documento_usuario_reporta=?, documento_usuario_denuncia=?, id_estado=? where id_documento=?");
                 statement.setInt(1, entity.getId_documento());
                 statement.setString(2, entity.getNo_doumento());
                 statement.setInt(3, entity.getId_tipo_documento());
                 statement.setInt(4, entity.getId_denuncia());
                 statement.setString(5, entity.getDocumento_funcionario());
                 statement.setString(6, entity.getDocumento_usuario_reporta());
                 statement.setString(7, entity.getDocumen_usuario_denuncia());
                 statement.setInt(8, entity.getId_estado());
                 statement.setInt(9, entity.getId_documento());
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
    public void delete(Documento entity) {
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=c.prepareStatement("delete from Documento where id_documento=?");
            statement.setInt(1, entity.getId_documento());
            statement.execute();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    @Override
    public Documento findById(Object id) {
        Documento entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("select id_documento, no_documento,id_tipo_documento,id_denuncia,documento_funcionario, documento_usuario_reporta,  documento_usuario_denuncia,id_estado where numero_documento=?");
            statement.setInt(1, (Integer)id);
            ResultSet results=statement.executeQuery();
            if(results.next()){
                entity = new Documento();
                entity.setId_documento(results.getInt(1));
                entity.setNo_doumento(results.getString(2));
                entity.setId_tipo_documento(results.getInt(3));
                entity.setId_denuncia(results.getInt(4));
                entity.setDocumento_funcionario(results.getString(5));
                entity.setDocumento_usuario_reporta(results.getString(6));
                entity.setDocumen_usuario_denuncia(results.getString(7));
            }    
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return entity;
    }
    @Override
    public ArrayList<Documento> findAll() {
        ArrayList<Documento> entities = new ArrayList<Documento>();
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=c.prepareStatement("select id_tipo, nombre,descripcion from tipo_documento");
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 Documento entity = new Documento();
                 entity.setId_documento(results.getInt(1));
                 entity.setNo_doumento(results.getString(2));
                 entity.setId_tipo_documento(results.getInt(3));
                 entity.setId_denuncia(results.getInt(4));
                 entity.setDocumento_funcionario(results.getString(5));
                 entity.setDocumento_usuario_reporta(results.getString(6));
                 entity.setDocumen_usuario_denuncia(results.getString(7));
                 entities.add(entity);
            }    
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(tipodocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return entities;
    }
 public static void main(String args[]){
        Documento docu = new Documento(1, 1, 1, 1,"1075650887", "100565000", "147852369", "15926");
        DocumentoDAO dao=new DocumentoDAO();
        dao.save(docu);
    }
}