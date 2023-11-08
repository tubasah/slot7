/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Donhang {
    private Object id;
    Double total;
    Object iduser,idseller;
    String fullname,phone;
    Date date;
    String town,location;
    String status;
    Object productid;
    int quantity;
    Double price;
    String shopname;
    String img;
    String productname;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Donhang(Object id, Double total, Object iduser, Object idseller, String fullname, String phone, Date date, String town, String location, String status, Object productid, int quantity, Double price, String shopname, String img, String productname) {
        this.id = id;
        this.total = total;
        this.iduser = iduser;
        this.idseller = idseller;
        this.fullname = fullname;
        this.phone = phone;
        this.date = date;
        this.town = town;
        this.location = location;
        this.status = status;
        this.productid = productid;
        this.quantity = quantity;
        this.price = price;
        this.shopname = shopname;
        this.img = img;
        this.productname = productname;
    }
    

    public Donhang(Object id, Double total, Object iduser, Object idseller, String fullname, String phone, Date date, String town, String location, String status, Object productid, int quantity, Double price, String shopname, String img) {
        this.id = id;
        this.total = total;
        this.iduser = iduser;
        this.idseller = idseller;
        this.fullname = fullname;
        this.phone = phone;
        this.date = date;
        this.town = town;
        this.location = location;
        this.status = status;
        this.productid = productid;
        this.quantity = quantity;
        this.price = price;
        this.shopname = shopname;
        this.img = img;
    }
    
    public Donhang(Object id, Double total, Object iduser, Object idseller, String fullname, String phone, Date date, String town, String location, String status, Object productid, int quantity, Double price, String shopname) {
        this.id = id;
        this.total = total;
        this.iduser = iduser;
        this.idseller = idseller;
        this.fullname = fullname;
        this.phone = phone;
        this.date = date;
        this.town = town;
        this.location = location;
        this.status = status;
        this.productid = productid;
        this.quantity = quantity;
        this.price = price;
        this.shopname = shopname;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }
    
    public Donhang(Object id, Double total, Object iduser, Object idseller, String fullname, String phone, Date date, String town, String location, String status, Object productid, int quantity, Double price) {
        this.id = id;
        this.total = total;
        this.iduser = iduser;
        this.idseller = idseller;
        this.fullname = fullname;
        this.phone = phone;
        this.date = date;
        this.town = town;
        this.location = location;
        this.status = status;
        this.productid = productid;
        this.quantity = quantity;
        this.price = price;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Object getIduser() {
        return iduser;
    }

    public void setIduser(Object iduser) {
        this.iduser = iduser;
    }

    public Object getIdseller() {
        return idseller;
    }

    public void setIdseller(Object idseller) {
        this.idseller = idseller;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Donhang{" + "id=" + id + ", total=" + total + ", iduser=" + iduser + ", idseller=" + idseller + ", fullname=" + fullname + ", phone=" + phone + ", date=" + date + ", town=" + town + ", location=" + location + ", status=" + status + ", productid=" + productid + ", quantity=" + quantity + ", price=" + price + ", shopname=" + shopname + ", img=" + img + ", productname=" + productname + '}';
    }

    
    
            

    
    
}

