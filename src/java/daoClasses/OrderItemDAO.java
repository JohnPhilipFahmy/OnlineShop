/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoClasses;

import Sql.SqlConn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import orm.OrderItem;

/**
 *
 * @author hp
 */
public class OrderItemDAO {
    String TB_Ordeer_Item = "ordeer_item";
    String COL_ID = "ID";
    String COL_ITEM_ID = "Item_id";
    String COL_ORDER_ID = "order_id";
    String COL_QUANTITY = "quantity";
    Sql.SqlConn sql;

    public OrderItemDAO() throws ClassNotFoundException {
        this.sql = new SqlConn();
    }
    

   
    public List<OrderItem> findByFKOrder(int order_id) {
        List<OrderItem> orderItems = new ArrayList<>();
        String query = "SELECT * FROM " + TB_Ordeer_Item+" where order_id="+order_id;
        try {
            ResultSet rs = sql.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {
                             int fkOrder=rs.getInt("order_id");
                    int fkItem = rs.getInt("Item_id");
                    int quantity = rs.getInt("quantity");
                    System.out.println(fkOrder);
                     System.out.println(fkItem);
                      System.out.println(quantity);
                    OrderItem orderItem = new OrderItem( fkOrder,fkItem, quantity);
                    orderItems.add(orderItem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItems;
   
    }
    
     public  void create(OrderItem orderItem) {
        System.out.println("msh.mabrook");
        String query = "INSERT INTO " + TB_Ordeer_Item + "(" + COL_ITEM_ID + "," + COL_ORDER_ID + "," + COL_QUANTITY + ") "
                + "VALUES('" + orderItem.getFkItem() + "','" + orderItem.getFkOrder()+ "','" + orderItem.getQuantity()+ "')";
        System.out.println("mabrook");
        sql.executeUpdate(query);
        
     }
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    

