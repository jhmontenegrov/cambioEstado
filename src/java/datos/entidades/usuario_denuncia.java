/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidades;

import java.sql.Date;

/**
 *
 * @author JHONATAN
 */
public class usuario_denuncia {
    String documento_usuario_denuncia, nombres, apellido1, apellido2,direccion, telefono, correo;
    Date fecha_nacimiento;

    public usuario_denuncia(String documento_usuario_denuncia, String nombres, String apellido1, String apellido2, String direccion, String telefono, String correo, Date fecha_nacimiento) {
        this.documento_usuario_denuncia = documento_usuario_denuncia;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public usuario_denuncia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDocumento_usuario_denuncia() {
        return documento_usuario_denuncia;
    }

    public void setDocumento_usuario_denuncia(String documento_usuario_denuncia) {
        this.documento_usuario_denuncia = documento_usuario_denuncia;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "usuario_denuncia{" + "documento_usuario_denuncia=" + documento_usuario_denuncia + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
}
