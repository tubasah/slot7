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
public class ItemInCart {
   private Object id,cartid,productid;
    private int quantity;
   private  Object userid;
  private   Object sellerid;
  private   String productname,img;
  private   Double price;
  private  String shopname;


    public ItemInCart(Object productid, int quantity, Object sellerid, Double price, String shopname) {
        this.productid = productid;
        this.quantity = quantity;
        this.sellerid = sellerid;
        this.price = price;
        this.shopname = shopname;
    }

    public ItemInCart(Object id, Object productid, int quantity, Object sellerid, Double price, String shopname) {
        this.id = id;
        this.productid = productid;
        this.quantity = quantity;
        this.sellerid = sellerid;
        this.price = price;
        this.shopname = shopname;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public ItemInCart(Object id, Object cartid, Object productid, int quantity, Object userid, Object sellerid, String productname, String img, Double price, String shopname) {
        this.id = id;
        this.cartid = cartid;
        this.productid = productid;
        this.quantity = quantity;
        this.userid = userid;
        this.sellerid = sellerid;
        this.productname = productname;
        this.img = img;
        this.price = price;
        this.shopname = shopname;
    }
   
    public ItemInCart(Object cartid, Object productid, int quantity, Object userid, Object sellerid, String productname, String img, Double price) {
        this.cartid = cartid;
        this.productid = productid;
        this.quantity = quantity;
        this.userid = userid;
        this.sellerid = sellerid;
        this.productname = productname;
        this.img = img;
        this.price = price;
    }

    public Object getUserid() {
        return userid;
    }

    public void setUserid(Object userid) {
        this.userid = userid;
    }

    public Object getSellerid() {
        return sellerid;
    }

    public void setSellerid(Object sellerid) {
        this.sellerid = sellerid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        String formattedPrice = String.valueOf(price);

    // Kiểm tra xem chuỗi có phần thập phân ".0" không và loại bỏ nó nếu có
    if (formattedPrice.endsWith(".0")) {
        formattedPrice = formattedPrice.substring(0, formattedPrice.length() - 2);
    }

    // Chuyển lại thành double
    return Double.parseDouble(formattedPrice);
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ItemInCart(Object id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public ItemInCart(Object id, Object cartid, Object productid, int quantity, Object userid, Object sellerid, String productname, String img, Double price) {
        this.id = id;
        this.cartid = cartid;
        this.productid = productid;
        this.quantity = quantity;
        this.userid = userid;
        this.sellerid = sellerid;
        this.productname = productname;
        this.img = img;
        this.price = price;
    }
    

    public ItemInCart(Object id, Object cartid, Object productid, int quantity) {
        this.id = id;
        this.cartid = cartid;
        this.productid = productid;
        this.quantity = quantity;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getCartid() {
        return cartid;
    }

    public void setCartid(Object cartid) {
        this.cartid = cartid;
    }

    public Object getProductid() {
        return productid;
    }

    public void setProductid(Object productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemInCart{" + "id=" + id + ", cartid=" + cartid + ", productid=" + productid + ", quantity=" + quantity + ", userid=" + userid + ", sellerid=" + sellerid + ", productname=" + productname + ", img=" + img + ", price=" + this.getPrice() + ", shopname=" + shopname + '}';
    }

    public ItemInCart(Object productid, Object sellerid, String productname, String img, Double price, String shopname) {
        this.productid = productid;
        this.sellerid = sellerid;
        this.productname = productname;
        this.img = img;
        this.price = price;
        this.shopname = shopname;
    }



    
}
