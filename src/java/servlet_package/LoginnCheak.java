package servlet_package;

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

@WebServlet(urlPatterns = {"/LoginnCheak"})
public class LoginnCheak extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("Email");
            String password = request.getParameter("password");

            UserBL userBL = new UserBL();
            User user = userBL.findByEmailAndPassword(email, password);
            HttpSession session = request.getSession();
          

            session.setAttribute("user", user);
            if (user == null) {
                  out.println("log in servlet   ");
                out.println("nonono");
                
                response.sendRedirect("JSP/LogIn.jsp?validate=false");
            }
            else {
                switch (user.getTybe()) {
                    case User.TYPE_CUSTOMER:
                          
                        response.sendRedirect("JSP/User/DifAndChoosePage.jsp" );
                        break;
                    case User.TYPE_MANAGER:
                        response.sendRedirect("JSP/Admin/AdminIntro.jsp");
                        break;
                    case User.TYPE_DELIVERY:
                        response.sendRedirect("JSP/Delvery/delveryItro.jsp?" );
                        break;
                }
            }
        }
    }

//     <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
