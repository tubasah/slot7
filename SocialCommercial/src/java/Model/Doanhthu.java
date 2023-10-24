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
    Object id;
    Object sellerid;
    String shopname;
    int tongdonhang;
    Double tongdoanhthu;

    public Doanhthu(Object sellerid, String shopname, int tongdonhang, Double tongdoanhthu) {
        this.sellerid = sellerid;
        this.shopname = shopname;
        this.tongdonhang = tongdonhang;
        this.tongdoanhthu = tongdoanhthu;
    }

    @Override
    public String toString() {
        return "Tính đến nay shop của bạn, tức là "+shopname+" đã bán được "+tongdonhang+" đơn hàng"+" Tổng doanh thu "+tongdoanhthu;
    }
    
}
