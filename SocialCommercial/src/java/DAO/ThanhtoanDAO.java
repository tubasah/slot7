/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Donhang;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import connectSQLServer.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ThanhtoanDAO {

    private Connection connection;

    public ThanhtoanDAO() {
        connection = DatabaseConnection.getConnection();
    }

   public Object addNewOrderandGetThisOther(Object iduser, Object idseller, String fullname, String phone, String town, String location) {
    try {
        // Bắt đầu giao dịch
        connection.setAutoCommit(false);

        // Lấy ngày hiện tại
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

        // Thêm dữ liệu vào bảng Order
        String insertOrderSQL = "INSERT INTO [Order](customer_id, seller_id, fullname, phone, order_date, order_town, order_location) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS);
        ps.setObject(1, iduser);
        ps.setObject(2, idseller);
        ps.setString(3, fullname);
        ps.setString(4, phone);
        ps.setDate(5, sqlDate);
        ps.setString(6, town);
        ps.setString(7, location);

        ps.executeUpdate();

        // Lấy ID của đơn hàng vừa tạo
        ResultSet generatedKeys = ps.getGeneratedKeys();
        Object stt = null;
        if (generatedKeys.next()) {
            stt = generatedKeys.getObject(1);
        } else {
            throw new SQLException("Creating order failed, no ID obtained.");
        }

        // Truy vấn để lấy ID của đơn hàng
        String sql = "SELECT id FROM [SWP391].[dbo].[Order] WHERE stt=?";
        PreparedStatement ps1 = connection.prepareStatement(sql);
        ps1.setObject(1, stt);
        ResultSet rs = ps1.executeQuery();
        rs.next();
        Object idorder = rs.getObject(1);

        // Commit giao dịch
        connection.commit();
        connection.setAutoCommit(true);

        return idorder;
    } catch (SQLException ex) {
        // Rollback giao dịch nếu có lỗi
        if (connection != null) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                // Xử lý lỗi rollback
            }
        }
    }
    return null;
}

 public void xacnhandonhang(Object idorder,String status) {
      
        try {
            String sql = "UPDATE [Order]\n" +
"SET status=?\n" +
"WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);    
            ps.setString(1, status);
            ps.setObject(2, idorder);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThanhtoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void addNewOrderDetail(Object idorder, Object productid, int quantity, double price) {

        try {
            String sql = "Insert INTO OrderDetail(order_id,product_id,quantity,price)\n"
                    + "Values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, idorder);
            ps.setObject(2, productid);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThanhtoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UpdateOrdertotal() {

        try {
            String sql = "UPDATE [SWP391].[dbo].[Order]\n"
                    + "SET [order_total] = (\n"
                    + "    SELECT SUM([price] * [quantity]) + 35000\n"
                    + "    FROM [SWP391].[dbo].[OrderDetail] \n"
                    + "    WHERE [OrderDetail].[order_id] = [Order].[id]\n"
                    + ")";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThanhtoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        ThanhtoanDAO dao = new ThanhtoanDAO();
        Object id = dao.addNewOrderandGetThisOther("E293FDC3-4B7A-48A8-93DD-830C81F4F1AD", "59B5896F-98B2-4699-82EC-1B8B99CEBCB2",
                "q", "v", "a", "c");
        System.out.println(id);

    }

}
