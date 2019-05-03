
package servlet_package;

import bl.classses.ItemBL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import orm.Item;

/**
 *
 * @author hp
 */
@WebServlet(name = "editItemCheack", urlPatterns = {"/editItemCheack"})
public class editItemCheack extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String itemID = request.getParameter("ItemID");
            String itemName = request.getParameter("ItemName");
            String price = request.getParameter("Price");
            String offer = request.getParameter("Offer");
            String priceAfterOffer = request.getParameter("PriceAfterOffer");
            String offerStart = request.getParameter("OfferStart");
            String offerEnd = request.getParameter("OfferEnd");
            String quantity = request.getParameter("quantity");
            String itemTybe = request.getParameter("ItemTybe");
            String priceUnit = request.getParameter("PriceUnit");
            boolean isOffer = false;
            if (offer.equals(true)) {
                isOffer=true;
            }
            else if (offer.equals(false))
            {
            isOffer=false;
            
            }
            Item item = new Item();
            item.setItemId(Integer.parseInt(itemID));
            item.setItemName(itemName);
            item.setItemTybe(itemTybe);
            
            item.setOffer(isOffer);
            item.setOfferEnd(offerEnd);
            item.setOfferStart(offerStart);
            item.setPrice(price);
            item.setPriceAfterOffer(priceAfterOffer);
            item.setPriceUnit(priceUnit);
            item.setQuantity(quantity);
            ItemBL itemBL = new ItemBL();
            itemBL.update(item);
            response.sendRedirect("JSP/User/itemShow_Page.jsp");
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
