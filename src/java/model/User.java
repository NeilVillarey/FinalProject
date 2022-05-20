package model;

/**
 *
 * @author user  
 *
 */
public class User {
    private String fullname, username, password, role;

    public User() {
        super();
    }

    public User(String fullname, String username, String password, String role) {
        super();
        this.fullname = fullname;
    
        this.username = username;
        this.password = password;
          this.role = role;
    }
    
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
   
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
 public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}

