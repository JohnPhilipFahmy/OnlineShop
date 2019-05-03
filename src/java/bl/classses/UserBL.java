
package bl.classses;

import daoClasses.UserDAO;
import orm.User;


public class UserBL {

    UserDAO userDAO = new UserDAO();

    public User findByEmailAndPassword(String email, String password) {
        return userDAO.findByEmailAndPassword(email, password);
    }
    public User find(int id) {
     
     return userDAO.find(id);
     }
     
     
    public User create(User user){
    userDAO.create(user);
        return null;
        
        
      
  
 
     
 }
   
    }

