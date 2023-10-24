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
public class Cart {
    private Object id,userid;
    

    public Cart(Object id, Object userid) {
        this.id = id;
        this.userid = userid;
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

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", userid=" + userid + '}';
    }
    
}
