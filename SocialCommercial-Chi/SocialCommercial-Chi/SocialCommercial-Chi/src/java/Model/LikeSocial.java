
package Model;


public class LikeSocial {
    private Object id;
    private Object post_id;
    private Object liker_id;

    public LikeSocial() {
    }

    public LikeSocial(Object id, Object post_id, Object liker_id) {
        this.id = id;
        this.post_id = post_id;
        this.liker_id = liker_id;
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

    public Object getLiker_id() {
        return liker_id;
    }

    public void setLiker_id(Object liker_id) {
        this.liker_id = liker_id;
    }

    @Override
    public String toString() {
        return "LikeSocial{" + "id=" + id + ", post_id=" + post_id + ", liker_id=" + liker_id + '}';
    }
    
    
}
