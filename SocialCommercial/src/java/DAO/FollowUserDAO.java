
package DAO;

import Model.FollowUser;
import connectSQLServer.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FollowUserDAO {
    List<FollowUser> listOfFollowUsers = new ArrayList<>();

    public List<FollowUser> getFollowUsers() {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try{
            String sql = "select * from UserFollow";
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);    
            res = stm.executeQuery();
            while(res.next()){
                Object id = res.getObject("id");
                Object follower_id = res.getObject("follower_id");
                Object following_id = res.getObject("following_id");
                
                FollowUser follow = new FollowUser(id, follower_id, following_id);
                listOfFollowUsers.add(follow);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                cnt.close();
                stm.close();
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(FollowUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOfFollowUsers;
    }
    
    public void addFollowUser(Object follower_id, Object following_id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO UserFollow (follower_id, following_id)"
                    + "VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, follower_id);
            stmt.setObject(2, following_id);
            stmt.executeUpdate();
            System.out.println("Inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Error occurred while inserting: " + e.getMessage());
        } finally {
            try {
                
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println("Error occurred while closing database resources: " + e.getMessage());
            }
        }
    }
    
    public void deleteFollow(Object id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
         try{
            String sql = "delete from UserFollow where id = ?";
            cnt = DatabaseConnection.getConnection();
            cnt.setAutoCommit(false);
            stm = cnt.prepareStatement(sql);
            stm.setObject(1,id);
            stm.executeUpdate();
            cnt.commit();
            System.err.println("Delete!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            try{
                cnt.rollback();
            }catch(SQLException e1){
                e1.printStackTrace();
            }
        }finally{
            try{
                if (cnt != null){
                   cnt.close();
               }
               if (stm != null){
                   stm.close();
               }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public void removeFollow(Object follower_id, Object following_id){
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
         try{
            String sql = "delete from UserFollow where follower_id = ? and following_id = ?";
            cnt = DatabaseConnection.getConnection();
            cnt.setAutoCommit(false);
            stm = cnt.prepareStatement(sql);
            stm.setObject(1,follower_id);
            stm.setObject(2,following_id);
            stm.executeUpdate();
            cnt.commit();
            System.err.println("Delete!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            try{
                cnt.rollback();
            }catch(SQLException e1){
                e1.printStackTrace();
            }
        }finally{
            try{
                if (cnt != null){
                   cnt.close();
               }
               if (stm != null){
                   stm.close();
               }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public boolean checkFollow(Object my_id, Object friend_id){
        boolean check = false;
        for(FollowUser fl : listOfFollowUsers){
            if(my_id.toString().toLowerCase().equals(fl.getFollower().toString().toLowerCase())
        && friend_id.toString().toLowerCase().equals(fl.getFollowing().toString().toLowerCase())){
                check = true;
                break;
            }
        }
        return check;
    }
    
  
    public static void main(String[] args) {
        FollowUserDAO fl = new FollowUserDAO();
      
//        fl.removeFollow("41EAB62F-A954-4AAB-B7C4-6F11D301D2D0", "3393C2BB-1630-4184-AD67-9A789CF770DE");
    }
}
