
package Model;

import java.util.Date;


public class Notification {
    private Object id, user_id;
    private String notification_content;
    private Date notification_date;
    private String link_notify;
    private String reacter;

    public Notification() {
    }

    public Notification(Object id, Object user_id, String notification_content, Date notification_date, String link_notify, String reacter) {
        this.id = id;
        this.user_id = user_id;
        this.notification_content = notification_content;
        this.notification_date = notification_date;
        this.link_notify = link_notify;
        this.reacter = reacter;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getUser_id() {
        return user_id;
    }

    public void setUser_id(Object user_id) {
        this.user_id = user_id;
    }

    public String getNotification_content() {
        return notification_content;
    }

    public void setNotification_content(String notification_content) {
        this.notification_content = notification_content;
    }

    public Date getNotification_date() {
        return notification_date;
    }

    public void setNotification_date(Date notification_date) {
        this.notification_date = notification_date;
    }

    public String getLink_notify() {
        return link_notify;
    }

    public void setLink_notify(String link_notify) {
        this.link_notify = link_notify;
    }

    public String getReacter() {
        return reacter;
    }

    public void setReacter(String reacter) {
        this.reacter = reacter;
    }

    @Override
    public String toString() {
        return "Notification{" + "id=" + id + ", user_id=" + user_id + ", notification_content=" + notification_content + ", notification_date=" + notification_date + ", link_notify=" + link_notify + ", reacter=" + reacter + '}';
    }

   
}
