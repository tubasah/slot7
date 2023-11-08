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
public class requestOfUser {
    private Object id,userid;
    private String email,fullName,shopName;
            Object commoditiesSector;
            String address,phone,namecateogry,status;

    public requestOfUser(Object id, Object userid, String email, String fullName, String shopName, Object commoditiesSector, String address, String phone, String namecateogry, String status) {
        this.id = id;
        this.userid = userid;
        this.email = email;
        this.fullName = fullName;
        this.shopName = shopName;
        this.commoditiesSector = commoditiesSector;
        this.address = address;
        this.phone = phone;
        this.namecateogry = namecateogry;
        this.status = status;
    }


    public requestOfUser(Object userid, String email, String fullName, String shopName, Object commoditiesSector, String address, String phone) {
        this.userid = userid;
        this.email = email;
        this.fullName = fullName;
        this.shopName = shopName;
        this.commoditiesSector = commoditiesSector;
        this.address = address;
        this.phone = phone;
    }

    public requestOfUser(Object id, Object userid, String email, String fullName, String shopName, Object commoditiesSector, String address, String phone) {
        this.id = id;
        this.userid = userid;
        this.email = email;
        this.fullName = fullName;
        this.shopName = shopName;
        this.commoditiesSector = commoditiesSector;
        this.address = address;
        this.phone = phone;
    }

    public requestOfUser() {
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getUserid() {
        return userid;
    }

    public void setUserid(Object userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Object getCommoditiesSector() {
        return commoditiesSector;
    }

    public void setCommoditiesSector(Object commoditiesSector) {
        this.commoditiesSector = commoditiesSector;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNamecateogry() {
        return namecateogry;
    }

    public void setNamecateogry(String namecateogry) {
        this.namecateogry = namecateogry;
    }

    @Override
    public String toString() {
        return "requestOfUser{" + "\u00ecd=" + id + ", userid=" + userid + ", email=" + email + ", fullName=" + fullName + ", shopName=" + shopName + ", commoditiesSector=" + commoditiesSector + ", address=" + address + ", phone=" + phone + ", namecateogry=" + namecateogry + ", status=" + status + '}';
    }

  

    
    
}
