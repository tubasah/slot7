
package Model;

import java.util.Date;


public class UserPost {
    private Object id;
    private Object user_id;
    private String post_title;
    private String post_content;
    private String post_image;
    private Date post_date;

    public UserPost() {
    }

    public UserPost(Object id, Object user_id, String post_title, String post_content, String post_image, Date post_date) {
        this.id = id;
        this.user_id = user_id;
        this.post_title = post_title;
        this.post_content = post_content;
        this.post_image = post_image;
        this.post_date = post_date;
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

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    @Override
    public String toString() {
        return "UserPost{" + "id=" + id + ", user_id=" + user_id + ", post_title=" + post_title + ", post_content=" + post_content + ", post_image=" + post_image + ", post_date=" + post_date + '}';
    }

    
    
}
