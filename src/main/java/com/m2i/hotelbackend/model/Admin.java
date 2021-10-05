package com.m2i.hotelbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @Column(name = "adminId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    /**
     * Constructeur par defaut
     */
    public Admin() {
    }

    /**
     * Constructeur surchargé sans ID
     * @param userName
     * @param password
     * @param role
     */
    public Admin(String userName, String password, String role) {
        setUserName(userName);
        setPassword(password);
        setRole(role);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(getId(), admin.getId()) && Objects.equals(getUserName(), admin.getUserName()) && Objects.equals(getPassword(), admin.getPassword()) && Objects.equals(getRole(), admin.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Admin{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
