
package orm;


public class OrderItem {

    private int id;
    private int fkOrder;
    private int fkItem;
    private int quantity;
    private Order order;
    private Item item;

    public OrderItem( int fkOrder, int fkItem, int quantity) {
        this.id = id;
        this.fkOrder = fkOrder;
        this.fkItem = fkItem;
        this.quantity = quantity;
    }

    public OrderItem() {
       }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

  
    public int getFkOrder() {
        return fkOrder;
    }

    public void setFkOrder(int fkOrder) {
        this.fkOrder = fkOrder;
    }
  public int getFkItem() {
        return fkItem;
    }
    public void setFkItem(int fkItem) {
        this.fkItem = fkItem;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
