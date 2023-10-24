/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Messenger {
    private Object id;
    private Object senderid,receiverid;
    
    private String content;
    private Date date;

    public Messenger() {
    }

    public Messenger(Object receiverid, Object senderid, Date date, Object id, String content) {
        this.receiverid = receiverid;
        this.senderid = senderid;
        this.date = date;
        this.id = id;
        this.content = content;
    }

    public Object getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Object receiverid) {
        this.receiverid = receiverid;
    }

    public Object getSenderid() {
        return senderid;
    }

    public void setSenderid(Object senderid) {
        this.senderid = senderid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Messenger{" + "id=" + id + ", senderid=" + senderid + ", receiverid=" + receiverid + ", content=" + content + ", date=" + date + '}';
    }

    
    
}
