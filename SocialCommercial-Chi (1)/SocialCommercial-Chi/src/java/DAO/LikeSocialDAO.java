
package DAO;


import Model.LikeSocial;
import connectSQLServer.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LikeSocialDAO {
    List<LikeSocial> listOfLikeSocials = new ArrayList<>();

    public List<LikeSocial> getLikeSocials() {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try{
            String sql = "select * from SocialLike";
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);    
            res = stm.executeQuery();
            while(res.next()){
                Object id = res.getObject("id");
                Object post_id = res.getObject("post_id");
                String liker_id = res.getString("liker_id");
                
                LikeSocial likePost = new LikeSocial(id, post_id, liker_id);
                listOfLikeSocials.add(likePost);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                cnt.close();
                stm.close();
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(LikeSocialDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOfLikeSocials;
    }

    public void addLikePost(Object post_id, Object liker_id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO SocialLike (post_id, liker_id)"
                    + "VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, post_id);
            stmt.setObject(2, liker_id);
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


    public void deleteLikePost(Object id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
         try{
            String sql = "delete from SocialLike where id = ?";
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
    
    public void removeLikePost(Object post_id, Object liker_id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
         try{
            String sql = "delete from SocialLike where post_id = ? and liker_id = ?";
            cnt = DatabaseConnection.getConnection();
            cnt.setAutoCommit(false);
            stm = cnt.prepareStatement(sql);
            stm.setObject(1,post_id);
            stm.setObject(2,liker_id);
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
        LikeSocialDAO like = new LikeSocialDAO();
        like.removeLikePost("CC201DC1-E0B6-4552-894A-36195B4A277A", "41EAB62F-A954-4AAB-B7C4-6F11D301D2D0");
    }
    
}
