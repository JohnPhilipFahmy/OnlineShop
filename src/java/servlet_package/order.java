/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_package;

import bl.classses.OrderBL;

import daoClasses.OrderItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import orm.Item;
import orm.Order;
import orm.OrderItem;
import orm.User;

/**
 *
 * @author hp
 */
@WebServlet(name = "order", urlPatterns = {"/order"})
public class order extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

//            int userId = Integer.parseInt(request.getParameter("userId"));
//            out.println("<h1>Servlet order at " + request.getContextPath() + "</h1>");
            
           HttpSession session=request.getSession();
            List<Item> items1 = (List<Item>)  session.getAttribute("item");
            
             DateFormat dateFormat = new SimpleDateFormat(" HH:mm");
	Date date = new Date();
	
        
            User user=(User)session.getAttribute("user");
            Order order=new Order(user.getUserId() , false, dateFormat.format(date));
          
            
            OrderBL orderBL=new  OrderBL();
            Order order1= orderBL.create(order);
            order1.getOrderId();
            session.setAttribute("order", items1);
            
              for(Item item:items1 )
           {
               if(item.getItemId() !=0){
                  
               OrderItem orderItem=new OrderItem(order1.getOrderId(), item.getItemId(),Integer.parseInt(item.getQuantity()) );
                   OrderItemDAO orderItemDAO=new OrderItemDAO();
                   orderItemDAO.create(orderItem);
        
                      
        
                      }}
           
             response.sendRedirect("JSP/User/Order.jsp");

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
