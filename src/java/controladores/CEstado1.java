/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.DAO.estadoDAO;
import datos.configuracion.Conexion;
import datos.entidades.estado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JHONATAN
 */
@WebServlet(name = "CEstado1", urlPatterns = {"/CEstado1"})
public class CEstado1 extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        String accion = request.getParameter("a");
        try {
            if(Conexion.getConexion()==null){
                out.print("no se pudo establecer conexión");
            }
            else{
                estadoDAO fdao = new estadoDAO();
                if (accion.equals("inicio")){
                dispatcher= request.getRequestDispatcher("WEB-INF/cambiarEstado.jsp");
                dispatcher.forward(request, response);
                }
                if (accion.equals("guardar")){
                    String nuevoestado=request.getParameter("nuevoestado");
                    String buscar=request.getParameter("buscar");
                    int idEstado=Integer.parseInt(buscar);
                    estado f=new estado(nuevoestado,idEstado);
                    fdao.findById(f.getId_estado());
                    fdao.save(f);
                }
            }
        } finally {            
            out.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
