/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.UUID;

/**
 *
 * @author DELL
 */
public class Category {
    private Object cid;
    private String type;

    public Category() {
    }

    public Category(Object cid, String type) {
        this.cid = cid;
        this.type = type;
    }

    public Object getCid() {
        return cid;
    }

    public void setCid(Object cid) {
        this.cid = cid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" + "cid=" + cid + ", type=" + type + '}';
    }

    
    
    
            
}
