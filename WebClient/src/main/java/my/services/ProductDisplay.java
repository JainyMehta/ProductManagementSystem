/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.helpers.DisplayProductData;
import my.interfaces.Products;

/**
 *
 * @author Jenny
 */
@WebServlet(name = "ProductDisplay", urlPatterns = {"/ProductDisplay"})
public class ProductDisplay extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductDisplay</title>");            
            out.println("</head>");
            out.println("<body>");
            ProductImplService serv = new ProductImplService();
            IProduct port = serv.getProductImplPort();
            boolean check = port.updateProduct(Integer.parseInt(request.getParameter("pno")),request.getParameter("pname"),request.getParameter("type"),request.getParameter("manufacturer"),Double.parseDouble(request.getParameter("price")),Double.parseDouble(request.getParameter("weight")));
            if(check==true){
               out.println("<h1 style=\"color:green;\">Updation is successful</h1>");
            }else{
                out.println("<h1 style=\"color:red;\">Updation is unsuccessful</h1>");
            }
            out.println("<a href=\"index.jsp\">Go Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void processDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductDisplay</title>");            
            out.println("</head>");
            out.println("<body>");
            ProductImplService serv = new ProductImplService();
            IProduct port = serv.getProductImplPort();
            boolean check = port.deleteProduct(Integer.parseInt(request.getParameter("pno")));
            if(check==true){
               out.println("<h1 style=\"color:green;\">Deletion is successful</h1>");
            }else{
                out.println("<h1 style=\"color:re;\">Deletion is unsuccessful</h1>");
            }
            out.println("<a href=\"index.jsp\">Go Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("update") != null)
        {
            processUpdate(request, response);
        }
        else{
            processDelete(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
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
