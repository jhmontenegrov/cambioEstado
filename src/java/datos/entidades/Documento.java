/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidades;

/**
 *
 * @author 201
 */
public class Documento {
    private int id_documento, id_tipo_documento,id_denuncia,id_estado;
    private String no_doumento;
    private String  documento_funcionario;
    private String documento_usuario_reporta;
    private String documen_usuario_denuncia;

    public Documento(int id_documento, int id_tipo_documento, int id_denuncia, int id_estado, String no_doumento, String documento_funcionario, String documento_usuario_reporta, String documen_usuario_denuncia) {
        this.id_documento = id_documento;
        this.id_tipo_documento = id_tipo_documento;
        this.id_denuncia = id_denuncia;
        this.id_estado = id_estado;
        this.no_doumento = no_doumento;
        this.documento_funcionario = documento_funcionario;
        this.documento_usuario_reporta = documento_usuario_reporta;
        this.documen_usuario_denuncia = documen_usuario_denuncia;
    }

    public Documento() {
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public int getId_denuncia() {
        return id_denuncia;
    }

    public void setId_denuncia(int id_denuncia) {
        this.id_denuncia = id_denuncia;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNo_doumento() {
        return no_doumento;
    }

    public void setNo_doumento(String no_doumento) {
        this.no_doumento = no_doumento;
    }

    public String getDocumento_funcionario() {
        return documento_funcionario;
    }

    public void setDocumento_funcionario(String documento_funcionario) {
        this.documento_funcionario = documento_funcionario;
    }

    public String getDocumento_usuario_reporta() {
        return documento_usuario_reporta;
    }

    public void setDocumento_usuario_reporta(String documento_usuario_reporta) {
        this.documento_usuario_reporta = documento_usuario_reporta;
    }

    public String getDocumen_usuario_denuncia() {
        return documen_usuario_denuncia;
    }

    public void setDocumen_usuario_denuncia(String documen_usuario_denuncia) {
        this.documen_usuario_denuncia = documen_usuario_denuncia;
    }

    @Override
    public String toString() {
        return "Documento{" + "id_documento=" + id_documento + ", id_tipo_documento=" + id_tipo_documento + ", id_denuncia=" + id_denuncia + ", id_estado=" + id_estado + ", no_doumento=" + no_doumento + ", documento_funcionario=" + documento_funcionario + ", documento_usuario_reporta=" + documento_usuario_reporta + ", documen_usuario_denuncia=" + documen_usuario_denuncia + '}';
    }

    
    
    
}
