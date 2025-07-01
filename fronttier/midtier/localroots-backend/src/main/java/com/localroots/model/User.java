package com.localroots.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users", schema = "localroots")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String role; // BUYER, FARMER, ADMIN

    @Column(nullable = false, length = 20)
    private String status = "ACTIVE";

    @Column(nullable = false)
    private Timestamp createdAt;

    // Constructors
    public User() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public User(String name, String email, String role, String status) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.status = status;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
