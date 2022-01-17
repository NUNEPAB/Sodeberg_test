package data;

public class User {

    int id;
    String full_name;
    String email;
    String current_address;
    String permanent_address;

    public User(){

    }

    public User(int id, String full_name, String email, String current_address, String permanent_address) {
        this.id = id;
        if(full_name!=null){
            this.full_name = full_name;
        }
        if(email!=null){
            this.email = email;
        }
        if(current_address!=null) {
            this.current_address = current_address;
        }
        if(permanent_address!=null) {
            this.permanent_address = permanent_address;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrent_address() {
        return current_address;
    }

    public void setCurrent_address(String current_address) {
        this.current_address = current_address;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", email='" + email + '\'' +
                ", current_address='" + current_address + '\'' +
                ", permanent_address='" + permanent_address + '\'' +
                '}';
    }
}
