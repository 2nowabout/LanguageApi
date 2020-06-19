package main.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.ws.rs.Consumes;

@Entity
@Table(name = "User", schema = "languages")
public class User {
    private int userId;
    private String username;
    private String email;
    private String pictureLocation;
    private String password;

    @JsonManagedReference
    private Language chosenLanguage;

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "pictureLocation")
    public String getPictureLocation() {
        return pictureLocation;
    }

    public void setPictureLocation(String pictureLocation) {
        this.pictureLocation = pictureLocation;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "chosenLanguage", referencedColumnName = "uniqueId")
    public Language getChosenLanguage() {
        return chosenLanguage;
    }

    public void setChosenLanguage(Language chosenLanguage) {
        this.chosenLanguage = chosenLanguage;
    }
}
