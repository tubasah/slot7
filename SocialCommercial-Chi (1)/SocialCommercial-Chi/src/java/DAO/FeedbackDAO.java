/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connectSQLServer.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Chart;
import Model.ChartStar;
import Model.Feedback;
import java.sql.Connection;
import java.util.Date;
import java.util.UUID;

public class FeedbackDAO extends DatabaseConnection {

    private Connection connection;

    public FeedbackDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Feedback> getAllFeedback() {
        List<Feedback> list = new ArrayList<>();
        String sql = "  select f.*, p.product_name\n"
                + " from Feedback f join ProductInfo p\n"
                + "on f.product_id = p.product_id";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object id = resultSet.getObject(1);
                int rated_star = resultSet.getInt(2);
                String feedback = resultSet.getString(3);
                String image = resultSet.getString(4);
                boolean status = resultSet.getBoolean(5);
                Object product_id = resultSet.getObject(6);
                Object user_id = resultSet.getObject(7);
                Date date = resultSet.getDate(8);
                String product_name = resultSet.getString(9);

                Feedback f = new Feedback(id, rated_star, feedback, image, status, product_id, user_id, (java.sql.Date) date, product_name);
                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public int getTotalFeedback(Object productId) {
        String sql = "select COUNT(feedBack_id) from Feedback where product_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Feedback> getAllFeedbackByProductId(Object productId) {
        List<Feedback> list = new ArrayList<>();
        String sql = "select * from Feedback where product_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object id = resultSet.getObject(1);
                int rated_star = resultSet.getInt(2);
                String feedback = resultSet.getString(3);
                String image = resultSet.getString(4);
                boolean status = resultSet.getBoolean(5);
                Object product_id = resultSet.getObject(6);
                Object user_id = resultSet.getObject(7);
                Date date = resultSet.getDate(8);

                Feedback f = new Feedback(id, rated_star, feedback, image, status, product_id, user_id, (java.sql.Date) date);
                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    public void insertFeedback(int star, String subject, String image, boolean i, Object product_id, Object userId) {
        String sql = "INSERT INTO [dbo].[Feedback]\n"
                + "           ([rated_star]\n"
                + "           ,[feedback]\n"
                + "           ,[image]\n"
                + "           ,[status]\n"
                + "           ,[product_id]\n"
                + "           ,[userId])\n"
                + "     VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, star);
            statement.setString(2, subject);
            statement.setString(3, image);
            statement.setBoolean(4, i);
            statement.setObject(5, product_id);
            statement.setObject(6, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public boolean getFeedbackStatus(Object product_id, Object userId) {
        boolean status = false;
        String query = "SELECT status FROM Feedback WHERE product_id = ? AND userId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, product_id);
            preparedStatement.setObject(2, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    status = resultSet.getBoolean("status");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }
    
    

    public static void main(String[] args) {
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        List<Feedback> feedbackList = feedbackDAO.getAllFeedback();
        int star = 5; // Điểm đánh giá
            String subject = "Sản phẩm tuyệt vời!";
            String image = "setofshop\\img\\ao.png";
            int i = 1; // Trạng thái (ví dụ: 1 cho đã duyệt, 0 cho chưa duyệt)
            Object product_id = "186E746C-730E-4606-9A6B-0B7C708D574B"; // ID sản phẩm
            Object userId = "F122C4A5-C570-46D8-9D60-61C01BC480D6";
            //feedbackDAO.insertFeedback(star, subject, image, true, product_id, userId);
            
            System.out.println(feedbackDAO.getFeedbackStatus(product_id, userId));
//        for (Feedback feedback : feedbackList) {
//            System.out.println("ID: " + feedback.getId());
//            System.out.println("Rated Star: " + feedback.getRated_star());
//            System.out.println("Feedback: " + feedback.getFeedback());
//            System.out.println("Image: " + feedback.getImage());
//            System.out.println("Status: " + feedback.isStatus());
//            System.out.println("Product ID: " + feedback.getProduct_id());
//            System.out.println("User ID: " + feedback.getUser_id());
//            System.out.println("Date: " + feedback.getDate());
//            System.out.println("Product Name: " + feedback.getProduct_name());
//        }

    }

}
