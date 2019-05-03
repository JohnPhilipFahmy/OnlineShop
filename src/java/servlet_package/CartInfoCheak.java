package servlet_package;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import orm.Item;

/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/CartInfoCheak"})
public class CartInfoCheak extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Servlet addToCartAction at " + "joooooooo" + "</h1>");

            HttpSession session1 = request.getSession();
            List<Item> items1 = (List<Item>) session1.getAttribute("item");

            int Id = Integer.parseInt(request.getParameter("itemId"));
            //  
            for (Item item : items1) {
                int itemId = item.getItemId();
                if (itemId == Id) {
                    out.println("<h1>Servlet addToCartAction at " + item.getItemId() + "</h1>");
                  item.setItemId(0);
                  item.setPrice("0");
                  item.setQuantity("0");
                   
                }

            }
            out.println("<h1>THE ID  " +request.getParameter("userId") + "</h1>");
            session1.setAttribute("item", items1);
            response.sendRedirect("/Shop/JSP/User/Cart.jsp?userId="+request.getParameter("userId"));

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
        processRequest(request, response);
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
