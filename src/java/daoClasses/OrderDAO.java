package daoClasses;

import Sql.SqlConn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import orm.Order;

public class OrderDAO {
    
    private static final String TB_ORDER = "ORDEER";
    private static final String COL_ID = "ID";
    private static final String COL_status = "status";
    private static final String COL_time = "TIME";
    private static final String COL_USER_ID = "USER_ID";
    Sql.SqlConn sql;

    public OrderDAO() throws ClassNotFoundException {
        this.sql = new SqlConn();
    }
    
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM " + TB_ORDER;
        try {
            ResultSet rs = sql.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(COL_ID);
                    boolean orderStatus = rs.getBoolean(COL_status);
                    String timeOfOrder = rs.getString(COL_time);
                    int userId = rs.getInt(COL_USER_ID);
                    Order order = new Order(id, userId, orderStatus, timeOfOrder) ;
                    orders.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    public Order find(int id) {
        String query = "SELECT * FROM " + TB_ORDER + " WHERE " + COL_ID + "=" + id;
        try {
            ResultSet rs = sql.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    boolean orderStatus = rs.getBoolean(COL_status);
                    String timeOfOrder = rs.getString(COL_time);
                    int userId = rs.getInt(COL_USER_ID);
                    Order order = new Order(id, userId, orderStatus, timeOfOrder);
                    return order;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public List<Order> findByUserId(int userId) {
         List<Order> orders=new ArrayList<>();
         
        String query = "SELECT * FROM " + TB_ORDER + " WHERE " + COL_USER_ID + "=" + userId;
        try {
            ResultSet rs = sql.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    boolean orderStatus = rs.getBoolean(COL_status);
                    String timeOfOrder = rs.getString(COL_time);
                    
                    Order order = new Order( userId, orderStatus, timeOfOrder);
                    orders.add(order);
                    return orders;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Order create(Order order) {
        System.out.println("msh.mabrook");
        String query = "INSERT INTO " + TB_ORDER + "(" + COL_status + "," + COL_time + "," + COL_USER_ID + ") "
                + "VALUES('" + order.isOrderStatus() + "','" + order.getTimeOfOrder() + "','" + order.getUSER_ID() + "')";
        System.out.println("mabrook");
        sql.executeUpdate(query);
        
        query = "SELECT \n"
                + "    last_insert_id() as id\n"
                + "FROM\n"
                + "    information_schema.TABLES\n"
                + "WHERE\n"
                + "    TABLE_SCHEMA = 'shop-database'\n"
                + "        AND TABLE_NAME = '" + TB_ORDER + "'";
        try {
            ResultSet rs = sql.executeQuery(query);
            if (rs.next()) {
                order.setOrderId(rs.getInt("id"));
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
    
    public void update(Order order) {
        String query = "UPDATE " + TB_ORDER + " "
                + "SET " + COL_status + " = '" + order.isOrderStatus() + "'"
                + "," + COL_time + " = '" + order.getTimeOfOrder() + "' "
                + "," + COL_USER_ID + " = '" + order.getUSER_ID() + "' "
                + "WHERE " + COL_ID + " = " + order.getOrderId();
        sql.executeUpdate(query);
    }
    
    public void delete(int id) {
        String query = "DELETE FROM" + TB_ORDER + " "
                + "WHERE " + COL_ID + " = '" + id;
        sql.executeQuery(query);
    }
    
}
