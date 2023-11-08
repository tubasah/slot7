
package Model;

import java.math.BigDecimal;
import java.util.Date;


public class Order {
    private Object id, customer_id, seller_id;
    private String fullname, phone;
    private BigDecimal order_total;
    private Date order_date;
    private String order_town, order_location, status;
    private int stt;

    public Order() {
    }

    public Order(Object id, Object customer_id, Object seller_id, String fullname, String phone, BigDecimal order_total, Date order_date, String order_town, String order_location, String status, int stt) {
        this.id = id;
        this.customer_id = customer_id;
        this.seller_id = seller_id;
        this.fullname = fullname;
        this.phone = phone;
        this.order_total = order_total;
        this.order_date = order_date;
        this.order_town = order_town;
        this.order_location = order_location;
        this.status = status;
        this.stt = stt;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Object customer_id) {
        this.customer_id = customer_id;
    }

    public Object getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Object seller_id) {
        this.seller_id = seller_id;
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

    public BigDecimal getOrder_total() {
        return order_total;
    }

    public void setOrder_total(BigDecimal order_total) {
        this.order_total = order_total;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getOrder_town() {
        return order_town;
    }

    public void setOrder_town(String order_town) {
        this.order_town = order_town;
    }

    public String getOrder_location() {
        return order_location;
    }

    public void setOrder_location(String order_location) {
        this.order_location = order_location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer_id=" + customer_id + ", seller_id=" + seller_id + ", fullname=" + fullname + ", phone=" + phone + ", order_total=" + order_total + ", order_date=" + order_date + ", order_town=" + order_town + ", order_location=" + order_location + ", status=" + status + ", stt=" + stt + '}';
    }
    
    
}
