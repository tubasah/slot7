/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cart;
import Model.ItemInCart;
import connectSQLServer.DatabaseConnection;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class CartDAO extends DatabaseConnection {

    private Connection connection;

    public CartDAO() {
        connection = DatabaseConnection.getConnection();
    }
    public void deleteItemInCart(Object id){
        try {
            String sql="DELETE\n" +
                    "\n" +
                    "  FROM [SWP391].[dbo].[ShoppingCartItem]\n" +
                    "  WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ItemInCart getOneProductinCartByIdAndUpdateQuantity(Object id,int quantity){
        try {
            updateQuantityInCartItem(id, quantity);
            String sql="SELECT ShoppingCartItem.id,ShoppingCart.user_id,ShoppingCartItem.cart_id,ShoppingCartItem.product_id,ShoppingCartItem.item_quantity,ProductInfo.seller_id,ProductInfo.product_name,ProductInfo.product_image,ProductInfo.product_available,ProductInfo.product_price,requestSetRole.shopName\n" +
"From ShoppingCartItem\n" +
"JOIN ProductInfo ON ProductInfo.product_id=ShoppingCartItem.product_id\n" +
"JOIN ShoppingCart ON ShoppingCart.id=ShoppingCartItem.cart_id\n" +
"LEFT JOIN requestSetRole ON requestSetRole.user_id=ProductInfo.seller_id\n" +
"WHERE ShoppingCartItem.id=?;";
            ArrayList<ItemInCart> list=new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs=ps.executeQuery();
            rs.next();
             Object userid=rs.getObject(1);
             Object cartid=rs.getObject(3);
             Object productid=rs.getObject(4);
             Object sellerid=rs.getObject(6);
             String productname=rs.getString(7);
             String productimg=rs.getString(8);
             int avai =rs.getInt(9);
        
double price=rs.getDouble(10);
             String shopname=rs.getString(11);
             ItemInCart item=new ItemInCart(id, cartid, productid, quantity,userid, sellerid, productname, productimg, price,shopname);
         
            
            return item;
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;       
    }
    public void updateQuantityInCartItem(Object id,int quantity){
        try {
            String sql="Update ShoppingCartItem\n" +
                    "SET ShoppingCartItem.item_quantity=?\n" +
                    "WHERE ShoppingCartItem.id=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setObject(2, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addCart(Object userid,Object productid,int quantity,int productavai){
        Object cartid=getIdCartByUserID(userid);
        if(cartid==null){
            try {
                String sql="INSERT INTO ShoppingCart(user_id) Values(?);";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setObject(1, userid);
                ps.execute();
                cartid=getIdCartByUserID(userid);
                String sql1="INSERT INTO ShoppingCartItem(product_id,item_quantity,cart_id) Values(?,?,?);";
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                 ps1.setObject(1, productid);
                 ps1.setInt(2, quantity);
                 ps1.setObject(3, cartid);
                 ps1.execute();
            } catch (SQLException ex) {
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        }
        if(cartid!=null){
            try {
                ItemInCart itemincart=getOneProductinCart(cartid, productid);
                if(itemincart!=null){
                    
                int quantityindtb=itemincart.getQuantity();
                if(quantityindtb+quantity<=productavai){
                String sql="UPDATE ShoppingCartItem SET item_quantity=? WHERE product_id=? AND cart_id=?   ";
                 PreparedStatement ps = connection.prepareStatement(sql);
                 ps.setObject(2, productid);
                 ps.setInt(1, (quantity+quantityindtb));
                 ps.setObject(3, cartid);
                  ps.execute();
                }
                if(quantityindtb+quantity>productavai){
                String sql="UPDATE ShoppingCartItem SET item_quantity=? WHERE product_id=? AND cart_id=?   ";
                 PreparedStatement ps = connection.prepareStatement(sql);
                 ps.setObject(2, productid);
                 ps.setInt(1, productavai);
                 ps.setObject(3, cartid);
                  ps.execute();
                }
                        
                }
                else{
      String sql1="INSERT INTO ShoppingCartItem(product_id,item_quantity,cart_id) Values(?,?,?);";
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                 ps1.setObject(1, productid);
                 ps1.setInt(2, quantity);
                 ps1.setObject(3, cartid);
                  ps1.execute();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        }
       
    }
     public Object getIdCartByUserID(Object userid){
        try {
            String sql="SELECT *\n" +
                    "  FROM [SWP391].[dbo].[ShoppingCart]\n" +
                    "  WHERE user_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, userid);
            ResultSet rs=ps.executeQuery();
            rs.next();
            Object id=rs.getObject(1);
            return id;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;       
    }
        public ItemInCart getOneProductinCart(Object cartid,Object productid){
        try {
            String sql="SELECT *\n" +
                    "  FROM [SWP391].[dbo].[ShoppingCartItem]\n" +
                    "  WHERE cart_id=? AND product_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, cartid);
            ps.setObject(2, productid);
            ResultSet rs=ps.executeQuery();
            rs.next();
             int quantity=rs.getInt(4);
             Object id=rs.getObject(1);
            return new ItemInCart(id, cartid, productid, quantity);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;       
    }
        public ArrayList<ItemInCart> getAllProductinCartofUserID(Object userid){
        try {
            updatequantitytheothoigian(userid);
            String sql="SELECT ShoppingCartItem.id,ShoppingCart.user_id,ShoppingCartItem.cart_id,ShoppingCartItem.product_id,ShoppingCartItem.item_quantity,ProductInfo.seller_id,ProductInfo.product_name,ProductInfo.product_image,ProductInfo.product_available,ProductInfo.product_price,requestSetRole.shopName\n" +
"From ShoppingCartItem\n" +
"JOIN ProductInfo ON ProductInfo.product_id=ShoppingCartItem.product_id\n" +
"JOIN ShoppingCart ON ShoppingCart.id=ShoppingCartItem.cart_id\n" +
"LEFT JOIN requestSetRole ON requestSetRole.user_id=ProductInfo.seller_id\n" +
"WHERE ShoppingCart.user_id=? ORDER BY seller_id ASC;";
            ArrayList<ItemInCart> list=new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, userid);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
             Object id=rs.getObject(1);
             Object cartid=rs.getObject(3);
             Object productid=rs.getObject(4);
             int quantity=rs.getInt(5);
             Object sellerid=rs.getObject(6);
             String productname=rs.getString(7);
             String productimg=rs.getString(8);
             int avai =rs.getInt(9);
        
double price=rs.getDouble(10);
             String shopname=rs.getString(11);
             ItemInCart item=new ItemInCart(id, cartid, productid, quantity,userid, sellerid, productname, productimg, price,shopname);
          list.add(item);
            }
            return list;
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;       
    }
        public void updatequantitytheothoigian(Object userid){
        try {
            String sql="UPDATE ShoppingCartItem\n" +
                    "SET item_quantity = product_available\n" +
                    "FROM ShoppingCartItem\n" +
                    "JOIN ProductInfo ON ProductInfo.product_id = ShoppingCartItem.product_id\n" +
                    "JOIN ShoppingCart ON ShoppingCart.id = ShoppingCartItem.cart_id\n" +
                    "WHERE ShoppingCart.user_id = ? AND item_quantity > product_available;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, userid);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                    
            
        }
         
     
     public static void main(String[] args) {
         CartDAO dao=new CartDAO();
       ArrayList<ItemInCart> list=dao.getAllProductinCartofUserID("C23C4CD4-ADA9-436B-8A02-1D992ED07104");
         System.out.println(list);
    }
}
