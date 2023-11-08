/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DELL
 */
public class Doanhthu {
    private Object sellerid;
    private Object productId;
    private String productName;
    private String productImage;
    private double productPrice;
    private int totalBuy;
    private double totalSales;

    public Doanhthu() {
    }

    public Doanhthu(Object sellerid, Object productId, String productName, String productImage, double productPrice, int totalBuy, double totalSales) {
        this.sellerid = sellerid;
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.totalBuy = totalBuy;
        this.totalSales = totalSales;
    }

    public Object getSellerid() {
        return sellerid;
    }

    public void setSellerid(Object sellerid) {
        this.sellerid = sellerid;
    }

    public Object getProductId() {
        return productId;
    }

    public void setProductId(Object productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getTotalBuy() {
        return totalBuy;
    }

    public void setTotalBuy(int totalBuy) {
        this.totalBuy = totalBuy;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
    
    

    @Override
    public String toString() {
        return "Doanhthu{" + "sellerid=" + sellerid + ", productId=" + productId + ", productName=" + productName + ", productImage=" + productImage + ", productPrice=" + productPrice + ", totalBuy=" + totalBuy + ", totalSales=" + totalSales + '}';
    }

    
    
}
