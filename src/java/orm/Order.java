package orm;

import java.util.List;

public class Order {

    private int OrderId;
    private int USER_ID;
    private boolean OrderStatus;
    private String TimeOfOrder;
    private List<OrderItem> orderItems;

    
    
     public Order(int OrderId, int USER_ID, boolean OrderStatus, String TimeOfOrder) {
        this.OrderId = OrderId;
        this.OrderStatus = OrderStatus;
        this.TimeOfOrder = TimeOfOrder;
        this.USER_ID=USER_ID;
    }
    
    
    
    
    
    public Order( int USER_ID, boolean OrderStatus, String TimeOfOrder) {
       this.OrderStatus = OrderStatus;
        this.TimeOfOrder = TimeOfOrder;
        this.USER_ID=USER_ID;
    }
public Order()
{

}
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public boolean isOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(boolean OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    public String getTimeOfOrder() {
        return TimeOfOrder;
    }

    public void setTimeOfOrder(String TimeOfOrder) {
        this.TimeOfOrder = TimeOfOrder;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

}
