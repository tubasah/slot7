/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Donhang;
import connectSQLServer.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DonhangDAO {
    private Connection connection;

    public DonhangDAO() {
        connection = DatabaseConnection.getConnection();
    }
    public ArrayList<Donhang> getdonhangOfUser(Object iduser){
        try {
            String sql="SELECT o.id,o.order_total,o.customer_id,o.seller_id,o.fullname,o.phone,o.order_date,o.order_town,o.order_location,o.status,\n" +
"d.id,d.product_id,d.quantity,d.price,requestSetRole.shopName,ProductInfo.product_image,ProductInfo.product_name,o.stt\n" +
" FROM [SWP391].[dbo].[Order] AS o\n" +
" JOIN OrderDetail AS d ON d.order_id=o.id\n" +
"JOIN requestSetRole ON o.seller_id=requestSetRole.user_id\n" +
"JOIN ProductInfo ON d.product_id=ProductInfo.product_id \n" +
"WHERE o.customer_id=?\n" +
"ORDER BY stt DESC";
            ArrayList<Donhang> list=new ArrayList<>();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setObject(1, iduser);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Object id=rs.getObject(1);
                Double total=rs.getDouble(2);
                Object sellerid=rs.getObject(4);
                String fullname=rs.getString(5);
                String phone=rs.getString(6);
                Date date=rs.getDate(7);
                String town =rs.getString(8);
                String location=rs.getString(9);
                String status=rs.getString(10);
                Object productid=rs.getObject(12);
                int quantity=rs.getInt(13);
                double price=rs.getDouble(14);
                String shopname=rs.getString(15);
                String img=rs.getString(16);
                String productname=rs.getString(17);
                Donhang donhang=new Donhang(id, total, iduser, sellerid, fullname, phone, date, town, location, status, productid, quantity, price,shopname,img,productname);
                list.add(donhang);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DonhangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public HashMap<Object, ArrayList<Donhang>> getDonhangChoXacNhanOfUserhash(Object iduser) {
    try {
        String sql = " SELECT o.id, o.order_total, o.customer_id, o.seller_id, o.fullname, o.phone, o.order_date, o.order_town, o.order_location, o.status, \n" +
"            d.id, d.product_id, d.quantity, d.price, requestSetRole.shopName, ProductInfo.product_image, ProductInfo.product_name, o.stt\n" +
"            FROM [SWP391].[dbo].[Order] AS o \n" +
"            JOIN OrderDetail AS d ON d.order_id=o.id \n" +
"            JOIN requestSetRole ON o.seller_id=requestSetRole.user_id \n" +
"            JOIN ProductInfo ON d.product_id=ProductInfo.product_id \n" +
"            WHERE o.customer_id=? AND o.status IS NULL\n" +
"            ORDER BY stt DESC";

        HashMap<Object, ArrayList<Donhang>> orderMap = new HashMap<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, iduser);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Object orderId = rs.getObject(1);

            // Check if the order ID is already a key in the map
            if (!orderMap.containsKey(orderId)) {
                orderMap.put(orderId, new ArrayList<>());
            }

            Double total = rs.getDouble(2);
            Object sellerId = rs.getObject(4);
            String fullname = rs.getString(5);
            String phone = rs.getString(6);
            Date date = rs.getDate(7);
            String town = rs.getString(8);
            String location = rs.getString(9);
            String status = rs.getString(10);
            Object productId = rs.getObject(12);
            int quantity = rs.getInt(13);
            double price = rs.getDouble(14);
            String shopName = rs.getString(15);
            String img = rs.getString(16);
            String productName = rs.getString(17);

            Donhang donhang = new Donhang(orderId, total, iduser, sellerId, fullname, phone, date, town, location, status, productId, quantity, price, shopName, img, productName);

            // Add the 'Donhang' object to the corresponding order ID key in the map
            orderMap.get(orderId).add(donhang);
        }

        return orderMap;
    } catch (SQLException ex) {
        Logger.getLogger(DonhangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
       public HashMap<Object, ArrayList<Donhang>> getDonhangDangGiaoOrHoanthanhOfUserhash(Object iduser,String status) {
    try {
        String sql = " SELECT o.id, o.order_total, o.customer_id, o.seller_id, o.fullname, o.phone, o.order_date, o.order_town, o.order_location, o.status, \n" +
"            d.id, d.product_id, d.quantity, d.price, requestSetRole.shopName, ProductInfo.product_image, ProductInfo.product_name, o.stt\n" +
"            FROM [SWP391].[dbo].[Order] AS o \n" +
"            JOIN OrderDetail AS d ON d.order_id=o.id \n" +
"            JOIN requestSetRole ON o.seller_id=requestSetRole.user_id \n" +
"            JOIN ProductInfo ON d.product_id=ProductInfo.product_id \n" +
"            WHERE o.customer_id=? AND o.status=?\n" +
"            ORDER BY stt DESC";

        HashMap<Object, ArrayList<Donhang>> orderMap = new HashMap<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, iduser);
        ps.setString(2, status);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Object orderId = rs.getObject(1);

            // Check if the order ID is already a key in the map
            if (!orderMap.containsKey(orderId)) {
                orderMap.put(orderId, new ArrayList<>());
            }

            Double total = rs.getDouble(2);
            Object sellerId = rs.getObject(4);
            String fullname = rs.getString(5);
            String phone = rs.getString(6);
            Date date = rs.getDate(7);
            String town = rs.getString(8);
            String location = rs.getString(9);
            Object productId = rs.getObject(12);
            int quantity = rs.getInt(13);
            double price = rs.getDouble(14);
            String shopName = rs.getString(15);
            String img = rs.getString(16);
            String productName = rs.getString(17);

            Donhang donhang = new Donhang(orderId, total, iduser, sellerId, fullname, phone, date, town, location, status, productId, quantity, price, shopName, img, productName);

            // Add the 'Donhang' object to the corresponding order ID key in the map
            orderMap.get(orderId).add(donhang);
        }

        return orderMap;
    } catch (SQLException ex) {
        Logger.getLogger(DonhangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
        public HashMap<Object, ArrayList<Donhang>> quanLiDonHangOfSellerhash(Object iduser) {
    try {
        String sql = "SELECT o.id, o.order_total, o.customer_id, o.seller_id, o.fullname, o.phone, o.order_date, o.order_town, o.order_location, o.status, \n" +
"            d.id, d.product_id, d.quantity, d.price, requestSetRole.shopName, ProductInfo.product_image, ProductInfo.product_name, o.stt \n" +
"FROM [SWP391].[dbo].[Order] AS o\n" +
"JOIN OrderDetail AS d ON d.order_id = o.id\n" +
"JOIN requestSetRole ON o.seller_id = requestSetRole.user_id\n" +
"JOIN ProductInfo ON d.product_id = ProductInfo.product_id\n" +
"WHERE o.seller_id = ? AND (o.status NOT LIKE '%Da huy%' OR o.status IS NULL)\n" +
"ORDER BY stt DESC";

        HashMap<Object, ArrayList<Donhang>> orderMap = new HashMap<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, iduser);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Object orderId = rs.getObject(1);

            // Check if the order ID is already a key in the map
            if (!orderMap.containsKey(orderId)) {
                orderMap.put(orderId, new ArrayList<>());
            }

            Double total = rs.getDouble(2);
            Object sellerId = rs.getObject(4);
            String fullname = rs.getString(5);
            String phone = rs.getString(6);
            Date date = rs.getDate(7);
            String town = rs.getString(8);
            String location = rs.getString(9);
            String status = rs.getString(10);
            Object productId = rs.getObject(12);
            int quantity = rs.getInt(13);
            double price = rs.getDouble(14);
            String shopName = rs.getString(15);
            String img = rs.getString(16);
            String productName = rs.getString(17);

            Donhang donhang = new Donhang(orderId, total, iduser, sellerId, fullname, phone, date, town, location, status, productId, quantity, price, shopName, img, productName);

            // Add the 'Donhang' object to the corresponding order ID key in the map
            orderMap.get(orderId).add(donhang);
        }

        return orderMap;
    } catch (SQLException ex) {
        Logger.getLogger(DonhangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
               public HashMap<Object, ArrayList<Donhang>> Shipper(String thanhpho) {
    try {
        String sql = "	   SELECT o.id, o.order_total, o.customer_id, o.seller_id, o.fullname, o.phone, o.order_date, o.order_town, o.order_location, o.status,\n" +
"          d.id, d.product_id, d.quantity, d.price, requestSetRole.shopName, ProductInfo.product_image, ProductInfo.product_name, o.stt\n" +
"          FROM [SWP391].[dbo].[Order] AS o \n" +
"         JOIN OrderDetail AS d ON d.order_id=o.id\n" +
"           JOIN requestSetRole ON o.seller_id=requestSetRole.user_id \n" +
"           JOIN ProductInfo ON d.product_id=ProductInfo.product_id \n" +
"           WHERE o.order_town=? AND( o.status IS NOT NULL AND o.status !='Hoan thanh' AND o.status NOT LIKE '%Da huy%')\n" +
"          ORDER BY stt DESC";

        HashMap<Object, ArrayList<Donhang>> orderMap = new HashMap<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, thanhpho);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Object orderId = rs.getObject(1);

            // Check if the order ID is already a key in the map
            if (!orderMap.containsKey(orderId)) {
                orderMap.put(orderId, new ArrayList<>());
            }

            Double total = rs.getDouble(2);
            Object iduser = rs.getObject(3);
            Object sellerId = rs.getObject(4);
            String fullname = rs.getString(5);
            String phone = rs.getString(6);
            Date date = rs.getDate(7);
            String town = rs.getString(8);
            String location = rs.getString(9);
            String status = rs.getString(10);
            Object productId = rs.getObject(12);
            int quantity = rs.getInt(13);
            double price = rs.getDouble(14);
            String shopName = rs.getString(15);
            String img = rs.getString(16);
            String productName = rs.getString(17);

            Donhang donhang = new Donhang(orderId, total, iduser, sellerId, fullname, phone, date, town, location, status, productId, quantity, price, shopName, img, productName);

            // Add the 'Donhang' object to the corresponding order ID key in the map
            orderMap.get(orderId).add(donhang);
        }

        return orderMap;
    } catch (SQLException ex) {
        Logger.getLogger(DonhangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
                public HashMap<Object, ArrayList<Donhang>> Shipperdanggiaoorhoanthanh(String thanhpho) {
    try {
        String sql = "SELECT o.id, o.order_total, o.customer_id, o.seller_id, o.fullname, o.phone, o.order_date, o.order_town, o.order_location, o.status,\n" +
"            d.id, d.product_id, d.quantity, d.price, requestSetRole.shopName, ProductInfo.product_image, ProductInfo.product_name, o.stt\n" +
"            FROM [SWP391].[dbo].[Order] AS o \n" +
"            JOIN OrderDetail AS d ON d.order_id=o.id\n" +
"            JOIN requestSetRole ON o.seller_id=requestSetRole.user_id \n" +
"           JOIN ProductInfo ON d.product_id=ProductInfo.product_id \n" +
"            WHERE o.order_town=? AND (o.status ='Dang giao' OR o.status ='Hoan thanh')\n" +
"           ORDER BY stt DESC";
        HashMap<Object, ArrayList<Donhang>> orderMap = new HashMap<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, thanhpho);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Object orderId = rs.getObject(1);

            // Check if the order ID is already a key in the map
            if (!orderMap.containsKey(orderId)) {
                orderMap.put(orderId, new ArrayList<>());
            }

            Double total = rs.getDouble(2);
            Object iduser = rs.getObject(3);
            Object sellerId = rs.getObject(4);
            String fullname = rs.getString(5);
            String phone = rs.getString(6);
            Date date = rs.getDate(7);
            String town = rs.getString(8);
            String location = rs.getString(9);
            String status = rs.getString(10);
            Object productId = rs.getObject(12);
            int quantity = rs.getInt(13);
            double price = rs.getDouble(14);
            String shopName = rs.getString(15);
            String img = rs.getString(16);
            String productName = rs.getString(17);

            Donhang donhang = new Donhang(orderId, total, iduser, sellerId, fullname, phone, date, town, location, status, productId, quantity, price, shopName, img, productName);

            // Add the 'Donhang' object to the corresponding order ID key in the map
            orderMap.get(orderId).add(donhang);
        }

        return orderMap;
    } catch (SQLException ex) {
        Logger.getLogger(DonhangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
      
            
       public HashMap<Object, ArrayList<Donhang>> xemdonhangDangChoVanChuyenhash(Object iduser) {
    try {
        String sql = "SELECT o.id, o.order_total, o.customer_id, o.seller_id, o.fullname, o.phone, o.order_date, o.order_town, o.order_location, o.status, \n" +
"            d.id, d.product_id, d.quantity, d.price, requestSetRole.shopName, ProductInfo.product_image, ProductInfo.product_name, o.stt\n" +
"            FROM [SWP391].[dbo].[Order] AS o \n" +
"            JOIN OrderDetail AS d ON d.order_id=o.id \n" +
"            JOIN requestSetRole ON o.seller_id=requestSetRole.user_id \n" +
"            JOIN ProductInfo ON d.product_id=ProductInfo.product_id \n" +
"            WHERE o.customer_id=? AND o.status='cho van chuyen'\n" +
"            ORDER BY stt DESC";

        HashMap<Object, ArrayList<Donhang>> orderMap = new HashMap<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, iduser);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Object orderId = rs.getObject(1);

            // Check if the order ID is already a key in the map
            if (!orderMap.containsKey(orderId)) {
                orderMap.put(orderId, new ArrayList<>());
            }

            Double total = rs.getDouble(2);
            Object sellerId = rs.getObject(4);
            String fullname = rs.getString(5);
            String phone = rs.getString(6);
            Date date = rs.getDate(7);
            String town = rs.getString(8);
            String location = rs.getString(9);
            String status = rs.getString(10);
            Object productId = rs.getObject(12);
            int quantity = rs.getInt(13);
            double price = rs.getDouble(14);
            String shopName = rs.getString(15);
            String img = rs.getString(16);
            String productName = rs.getString(17);

            Donhang donhang = new Donhang(orderId, total, iduser, sellerId, fullname, phone, date, town, location, status, productId, quantity, price, shopName, img, productName);

            // Add the 'Donhang' object to the corresponding order ID key in the map
            orderMap.get(orderId).add(donhang);
        }

        return orderMap;
    } catch (SQLException ex) {
        Logger.getLogger(DonhangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
   public static void main(String[] args) {
//    DonhangDAO dao = new DonhangDAO();
//    String iduser = "1CAF9AD4-AFEA-4EE9-BFC1-E0AFC556370F"; // Thay bằng iduser thực tế của bạn
//
//    // Duyệt qua các mục trong HashMap
//    for (Map.Entry<Object, ArrayList<Donhang>> entry : orderMap.entrySet()) {
//        Object orderId = entry.getKey();
//        ArrayList<Donhang> donhangList = entry.getValue();
//
//        // In thông tin về đơn hàng
//        System.out.println("Order ID: " + orderId);
//        
//        for (Donhang donhang : donhangList) {
//            System.out.println("Product Name: " + donhang.getProductname());
//            System.out.println("Quantity: " + donhang.getQuantity());
//            // Thêm thông tin khác mà bạn muốn in ra console
//        }
//    }
//}

}
}
