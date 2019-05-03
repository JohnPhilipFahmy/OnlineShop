/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classses;

import daoClasses.OrderItemDAO;
import java.util.List;
import orm.OrderItem;

/**
 *
 * @author hp
 */
public class OrderItemBL {

    OrderItemDAO orderItemDAO = new OrderItemDAO();
    
    public List<OrderItem> findByFKOrder(int fkOrder) {
        List<OrderItem> orderItems = orderItemDAO.findByFKOrder(fkOrder);
        return orderItems;
    }
    
    public List<OrderItem> findByFKOrderWithItems(int fkOrder) {
        List<OrderItem> orderItems = orderItemDAO.findByFKOrder(fkOrder);
        
        return orderItems;
    }
    
    
}
