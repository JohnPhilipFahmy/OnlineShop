package daoClasses;

import Sql.SqlConn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import orm.Item;

public class ItemDAO {

    String TB_Item = "item";
    String COL_ID = "ID";
    String COL_TYBE = "TYBE";
    String COL_PRICE = "PRICE";
    String COL_IS_OFFER = "is_offer";
    String COL_OFER_START_TIME = "OFER_START_TIME";
    String COL_OFER_END_TIME = "OFER_END_TIME";
    String COL_PRICE_IN_OFFER = "PRICE_IN_OFFER";
    String COL_QUANTITY = "QUANTITY";
    String COL_PRICE_UNIT = "PRICE_UNIT";
    String COL_name = "name";
    Sql.SqlConn sql;

    public ItemDAO() throws ClassNotFoundException {
        this.sql = new SqlConn();
    }

    public List<Item> finaAll() {

        List<Item> items = new ArrayList<>();
        String Query = "SELECT * FROM " + TB_Item;
        try {
            ResultSet rs = sql.executeQuery(Query);
            if (rs != null) {
                while (rs.next()) {
                    int ItemId = rs.getInt(COL_ID);
                    String ItemTybe = rs.getString(COL_TYBE);
                    String ItemName = rs.getString(COL_name);
                    String Price = rs.getString(COL_PRICE);
                    boolean Offer = rs.getBoolean(COL_IS_OFFER);
                    String PriceAfterOffer = rs.getString(COL_PRICE_IN_OFFER);

                    String PriceUnit = rs.getString(COL_PRICE_UNIT);
                    String OfferStart = rs.getString(COL_OFER_START_TIME);
                    String OfferEnd = rs.getString(COL_OFER_END_TIME);
                    String quantity = rs.getString(COL_QUANTITY);
                    Item item = new Item(ItemId, ItemName, ItemTybe, Price, Offer, PriceAfterOffer, PriceUnit, OfferStart, OfferEnd, quantity);
                    items.add(item);

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return items;

    }

    public Item find(int id) {
        String Query = "SELECT * FROM ITEM WHERE ID=" + id;
        try {
            ResultSet rs = sql.executeQuery(Query);
            if (rs != null) {
                while (rs.next()) {
                    int ItemId = rs.getInt(COL_ID);
                    String ItemTybe = rs.getString(COL_TYBE);
                    String ItemName = rs.getString(COL_name);
                    String Price = rs.getString(COL_PRICE);
                    boolean Offer = rs.getBoolean(COL_IS_OFFER);
                    String PriceAfterOffer = rs.getString(COL_PRICE_IN_OFFER);

                    String PriceUnit = rs.getString(COL_PRICE_UNIT);
                    String OfferStart = rs.getString(COL_OFER_START_TIME);
                    String OfferEnd = rs.getString(COL_OFER_END_TIME);
                    String quantity = rs.getString(COL_QUANTITY);
                    Item item = new Item(ItemId, ItemName, ItemTybe, Price, Offer, PriceAfterOffer, PriceUnit, OfferStart, OfferEnd, quantity);
                    return item;

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List<Item> findByName(String name) {
          List<Item> items = new ArrayList<>();
        String Query = "SELECT * FROM ITEM WHERE Name='" + name+"'";
        try {
          
            ResultSet rs = sql.executeQuery(Query);
            if (rs != null) {
                while (rs.next()) {
                    int ItemId = rs.getInt(COL_ID);
                    String ItemTybe = rs.getString(COL_TYBE);
                    String ItemName = rs.getString(COL_name);
                    String Price = rs.getString(COL_PRICE);
                    boolean Offer = rs.getBoolean(COL_IS_OFFER);
                    String PriceAfterOffer = rs.getString(COL_PRICE_IN_OFFER);
                    String PriceUnit = rs.getString(COL_PRICE_UNIT);
                    String OfferStart = rs.getString(COL_OFER_START_TIME);
                    String OfferEnd = rs.getString(COL_OFER_END_TIME);
                    String quantity = rs.getString(COL_QUANTITY);
                    Item item = new Item(ItemId, ItemName, ItemTybe, Price, Offer, PriceAfterOffer, PriceUnit, OfferStart, OfferEnd, quantity);
                    items.add(item);
                 

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

           return items;
    }

    public void create(Item item) {
        String Query = "INSERT INTO " + TB_Item + "(" + COL_TYBE + "," + COL_PRICE + "," + COL_OFER_END_TIME
                + " ," + COL_PRICE_IN_OFFER + "," + COL_QUANTITY + "," + COL_PRICE_UNIT + "," + COL_name + "," + COL_OFER_START_TIME + "," + COL_IS_OFFER + ")"
                + "VALUES('" + item.getItemTybe() + "','" + item.getPrice() + "','" + item.getOfferEnd() + "','" + item.getPriceAfterOffer()
                + "','" + item.getQuantity() + "','" + item.getPriceUnit() + "','" + item.getItemName() + "','" + item.getOfferStart() + "','" + item.isOffer() + "');";
        sql.executeUpdate(Query);
    }

    public void update(Item item) {
        String Query = "UPDATE " + TB_Item + " "
                + "SET " + COL_TYBE + " = '" + item.getItemTybe() + "'"
                + "," + COL_PRICE + " = '" + item.getPrice() + "' ,"
                + COL_OFER_END_TIME + " = '" + item.getOfferEnd() + "'"
                + "," + COL_PRICE_IN_OFFER + " = '" + item.getPriceAfterOffer() + "' " + ","
                + COL_IS_OFFER + " = '" + item.isOffer() + "' " + ","
                + COL_OFER_START_TIME + "='" + item.getOfferStart() + "',"
                + COL_name + "='" + item.getItemName() + "',"
                + COL_PRICE_IN_OFFER + " = '" + item.getPriceAfterOffer()
                + "' " + "," + COL_QUANTITY + " = '" + item.getQuantity() + "' ,"
                + COL_PRICE_UNIT + " = '" + item.getPriceUnit() + "'"
                + "WHERE " + COL_ID + " = " + item.getItemId();

        sql.executeUpdate(Query);

    }

    public void delete(int id) {

        String Query = "delete from " + TB_Item + " WHERE ID =  " + id;
        sql.executeUpdate(Query);

    }

}
