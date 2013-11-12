/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidades;

/**
 *
 * @author JHONATAN
 */
public class Tipodocumento {
    int Id_documento;
    String nombre,descripcion;

    public Tipodocumento(int Id_documento, String nombre, String descripcion) {
        this.Id_documento = Id_documento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Tipodocumento() {
    }

    public int getId_documento() {
        return Id_documento;
    }

    public void setId_documento(int Id_documento) {
        this.Id_documento = Id_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "tipodocumento{" + "Id_documento=" + Id_documento + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    

}
