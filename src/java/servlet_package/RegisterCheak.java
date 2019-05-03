package servlet_package;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bl.classses.UserBL;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import orm.User;

/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/RegisterCheak"})
public class RegisterCheak extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String PhoneNumber = request.getParameter("PhoneNumber");
              String Email = request.getParameter("Email");
            String passward = request.getParameter("password");
            String address = request.getParameter("address");
              String userType = request.getParameter("userTybe");
            String gender = request.getParameter("Gender");
      
            User user=new User();
            user.setFirstname(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(PhoneNumber);
            user.setEmail(Email);
            user.setPassword(passward);
            user.setAddress(address);
            user.setTybe(userType);
            user.setGender(gender);
                  out.print(Email);
            UserBL userBL=new UserBL();
            userBL.create(user);
              HttpSession session=request.getSession();
            session.setAttribute("userInfo",user);
              switch (user.getTybe()) {
                    case User.TYPE_CUSTOMER:
                        response.sendRedirect("JSP/User/DifAndChoosePage.jsp");
                        break;
                    case User.TYPE_MANAGER:
                        response.sendRedirect("JSP/Admin/AdminIntro.jsp");
                        break;
                    case User.TYPE_DELIVERY:
                        response.sendRedirect("JSP/Delvery/Orders.jsp");
                        break;
                }
             
            
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
