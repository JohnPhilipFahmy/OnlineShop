package daoClasses;

import Sql.SqlConn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import orm.User;

public class UserDAO {

    String TB_USER = "user";
    String COL_ID = "ID";
    String COL_PASSWORD = "PASSWORD";
    String COL_ADDRESS = "ADDRESS";
    String COL_MOBILE = "MOBILE";
    String COL_LAST_NAME = "LAST_NAME";
    String COL_FIRST_NAME = "FIRST_NAME";
    String COL_USER_TYBE = "USER_TYBE";
    String COL_Email = "E_mail";
    String COL_Gender = "Gender";

    Sql.SqlConn sql;

    public UserDAO() throws ClassNotFoundException {
        this.sql = new SqlConn();
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            String Query = "SELECT * FROM " + TB_USER;
            ResultSet rs = sql.executeQuery(Query);
            if (rs != null) {
                while (rs.next()) {
                    int UserId = rs.getInt(COL_ID);
                    String Firstname = rs.getString(COL_FIRST_NAME);
                    String LastName = rs.getString(COL_LAST_NAME);
                    String PhoneNumber = rs.getString(COL_MOBILE);
                    String Email = rs.getString(COL_Email);
                    String Password = rs.getString(COL_PASSWORD);
                    String address = rs.getString(COL_ADDRESS);
                    String tybe = rs.getString(COL_USER_TYBE);
                    String gender = rs.getString(COL_Gender);
                    User user = new User(UserId, Firstname, LastName, PhoneNumber, Email, Password, address, tybe, gender);
                    users.add(user);

                }

            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return users;
    }

    public User find(int id) {
        String Query = "SELECT * FROM "+TB_USER+" WHERE " + COL_ID + "= " + id;
        try {
            ResultSet rs = sql.executeQuery(Query);

            if (rs != null) {
                while (rs.next()) {
                    int UserId = rs.getInt(COL_ID);
                    String Firstname = rs.getString(COL_FIRST_NAME);
                    String LastName = rs.getString(COL_LAST_NAME);
                    String PhoneNumber = rs.getString(COL_MOBILE);
                    String Email = rs.getString(COL_Email);
                    String Password = rs.getString(COL_PASSWORD);
                    String address = rs.getString(COL_ADDRESS);
                    String tybe = rs.getString(COL_USER_TYBE);
                    String gender = rs.getString(COL_Gender);
                    User user = new User(UserId, Firstname, LastName, PhoneNumber, Email, Password, address, tybe, gender);
                    return user;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public User findByEmailAndPassword(String email, String password) {
        String Query = "SELECT * FROM " + TB_USER + " WHERE " + COL_Email + " = '" + email + "' "
                + "AND " + COL_PASSWORD + " = '" + password + "'";
        try {
            ResultSet rs = sql.executeQuery(Query);

            if (rs != null) {
                while (rs.next()) {
                    int UserId = rs.getInt(COL_ID);
                    String Firstname = rs.getString(COL_FIRST_NAME);
                    String LastName = rs.getString(COL_LAST_NAME);
                    String PhoneNumber = rs.getString(COL_MOBILE);
                    String Email = rs.getString(COL_Email);
                    String Password = rs.getString(COL_PASSWORD);
                    String address = rs.getString(COL_ADDRESS);
                    String tybe = rs.getString(COL_USER_TYBE);
                    String gender = rs.getString(COL_Gender);
                    User user = new User(UserId, Firstname, LastName, PhoneNumber, Email, Password, address, tybe, gender);
                    return user;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void create(User user){
        String Query = "INSERT INTO " + TB_USER + "(" + COL_PASSWORD + "," + COL_ADDRESS + "," + COL_MOBILE
                + " ," + COL_LAST_NAME + "," + COL_FIRST_NAME + "," + COL_USER_TYBE + "," + COL_Email + "," + COL_Gender + ")"
                + "VALUES('" + user.getPassword() + "','" +user.getAddress() + "','" +user.getPhoneNumber() + "','" +user.getLastName()
              +  "','"+ user.getFirstname()+ "','" +user.getTybe()  + "','" +user.getEmail() + "','" + user.getGender() + "')";
        sql.executeUpdate(Query);

    }

    public void update(User user) {
         System.out.println("suc");
        String Query = "UPDATE " + TB_USER + " "
                + "SET " + COL_PASSWORD + " = '" + user.getPassword() + "'"
                + "," + COL_ADDRESS + " = '" + user.getAddress() + "' "
                + COL_MOBILE + " = '" + user.getPhoneNumber() + "'"
                + "," + COL_LAST_NAME + " = '" + user.getLastName() + "' " + ","
                + COL_FIRST_NAME + " = '" + user.getFirstname()
                + "' " + "," + COL_USER_TYBE + " = '" + user.getTybe() + "' "
                + COL_Email + " = '" + user.getEmail() + "'" + ","
                + COL_Gender + " = '" + user.getGender() + "'" + ","
                + "WHERE " + COL_ID + " = " + user.getUserId();
        sql.executeQuery(Query);
       
    }

    public void delete(int id) {
        User user = null ;
        String Query = "delete  FROM" + TB_USER + "WHERE ID=" + user.getUserId();
        sql.executeQuery(Query);

 
   
}
}