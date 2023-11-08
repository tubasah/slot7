
package Model;

import java.util.Date;


public class CommentSocial {
    private Object id;
    private Object post_id;
    private Object commentor_id;
    private String comment_content;
    private Date comment_date;

    public CommentSocial() {
    }

    public CommentSocial(Object id, Object post_id, Object commentor_id, String comment_content, Date comment_date) {
        this.id = id;
        this.post_id = post_id;
        this.commentor_id = commentor_id;
        this.comment_content = comment_content;
        this.comment_date = comment_date;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getPost_id() {
        return post_id;
    }

    public void setPost_id(Object post_id) {
        this.post_id = post_id;
    }

    public Object getCommentor_id() {
        return commentor_id;
    }

    public void setCommentor_id(Object commentor_id) {
        this.commentor_id = commentor_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CommentSocial{");
        sb.append("id=").append(id);
        sb.append(", post_id=").append(post_id);
        sb.append(", commentor_id=").append(commentor_id);
        sb.append(", comment_content=").append(comment_content);
        sb.append(", comment_date=").append(comment_date);
        sb.append('}');
        return sb.toString();
    }
    
    
}
