package entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String hashPassword;

    private String salt;
    private boolean isAdmin;

    public User(String username, String hashPassword, String salt) {
        this.username = username;
        this.hashPassword = hashPassword;
        this.salt = salt;
        this.isAdmin = false;
    }

    public User(String username, String hashPassword, String salt, boolean isAdmin) {
        this.username = username;
        this.hashPassword = hashPassword;
        this.salt = salt;
        this.isAdmin = isAdmin;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hash_password) {
        this.hashPassword = hash_password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
