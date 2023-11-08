
package Model;


/**
 *
 * @author DELL
 */
public class User {
    Object id;
    String name,password,email,number,country,province,district,town,location,image;
    int roleid;
    String fullname,gender,statusNow,school,favour,bio;
    String typerole;
    
    public User(String name, String image) {
        this.name = name;
        this.image = image;
    }
    
    public User(Object id, String name, String password, int roleid, String typerole) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roleid = roleid;
        this.typerole = typerole;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTyperole() {
        return typerole;
    }

    public void setTyperole(String typerole) {
        this.typerole = typerole;
    }
   

    public User(Object id, String name, String image, String fullname, String bio) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.fullname = fullname;
        this.bio = bio;
    }    
    

    public User(Object id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public User(Object id, String name, String email, String number, String image, int roleid) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.image = image;
        this.roleid = roleid;
    }
        
    public User(Object id, String name, String email, int roleid) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roleid = roleid;
    }

    public User(Object id, String name, String password, String email, int roleid) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.roleid = roleid;
    }

    public User(String name, String password, String email, int roleid) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.roleid = roleid;
    }

    public User(Object id, String name, String email, String number, String country, String province, String district, String town, String location, int roleid, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.country = country;
        this.province = province;
        this.district = district;
        this.town = town;
        this.location = location;
        this.roleid = roleid;
        this.image = image;
    }

    public User() {
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatusNow() {
        return statusNow;
    }

    public void setStatusNow(String statusNow) {
        this.statusNow = statusNow;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getFavour() {
        return favour;
    }

    public void setFavour(String favour) {
        this.favour = favour;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User(Object id, String number, String image, int roleid, String fullname, String gender, String statusNow, String school, String favour, String bio) {
        this.id = id;
        this.number = number;
        this.image = image;
        this.roleid = roleid;
        this.fullname = fullname;
        this.gender = gender;
        this.statusNow = statusNow;
        this.school = school;
        this.favour = favour;
        this.bio = bio;
    }//update profile

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", number=" + number + ", country=" + country + ", province=" + province + ", district=" + district + ", town=" + town + ", location=" + location + ", roleid=" + roleid + '}';
    }
    
 
}
