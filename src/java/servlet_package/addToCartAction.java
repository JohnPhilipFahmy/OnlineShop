package servlet_package;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import orm.Item;

@WebServlet(name = "addToCartAction", urlPatterns = {"/addToCartAction"})
public class addToCartAction extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            List<Item> items = new ArrayList<>();
            List<Item> items1 = new ArrayList<>();
            HttpSession session = request.getSession();

            items = (List<Item>) session.getAttribute("item");

            int itemId = Integer.parseInt(request.getParameter("itemId"));
            String itemName = request.getParameter("itemName");
             String userId = request.getParameter("userId");
               System.out.println("THEuserId");
               System.out.println(userId);
            String itemPrice = request.getParameter("itemPrice");
            String count = request.getParameter("count");

            Item item = new Item(itemId, itemName, itemPrice, count);

        
            items1.add(item);

            if (items != null) {
                for (Item item1 : items) {

                    items1.add(item1);
//             

                }
            }
          
            session.setAttribute("item", items1);
            response.sendRedirect("/Shop/JSP/User/DifAndChoosePage.jsp?userId="+userId);
           
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
