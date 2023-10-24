
package DAO;

import Model.Doanhthu;
import connectSQLServer.DatabaseConnection;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class UserDAO extends DatabaseConnection {

    private Connection connection;

    public UserDAO() {
        connection = DatabaseConnection.getConnection();
    }
       public void addGoiYNguoiDung(Object iduser, Object context) {
        try {
            String sql = "  Insert INTO Hint(userid,context) Values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(2, context);
            ps.setObject(1, iduser);
            ps.execute();
            }
        catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public ArrayList<User> getGoiYNguoiDung(Object userid) {
        try {
            String sql = "SELECT TOP 5 [userid], COUNT(DISTINCT [context]) AS same_context_count,AppUser.name, AppUser.image\n" +
"FROM [SWP391].[dbo].[Hint]\n" +
"INNER JOIN AppUser ON AppUser.id = Hint.userid\n" +
"WHERE [userid] != ?\n" +
"AND [context] IN (\n" +
"    SELECT DISTINCT [context] \n" +
"    FROM [SWP391].[dbo].[Hint]\n" +
"    WHERE [userid] = ?\n" +
")\n" +
"GROUP BY AppUser.name, AppUser.image, [userid]\n" +
"ORDER BY same_context_count DESC;";
            ArrayList<User> list=new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1,userid);
            ps.setObject(2,userid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object useridnguoikhac = rs.getObject(1);
                String userName = rs.getString(3);
                String img=rs.getString(4);

                User user = new User(useridnguoikhac,userName,img);
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; // Tr? v? null n?u kh�ng t�m th?y user ho?c x?y ra l?i
    }
     
    public User get(String name, String password) {
        try {
            String sql = "SELECT * FROM [SWP391].[dbo].[AppUser] WHERE name=? AND password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Object id = rs.getObject(1);
                String userName = rs.getString(2);
                String userPass = rs.getString(3);
                String email = rs.getString(4);
                int roleId = rs.getInt(6);

                User user = new User(id, name, pass, email, roleId);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; // Tr? v? null n?u kh�ng t�m th?y user ho?c x?y ra l?i
    }
       public void setpassbyname(String name,String pass) {
        try {
            String sql = "Update AppUser\n"
                    + "SET password=? "
                    + "WHERE name=?";
            PreparedStatement ps = connection.prepareStatement(sql);
             ps.setString(1, pass);
            ps.setString(2, name);
            
             ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    public User getbyemail(String email) {
        try {
            String sql = "SELECT * FROM [SWP391].[dbo].[AppUser] WHERE email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Object id = rs.getObject(1);
                String userName = rs.getString("name");
                int roleId = rs.getInt(6);

                User user = new User(id, userName, email, roleId);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; // Trả v�? null nếu không tìm thấy user hoặc xảy ra lỗi
    }


    public User checkdup(String name) {
        try {
            String sql = "SELECT * FROM [SWP391].[dbo].[AppUser] WHERE name=? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Object id = rs.getObject(1);
                String userName = rs.getString(2);
                String userPass = rs.getString(3);
                String email = rs.getString(4);
                int roleId = rs.getInt(6);

                User user = new User(id, name, email, roleId);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; // Tr? v? null n?u kh�ng t�m th?y user ho?c x?y ra l?i
    }
     public User checkdupemail(String name) {
        try {
            String sql = "SELECT * FROM [SWP391].[dbo].[AppUser] WHERE email=? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Object id = rs.getObject(1);
                String userName = rs.getString(2);
                String userPass = rs.getString(3);
                String email = rs.getString(4);
                int roleId = rs.getInt(6);
                User user = new User(id, name, email, roleId);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; // Trả về null nếu không tìm thấy user hoặc xảy ra lỗi
    }

    public boolean register(String name, String pass, String email) {
        try {
            String sql = "INSERT INTO AppUser (name, password, email, role_id) VALUES (?,?,?,2);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, email);
            UserDAO dao = new UserDAO();
            if (dao.checkdup(name) != null) {
                return false;
            } else {
                ps.execute();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    public void EditUser( String number, String image, String fullName,String gender
    , String statusNow, String school, String favour, String bio, Object id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE AppUser SET number = ?,"
                    + " image = ?, fullName = ?,"
                    + "gender = ?, statusNow = ?,"
                    + "school = ?, favour = ?," 
                    + "bio = ? WHERE id = ?";

            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);
            stm.setString(1, number);
            stm.setString(2, image);
            stm.setString(3, fullName);
            stm.setString(4, gender);
            stm.setString(5, statusNow);
            stm.setString(6, school);
            stm.setString(7, favour);
            stm.setString(8, bio);
            stm.setObject(9, id);

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
    
    public void EditUserSubstractImage( String number, String fullName,String gender
    , String statusNow, String school, String favour, String bio, Object id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE AppUser SET number = ?,"
                    + " fullName = ?,"
                    + "gender = ?, statusNow = ?,"
                    + "school = ?, favour = ?," 
                    + "bio = ? WHERE id = ?";

            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);
            stm.setString(1, number);
            stm.setString(2, fullName);
            stm.setString(3, gender);
            stm.setString(4, statusNow);
            stm.setString(5, school);
            stm.setString(6, favour);
            stm.setString(7, bio);
            stm.setObject(8, id);

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
    public String getEmailbyID(Object id){
        try {
            String sql="SELECT [email]\n" +
                    "      \n" +
                    "  FROM [SWP391].[dbo].[AppUser]\n" +
                    "  WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, id);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    String email=rs.getString(1);
                   return email;

        } catch (SQLException ex) {
            Logger.getLogger(ChatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   return null; 
}
    public ArrayList<User> getAllUsers() {
        try {
            String sql = "  SELECT * FROM [SWP391].[dbo].[AppUser]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<User> list = new ArrayList<>();
            while (rs.next()) {
                Object id = rs.getObject(1);
                String phone = rs.getString(5);
                int roleid = rs.getInt(6);
                String image = rs.getString(7);
                String fullName = rs.getString(8);
                String gender = rs.getString(9);
                String statusNow = rs.getString(10);
                String school = rs.getString(11);
                String favour = rs.getString(12);
                String bio = rs.getString(13);

                User user = new User(id, phone, image,roleid, fullName,gender,statusNow,
                school,favour,bio);
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public void requestSetRole(Object user_id,String email,String fullName,String shopName,
             String commoditiesSector,String address, String phone) {
        try {
            String sql = "INSERT INTO requestSetRole(user_id,email,fullName,shopName, commoditiesSector,address,phone)\n" +
"Values(?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1,user_id);
            ps.setString(2, email);
            ps.setString(3, fullName);
             ps.setString(4, shopName);
            ps.setString(5,  commoditiesSector);
             ps.setString(6, address);
            ps.setString(7, phone);
          ps.execute();
                  
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public Doanhthu getThongkeBySellerid(Object sellerid){
        try {
            String sql="SELECT\n" +
                    "    o.seller_id,\n" +
                    "    r.shopName AS seller_name,\n" +
                    "    COUNT(o.id) AS total_orders,\n" +
                    "    SUM(o.order_total) AS total_doanhthu\n" +
                    "FROM\n" +
                    "    [SWP391].[dbo].[Order] AS o\n" +
                    "JOIN\n" +
                    "    requestSetRole AS r ON o.seller_id = r.user_id\n" +
                    "WHERE\n" +
                    "    o.status = 'Hoan thanh'  \n" +
                    "    AND o.seller_id = ?   \n" +
                    "GROUP BY\n" +
                    "    o.seller_id, r.shopName\n" +
                    "ORDER BY\n" +
                    "    total_doanhthu DESC;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1,sellerid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Doanhthu doanhthu=new Doanhthu(sellerid, rs.getString(2), rs.getInt(3), rs.getDouble(4));
            return doanhthu;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

         
     }
    
    public static void main(String[] args) {
        UserDAO userdao = new UserDAO();
       
ArrayList<User> list=userdao.getGoiYNguoiDung("F122C4A5-C570-46D8-9D60-61C01BC480D6");
        System.out.println(list);
    }
}