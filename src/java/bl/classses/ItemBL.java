/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classses;

import daoClasses.ItemDAO;
import java.util.List;
import orm.Item;

/**
 *
 * @author hp
 */
public class ItemBL {

    ItemDAO itemDAO = new ItemDAO();

    public List<Item> finaAll() {
        return itemDAO.finaAll();
    }
    
     public void create(Item item) {
     
     itemDAO.create(item);
     
     }
      public void update(Item item) {
      
      itemDAO.update(item);
      
      
      }
 public void delete(int id) {
 
 itemDAO.delete(id);
 }
  public List<Item> findByName(String name) {
        return itemDAO.findByName(name);
    }
 

}