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
@WebServlet(urlPatterns = {"/AddItem"})
public class AddItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            boolean isOffer;

         String itemName=   request.getParameter("ItemName");
         String price=   request.getParameter("Price");
            String offer=request.getParameter("Offer");
           String priceAfterOffer= request.getParameter("PriceAfterOffer");
           String offerStart= request.getParameter("OfferStart");
           String offerEnd= request.getParameter("OfferEnd");
            String quantity=request.getParameter("quantity");
           String itemType= request.getParameter("ItemTybe");
           String priceUnit= request.getParameter("PriceUnit");
           
           Item item=new Item();
           item.setItemName(itemName);
           item.setPrice(price);
          if(offer.equals(true)){
          isOffer=true;
          
          }
          else{
          isOffer=false;
          
          }
           item.setOffer(isOffer);
           item.setPriceAfterOffer(priceAfterOffer);
      item.setOfferStart(offerStart);
      item.setOfferEnd(offerEnd);
      item.setQuantity(quantity);
      item.setItemTybe(itemType);
      item.setPriceUnit(priceUnit);
       ItemBL itemBL=new ItemBL();
       itemBL.create(item);
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
