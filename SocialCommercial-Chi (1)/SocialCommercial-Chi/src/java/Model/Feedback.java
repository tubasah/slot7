/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

public class Feedback {
    private Object id;
    private int rated_star;
    private String feedback;
    private String image;
    private boolean status;
    private Object product_id;
    private Object user_id;
    private Date date;
    private String product_name;
    private String email;
    private String phone;

    public Feedback() {
    }
    
    public Feedback(int rated_star, String feedback, String image, boolean status, Object product_id, Object user_id) {
        this.rated_star = rated_star;
        this.feedback = feedback;
        this.image = image;
        this.status = status;
        this.product_id = product_id;
        this.user_id = user_id;
    }
    
    public Feedback(Object id, int rated_star, String feedback, String image, boolean status, Object product_id, Object user_id, Date date) {
        this.id = id;
        this.rated_star = rated_star;
        this.feedback = feedback;
        this.image = image;
        this.status = status;
        this.product_id = product_id;
        this.user_id = user_id;
        this.date = date;
    }
    
    public Feedback(Object id, int rated_star, String feedback, String image, boolean status, Object product_id, Object user_id, Date date, String product_name) {
        this.id = id;
        this.rated_star = rated_star;
        this.feedback = feedback;
        this.image = image;
        this.status = status;
        this.product_id = product_id;
        this.user_id = user_id;
        this.date = date;
        this.product_name = product_name;
    }

    public Feedback(Object id, int rated_star, String feedback, String image, boolean status, Object product_id, Object user_id, Date date, String product_name, String email, String phone) {
        this.id = id;
        this.rated_star = rated_star;
        this.feedback = feedback;
        this.image = image;
        this.status = status;
        this.product_id = product_id;
        this.user_id = user_id;
        this.date = date;
        this.product_name = product_name;
        this.email = email;
        this.phone = phone;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public int getRated_star() {
        return rated_star;
    }

    public void setRated_star(int rated_star) {
        this.rated_star = rated_star;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Object product_id) {
        this.product_id = product_id;
    }

    public Object getUser_id() {
        return user_id;
    }

    public void setUser_id(Object user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", rated_star=" + rated_star + ", feedback=" + feedback + ", image=" + image + ", status=" + status + ", product_id=" + product_id + ", user_id=" + user_id + ", date=" + date + ", product_name=" + product_name + ", email=" + email + ", phone=" + phone + '}';
    }
    
    
}
