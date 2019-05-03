
package bl.classses;

import daoClasses.OrderDAO;
import daoClasses.OrderItemDAO;
import java.util.List;
import orm.Order;
import orm.OrderItem;

/**
 *
 * @author hp
 */
public class OrderBL {

    OrderDAO orderDAO = new OrderDAO();
    OrderItemDAO orderItemDAO = new OrderItemDAO();

    public List<Order> findAll() {
        List<Order> orders = orderDAO.findAll();
        return orders;
    }

    public Order find(int id) {
        Order order = orderDAO.find(id);
        System.out.println(order.getOrderId());
        List<OrderItem> orderItems = orderItemDAO.findByFKOrder(id);
        order.setOrderItems(orderItems);
        return order;
    }
    public List<Order> findByUserId(int userId){
        List<Order> orders = orderDAO.findAll();
    return orders;
    
    
    }
    
    public void update(Order order) {
        OrderDAO orderDAO=new OrderDAO();
                orderDAO.update(order);
    }
  
    public Order create(Order order) {
        OrderDAO orderDAO = new OrderDAO();
 orderDAO.create(order);
      return order;
      
    }
}
