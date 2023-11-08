
package DAO;


import Model.UserPost;
import connectSQLServer.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserPostDAO {
    List<UserPost> listOfUserPosts = new ArrayList<>();
    
   
    public List<UserPost> getUserPosts() {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try{
            String sql = "select * from UserPost";
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);    
            res = stm.executeQuery();
            while(res.next()){
                Object id = res.getObject("id");
                Object user_id = res.getObject("user_id");
                String post_title = res.getString("post_title");
                String post_content = res.getString("post_content");
                String image = res.getString("post_image");
                Date post_date = res.getDate("post_date");
                
                UserPost userPost = new UserPost(id, user_id, post_title, post_content, image,post_date);
                listOfUserPosts.add(userPost);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                cnt.close();
                stm.close();
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserPostDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOfUserPosts;
    }

    public void addUserPost(Object user_id, String post_title, String post_content, String post_image, Date post_date) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO UserPost (user_id, post_title,"
                    + " post_content, post_image, post_date)"
                    + " VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, user_id);
            stmt.setString(2, post_title);
            stmt.setString(3, post_content);
            stmt.setString(4, post_image);
            stmt.setDate(5, new java.sql.Date(post_date.getTime()));
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

    
    public void EditUserPost(String post_title, String post_content, String post_image, Object id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE UserPost SET post_title = ?,"
                    + " post_content = ?, post_image = ?,"
                    + "post_image = ?, WHERE id = ?";

            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);
            stm.setString(1, post_title);
            stm.setString(2, post_content);
            stm.setString(3, post_image);
            stm.setObject(4, id);

            int rowsUpdated = stm.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Updated successfully.");
            } else {
                System.out.println("Not found with the provided ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating: " + e.getMessage());
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (cnt != null) {
                    cnt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    public void deleteUserPost(Object id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
         try{
            String sql = "delete from UserPost where id = ?";
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
    public static void main(String[] args) {
        UserPostDAO check = new UserPostDAO();
        check.addUserPost("3393C2BB-1630-4184-AD67-9A789CF770DE","ASd","ASd","ASd", new Date());
    }
    
}
