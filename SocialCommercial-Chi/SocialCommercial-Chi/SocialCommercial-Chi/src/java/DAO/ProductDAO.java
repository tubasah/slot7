/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Category;
import Model.Product;
import connectSQLServer.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends DatabaseConnection {

    private Connection connection;

    public ProductDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM ProductInfo";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object productId = resultSet.getObject(1);
                String productName = resultSet.getString(4);
                String productImage = resultSet.getString(5);
                double productPrice = resultSet.getDouble(8);
                String productDescription = resultSet.getString(10);

                Product product = new Product(productId, productName, productImage, productPrice, productDescription);
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public double getRatedProduct(Object id) {
        String sql = "select AVG(rated_star) from Feedback where product_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setObject(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<Product> getAllProductsofUser(Object id) {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM ProductInfo Where seller_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object productId = resultSet.getObject(1);
                String productName = resultSet.getString(4);
                String productImage = resultSet.getString(5);
                double productPrice = resultSet.getDouble(8);
                String productDescription = resultSet.getString(10);

                Product product = new Product(productId, productName, productImage, productPrice, productDescription);
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> getTop3ProductsofUser(Object id) {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT TOP (3) [product_id]\n"
                + "      ,[seller_id]\n"
                + "      ,[type_id]\n"
                + "      ,[product_name]\n"
                + "      ,[product_image]\n"
                + "      ,[product_available]\n"
                + "      ,[product_sales]\n"
                + "      ,[product_price]\n"
                + "      ,[product_voucher]\n"
                + "      ,[product_description]\n"
                + "  FROM [SWP391].[dbo].[ProductInfo]\n"
                + "  WHERE seller_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object productId = resultSet.getObject(1);
                String productName = resultSet.getString(4);
                String productImage = resultSet.getString(5);
                double productPrice = resultSet.getDouble(8);
                String productDescription = resultSet.getString(10);

                Product product = new Product(productId, productName, productImage, productPrice, productDescription);
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
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

    public String getShopNameBySellerID(String sellerID) {
        try {
            String sql = "SELECT [shopName] FROM [SWP391].[dbo].[requestSetRole] WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, sellerID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String shopName = rs.getString("shopName");
                return shopName;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public String getTotalProduct(Object sellerId) {
//        String sql = "SELECT COUNT(product_id) FROM ProductInfo WHERE seller_id = ?";
//
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setObject(1, sellerId);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                String productCount = resultSet.getString(1);
//                return productCount;
//            }
//
//            resultSet.close();
//            statement.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public Object getTenDanhMuccuanguoiban(Object id) {
        try {
            String sql = "SELECT \n"
                    + "      \n"
                    + "      [commoditiesSector]\n"
                    + "    \n"
                    + "  FROM [SWP391].[dbo].[requestSetRole]\n"
                    + "  WHERE user_id=?  AND status='OK'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Object tendanhmuc = rs.getObject(1);
            return tendanhmuc;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getshopnamecuanguoiban(Object id) {
        try {
            String sql = "SELECT \n"
                    + "      \n"
                    + "      [shopName]\n"
                    + "    \n"
                    + "  FROM [SWP391].[dbo].[requestSetRole]\n"
                    + "  WHERE user_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String tendanhmuc = rs.getString(1);
            return tendanhmuc;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM ProductCategory";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object cid = resultSet.getObject(1);
                String type = resultSet.getString(2);

                Category category = new Category(cid, type);
                list.add(category);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getRelatedProduct(Object cid) {
        List<Product> products = new ArrayList<>();
        String sql = "select top 4 * from ProductInfo\n"
                + "where type_id = ?\n"
                + "order by product_id desc";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, cid);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object productId = resultSet.getObject(1);
                String productName = resultSet.getString(4);
                String productImage = resultSet.getString(5);
                double productPrice = resultSet.getDouble(8);
                String productDescription = resultSet.getString(10);

                Product product = new Product(productId, productName, productImage, productPrice, productDescription);
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public String getProductbyCId(Object cid) {
        try {
            String sql = "SELECT type_id FROM ProductInfo\n"
                    + "WHERE product_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, cid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String category = rs.getString(1);
            return category;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Product getProductsbyID(Object id) {
        String sql ="SELECT TOP (1000) [product_id]\n" +
"      ,[seller_id]\n" +
"      ,[type_id]\n" +
"      ,[product_name]\n" +
"      ,[product_image]\n" +
"      ,[product_available]\n" +
"      ,[product_sales]\n" +
"      ,[product_price]\n" +
"      ,[product_voucher]\n" +
"      ,[product_description]\n" +
"	  ,requestSetRole.shopName\n" +
"  FROM [SWP391].[dbo].[ProductInfo]\n" +
"  JOIN requestSetRole ON ProductInfo.seller_id=requestSetRole.user_id\n" +
"   WHERE product_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Object productId = resultSet.getObject(1);
                Object sellerId=resultSet.getObject(2);
                String productName = resultSet.getString(4);
                String productImage = resultSet.getString(5);
                double productPrice = resultSet.getDouble(8);
                int productAvaiable = resultSet.getInt(6);
                String productDescription = resultSet.getString(10);
                String shopname=resultSet.getString(11);

                return new Product(productId, productName, productImage, productAvaiable, productPrice, productDescription,sellerId,shopname);

            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public Product getOneSellerAndShopByid(Object id) {
        String sql = "SELECT  [product_id]\n" +
"      ,[seller_id]\n" +
"      ,[type_id]\n" +
"      ,[product_name]\n" +
"      ,[product_image]\n" +
"      ,[product_price]\n" +
"	  ,requestSetRole.shopName\n" +
"  FROM [SWP391].[dbo].[ProductInfo]\n" +
"  JOIN requestSetRole On requestSetRole.user_id=ProductInfo.seller_id\n" +
"  WHERE product_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
 
            while (resultSet.next()) {
                 Object sellerid=resultSet.getObject(2);
                  String shopname = resultSet.getString(7);
                return new Product(sellerid,shopname);

            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public int getquantityProductsbyID(Object id) {
        String sql = "SELECT * FROM ProductInfo\n"
                + "  WHERE product_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            int productAvaiable = rs.getInt(6);
            return productAvaiable;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void xoasanpham(Object id) {
        try {
            String sql = "DELETE\n"
                    + "FROM [SWP391].[dbo].[ProductInfo]\n"
                    + "WHERE product_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void themsanpham(Object seller_id, Object type_id, String productname, String productimg,
            int productavai, double price, String des) {
        try {
            String sql = "INSERT INTO ProductInfo\n"
                    + "      (seller_id\n"
                    + "      ,type_id\n"
                    + "      ,product_name\n"
                    + "      ,product_image\n"
                    + "      ,product_available\n"
                    + "      ,product_price\n"
                    + "      ,product_description)\n"
                    + "Values(?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, seller_id);
            ps.setObject(2, type_id);
            ps.setString(3, productname);
            ps.setString(4, productimg);
            ps.setInt(5, productavai);
            ps.setDouble(6, price);
            ps.setString(7, des);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updatesanpham(String productname, String productimg,
            int productavai, double price, String des, Object id) {
        try {
            String sql = "UPDATE  ProductInfo\n"
                    + "  SET\n"
                    + "product_name =?,\n"
                    + "product_image =?,\n"
                    + "product_available=?,\n"
                    + "product_price=?,\n"
                    + "product_description=?\n"
                    + "WHERE product_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, productname);
            ps.setString(2, productimg);
            ps.setInt(3, productavai);
            ps.setDouble(4, price);
            ps.setString(5, des);
            ps.setObject(6, id);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean updatesanphamsaukhimuahang(Object id, int quantity) {
        try {
            int avai = getquantityProductsbyID(id);
            if (quantity > avai) {
                return false;
            } else {
                String sql = "UPDATE  ProductInfo\n"
                        + "SET\n"
                        + "product_available=?\n"
                        + "WHERE product_id=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, avai - quantity);
                ps.setObject(2, id);
                ps.execute();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public List<Product> getTop8() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT Top 8 * FROM ProductInfo";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object productId = resultSet.getObject(1);
                String productName = resultSet.getString(4);
                String productImage = resultSet.getString(5);
                double productPrice = resultSet.getDouble(8);
                String productDescription = resultSet.getString(10);

                Product product = new Product(productId, productName, productImage, productPrice, productDescription);
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM ProductInfo\n"
                + "WHERE product_name like ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, "%" + txtSearch + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object productId = resultSet.getObject(1);
                String productName = resultSet.getString(4);
                String productImage = resultSet.getString(5);
                double productPrice = resultSet.getDouble(8);
                String productDescription = resultSet.getString(10);

                Product product = new Product(productId, productName, productImage, productPrice, productDescription);
                list.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getNext8Products(int amount) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * \n"
                + "FROM ProductInfo\n"
                + "ORDER BY product_id\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT 8 ROWS ONLY;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, amount);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object productId = resultSet.getObject(1);
                String productName = resultSet.getString(4);
                String productImage = resultSet.getString(5);
                double productPrice = resultSet.getDouble(8);
                String productDescription = resultSet.getString(10);

                Product product = new Product(productId, productName, productImage, productPrice, productDescription);
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public int getTotalProductByTypeId(Object typeId) {
        String sql = "SELECT COUNT(*) FROM ProductInfo\n"
                + "WHERE type_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, typeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public String getTotalProductBySellerId(Object sellerId) {
        String sql = "SELECT COUNT(product_id) FROM ProductInfo WHERE seller_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, sellerId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String productCount = resultSet.getString(1);
                return productCount;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> getAllProductsPaging(Object type_id, int pageIndex, int pageSize) {
        List<Product> products = new ArrayList<>();
        String sql = "  SELECT *\n"
                + "FROM (\n"
                + "    SELECT [product_id]\n"
                + "        ,[seller_id]\n"
                + "        ,[type_id]\n"
                + "        ,[product_name]\n"
                + "        ,[product_image]\n"
                + "        ,[product_available]\n"
                + "        ,[product_sales]\n"
                + "        ,[product_price]\n"
                + "        ,[product_voucher]\n"
                + "        ,[product_description],\n"
                + "        ROW_NUMBER() OVER (ORDER BY product_id ASC) AS rn\n"
                + "    FROM [SWP391].[dbo].[ProductInfo]\n"
                + "	WHERE type_id = ?\n"
                + ") AS x\n"
                + "WHERE rn BETWEEN (? - 1) * ? + 1 AND ? * ?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, type_id);
            statement.setInt(2, pageIndex);
            statement.setInt(3, pageSize);
            statement.setInt(4, pageIndex);
            statement.setInt(5, pageSize);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object productId = resultSet.getObject(1);
                String productName = resultSet.getString(4);
                String productImage = resultSet.getString(5);
                double productPrice = resultSet.getDouble(8);
                String productDescription = resultSet.getString(10);

                Product product = new Product(productId, productName, productImage, productPrice, productDescription);
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO(); //khoi tao doi tuong dao
        Product product=dao.getOneSellerAndShopByid("093112CD-ABD1-41E7-81F9-0248396AB202");
        System.out.println(product.getSellerid()+" "+product.getShopname());
    }
}
