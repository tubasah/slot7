package DAO;

import Model.Category;
import Model.FollowUser;
import connectSQLServer.DatabaseConnection;
import Model.User;
import Model.requestOfUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class AdminDAO extends DatabaseConnection {

    private Connection connection;

    public AdminDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public ArrayList<User> getAll() {
        try {
            String sql = "  SELECT * FROM [SWP391].[dbo].[AppUser]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<User> list = new ArrayList<>();
            while (rs.next()) {
                Object id = rs.getObject(1);
                String name = rs.getString(2);
                String pass=rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int roleid = rs.getInt(6);
                User user1 = new User(id, name, pass, email, roleid);
                list.add(user1);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void taoacountshipper(String name, String pass, int role) {
        try {
            String sql = "INSERT INTO AppUser(name,password,role_id) Values(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setInt(3, role);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean delete(String id) {
        try {
            String sql = "DELETE FROM AppUser WHERE id=?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<User> getRandomUsers(Object sessionUserId) {
        UserDAO manageUser = new UserDAO();                
        ArrayList<User> allUsers = manageUser.getAllUsers();
        Set<User> SuggestUsers = new HashSet<>();

        Random rand = new Random();

        if (sessionUserId instanceof Object) {
            for (int i = 0; i < 5 && !allUsers.isEmpty(); i++) {
                int randomIndex = rand.nextInt(allUsers.size());
                User randomUser = allUsers.get(randomIndex);

                if (!sessionUserId.toString().toLowerCase().equals(randomUser.getId().toString().toLowerCase())) {
                    FollowUserDAO manageFollow = new FollowUserDAO();
                    ArrayList<Object> listFollowing = new ArrayList<>();
                    ArrayList<Object> listFriend = new ArrayList<>();
                    for(FollowUser fol : manageFollow.getFollowUsers()){
                        if(sessionUserId.toString().toLowerCase().equals(fol.getFollower().toString().toLowerCase())){
                            // following
                            listFollowing.add(fol.getFollowing());
                        }
                        if (sessionUserId.toString().toLowerCase().equals(fol.getFollower().toString().toLowerCase()) && 
                            listFollowing.contains(fol.getFollowing())) {
                            //friend
                            listFriend.add(fol.getFollowing());
                        }
                    }
                    ArrayList<Object> listFollowingOfFriend = new ArrayList<>();
                    ArrayList<Object> listFriendOfFriend = new ArrayList<>();   
                    for(Object friendOfFriend : listFriend){
                        for(FollowUser follow : manageFollow.getFollowUsers()){
                            if(friendOfFriend.toString().toLowerCase().equals(follow.getFollower().toString().toLowerCase())){
                                // following
                                listFollowingOfFriend.add(follow.getFollowing());
                            }
                            if (friendOfFriend.toString().toLowerCase().equals(follow.getFollower().toString().toLowerCase()) && 
                                listFollowingOfFriend.contains(follow.getFollowing())) {
                                //friend
                                listFriendOfFriend.add(follow.getFollowing());
                            }
                        }
                    }
                    
                    for(User u : allUsers){
                        for(Object following: listFriendOfFriend){
                            for(Object fri : listFriend){
                                if(!sessionUserId.toString().toLowerCase().equals(u.getId().toString().toLowerCase()) &&
                                following.toString().toLowerCase().equals(u.getId().toString().toLowerCase())
                                && !fri.toString().toLowerCase().equals(following.toString().toLowerCase())){
                                    SuggestUsers.add(u);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Error");
        }
        ArrayList<User> uniqueSuggestUsers = new ArrayList<>(SuggestUsers);
        return uniqueSuggestUsers;
    }

    
    public ArrayList<Category> getAllCategory() {
        try {
            String sql = "SELECT * FROM [SWP391].[dbo].[ProductCategory]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Category> listcate = new ArrayList<>();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString(1));
                String type = rs.getString(2);

                Category cate = new Category(id, type);
                listcate.add(cate);
            }
            return listcate;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 public ArrayList<User> getAllShipper() {
        try {
            String sql = "SELECT  AppUser.id\n" +
"      ,[name]\n" +
"      ,[password]\n" +
"      ,[email]\n" +
"\n" +
"      ,[role_id]\n" +
"	  , UserRole.role\n" +
"     FROM [SWP391].[dbo].[AppUser]\n" +
"  JOIN UserRole ON UserRole.id=AppUser.role_id\n" +
"  WHERE role_id!=1 AND role_id!=2 AND role_id!=3";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<User> listcate = new ArrayList<>();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString(1));
                String name=rs.getString(2);
                String pass=rs.getString(3);
                int role=rs.getInt(5);
                String type=rs.getString(6);

                User user=new User(id, name, pass, role, type);
                listcate.add(user);
            }
            return listcate;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addcategory(String type) {
        try {
            String sql = "INSERT INTO ProductCategory(type) Values(?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, type);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deletecategory(String id) {
        try {
            String sql = "DELETE FROM ProductCategory WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void setSeller(Object userid, String status) {
        try {
            String sql = "Update requestSetRole SET status=? WHERE user_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(2, userid);
            ps.setString(1, status);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<requestOfUser> getAllRequestRole() {
        try {
            String sql = "SELECT * FROM [SWP391].[dbo].[requestSetRole]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<requestOfUser> list = new ArrayList<>();
            while (rs.next()) {
                Object id = rs.getObject(1);
                Object userid = rs.getObject(2);
                String email = rs.getString(3);
                String fullname = rs.getString(4);
                String shopname = rs.getString(5);
                Object commo = rs.getObject(6);

                // Debugging statement
                String namecate = getTenDanhMucBangID(commo);
                String address = rs.getString(7);
                String phone = rs.getString(8);
                String status = rs.getString(9);

                requestOfUser req = new requestOfUser(id, userid, email, fullname, shopname, commo, address, phone, namecate, status);
                list.add(req);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getTenDanhMucBangID(Object id) {
        try {
            String sql = "SELECT *\n"
                    + "  FROM [SWP391].[dbo].[ProductCategory]\n"
                    + "  Where id=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String tendanhmuc = rs.getString(2);
            return tendanhmuc;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void uprole(Object id, Object userid) {
        try {
            String sql = "UPDATE\n"
                    + "   [SWP391].[dbo].[requestSetRole]\n"
                    + "   SET status=?\n"
                    + "   WHERE id=?;\n"
                    + "   UPDATE\n"
                    + "   [SWP391].[dbo].[AppUser]\n"
                    + "   SET role_id=3\n"
                    + "   WHERE id=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "OK");
            ps.setObject(2, id);
            ps.setObject(3, userid);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rejectuprole(Object id, Object userid) {
        try {
            String sql = "UPDATE\n"
                    + "   [SWP391].[dbo].[requestSetRole]\n"
                    + "   SET status=?\n"
                    + "   WHERE id=?;\n";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "NOT OK");
            ps.setObject(2, id);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        AdminDAO userdao = new AdminDAO();

        ArrayList<requestOfUser> list = new ArrayList<>();
        list = userdao.getAllRequestRole();
        System.out.println(list);
    }

}
