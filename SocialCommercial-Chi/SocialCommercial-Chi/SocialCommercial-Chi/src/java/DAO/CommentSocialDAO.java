
package DAO;


import Model.CommentSocial;
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


public class CommentSocialDAO {
    List<CommentSocial> listOfCommentSocials = new ArrayList<>();
    
   
    public List<CommentSocial> getCommentSocials() {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try{
            String sql = "select * from SocialComment";
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);    
            res = stm.executeQuery();
            while(res.next()){
                Object id = res.getObject("id");
                Object post_id = res.getObject("post_id");
                Object commentor_id = res.getObject("commentor_id");
                String comment_content = res.getString("comment_content");
                Date comment_date = res.getDate("comment_date");
                
                CommentSocial comment = new CommentSocial(id, post_id, commentor_id, comment_content,
                comment_date);
                listOfCommentSocials.add(comment);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                cnt.close();
                stm.close();
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentSocialDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOfCommentSocials;
    }

    public void addCommentSocial(Object post_id, Object commentor_id, String comment_content, Date comment_date) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO SocialComment (post_id, commentor_id, comment_content, comment_date)"
                    + "VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, post_id);
            stmt.setObject(2, commentor_id);
            stmt.setString(3, comment_content);
            stmt.setObject(4, new java.sql.Date(comment_date.getTime()));
            
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


    public void deleteCommentSocial(Object id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
         try{
            String sql = "delete from SocialComment where id = ?";
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
    
    public List<CommentSocial> getCommentsForPost(Object postId) {
        List<CommentSocial> commentsForPost = new ArrayList<>();

        for (CommentSocial comment : getCommentSocials()) {
            if (comment.getPost_id() != null && comment.getPost_id().toString().equalsIgnoreCase(postId.toString())) {
                commentsForPost.add(comment);
            }
        }

        return commentsForPost;
    }
    
    public static void main(String[] args) {
        CommentSocialDAO comment = new CommentSocialDAO();
        comment.deleteCommentSocial("A9FC8090-5F48-4E2C-88BB-454D516209BA");
    }
    
}
