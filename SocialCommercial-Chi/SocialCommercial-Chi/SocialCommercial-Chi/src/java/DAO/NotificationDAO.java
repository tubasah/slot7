
package DAO;

import Model.Notification;
import Model.User;
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


public class NotificationDAO {
    List<Notification> listOfNotifications = new ArrayList<>();

    public List<Notification> getAllNotifications() {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try{
            String sql = "select * from UserNotification";
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);    
            res = stm.executeQuery();
            while(res.next()){
                Object id = res.getObject("id");
                Object user_id = res.getObject("user_id");
                String notification_content = res.getString("notification_content");
                Date notification_date = res.getDate("notification_date");
                String link_notify = res.getString("link_notify");
                String reacter = res.getString("reacter");
                
                Notification notify = new Notification(id, user_id, notification_content,
                        notification_date, link_notify, reacter);
                listOfNotifications.add(notify);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                cnt.close();
                stm.close();
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOfNotifications;
    }

    public void addNotification(Object user_id, String notification_content, Date notification_date, String link_notify,
            String reacter) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO UserNotification (user_id, notification_content, notification_date, link_notify, reacter)"
                    + "VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, user_id);
            stmt.setString(2, notification_content);
            stmt.setObject(3, new java.sql.Date(notification_date.getTime()));
            stmt.setString(4, link_notify);
            stmt.setString(5, reacter);
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


    public void deleteNotification(Object id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
         try{
            String sql = "delete from UserNotification where id = ?";
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
        UserDAO manageUser = new UserDAO();
        NotificationDAO noti = new NotificationDAO();
        noti.addNotification("59B5896F-98B2-4699-82EC-1B8B99CEBCB2",
            "A"+" đã bình luận bài viết của bạn", new Date(),
            "PostDetail?post_i", "41EAB62F-A954-4AAB-B7C4-6F11D301D2D0");
    }
    
}
