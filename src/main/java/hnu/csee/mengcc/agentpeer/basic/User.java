package hnu.csee.mengcc.agentpeer.basic;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String email;
    private String password;
    private String role;
    private Date registerTime;
    private Date lastLoginTime;

    public User() {
    }

    public User(String email, String password, String role, Date registerTime, Date lastLoginTime) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.registerTime = registerTime;
        this.lastLoginTime = lastLoginTime;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Date getRegisteredAt() {
        return registerTime;
    }

    public Date getLastLoginAt() {
        return lastLoginTime;
    }

    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginTime = lastLoginAt;
    }
}
