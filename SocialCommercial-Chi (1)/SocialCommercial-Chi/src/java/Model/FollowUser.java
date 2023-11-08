
package Model;


public class FollowUser {
    private Object id, follower, following;

    public FollowUser() {
    }

    public FollowUser(Object id, Object follower, Object following) {
        this.id = id;
        this.follower = follower;
        this.following = following;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getFollower() {
        return follower;
    }

    public void setFollower(Object follower) {
        this.follower = follower;
    }

    public Object getFollowing() {
        return following;
    }

    public void setFollowing(Object following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "FollowUser{" + "id=" + id + ", follower=" + follower + ", following=" + following + '}';
    }
    
    
}
