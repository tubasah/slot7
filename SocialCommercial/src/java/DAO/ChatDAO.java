/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Messenger;
import Model.User;
import connectSQLServer.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ChatDAO extends DatabaseConnection {

    private Connection connection;

    public ChatDAO() {
        connection = DatabaseConnection.getConnection();
    }
    public ArrayList<String> getallnameuser() {
        try {
            String sql = "  SELECT name FROM [SWP391].[dbo].[AppUser]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString(1);
               
                list.add(name);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

  public ArrayList<String> getlistnguoinhantin(Object id){
    try {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT DISTINCT AppUser.name AS [Tên Người Nhắn Tin]\n" +
                     "FROM AppUser\n" +
                     "INNER JOIN UserMessage AS mess\n" +
                     "On AppUser.id = mess.receiver_id OR AppUser.id = mess.sender_id\n" +
                     "WHERE AppUser.id <> ?\n" +
                     "AND (mess.sender_id = ? OR mess.receiver_id = ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, id);
        ps.setObject(2, id); // Gán giá trị của id cho tham số thứ hai
        ps.setObject(3, id); // Gán giá trị của id cho tham số thứ ba
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            list.add(rs.getString(1));
        }
        return list;
    } catch (SQLException ex) {
        Logger.getLogger(ChatDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
  public void sendtinhan(Object id1,Object id2,String content){
        try {
            String sql="INSERT INTO  [SWP391].[dbo].[UserMessage](sender_id,receiver_id,context) \n" +
                    "Values(?,?,?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, id1);
            ps.setObject(2, id2); // Gán giá trị của id cho tham số thứ hai
            ps.setString(3, content);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
 
  }
public ArrayList<Messenger> gettinnhan(Object id1,Object id2){
    try {
        ArrayList<Messenger> list = new ArrayList<>();
        String sql = "SELECT * FROM UserMessage\n" +
"WHERE (sender_id=? AND\n" +
"receiver_id=?)OR receiver_id=? AND sender_id=?\n" +
"ORDER BY message_date";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, id1);
        ps.setObject(2, id2); 
         ps.setObject(3, id1);
        ps.setObject(4, id2);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){ 
            Messenger mes=new Messenger();
            mes.setId(rs.getObject(1));
            mes.setSenderid(rs.getObject(2));
            mes.setReceiverid(rs.getObject(3));
            mes.setContent(rs.getString(4));
            mes.setDate(rs.getTime(5));
            list.add(mes);
         }
        return list;
    } catch (SQLException ex) {
        Logger.getLogger(ChatDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

public Object getidbyname(Object name){
        try {
            String sql="SELECT [id]\n" +
                    "      \n" +
                    "  FROM [SWP391].[dbo].[AppUser]\n" +
                    "  WHERE name=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, name);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    Object id=rs.getObject(1);
                    return id;

        } catch (SQLException ex) {
            Logger.getLogger(ChatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   return null; 
}
    
    public static void main(String[] args) {
        ChatDAO chat=new ChatDAO();
        ArrayList<String> list=new ArrayList<>();
        Object id ="91605443-D6CB-414D-8E67-224B552FAC24";
        Object id1=chat.getidbyname("vinh1");
                Object id2=chat.getidbyname("admin");

        if(id.toString().equals(id1.toString())){
            System.out.println("true");
        }
        list=chat.getallnameuser();
        ArrayList<Messenger> list1=new ArrayList<>();
        list1=chat.gettinnhan(id2,id1);
        System.out.println(list1);
//Object id=chat.getidbyname("vinh");
//        System.out.println(id);
        
        
    }
}

