package com.localroots.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "farmer_profiles", schema = "localroots")
public class FarmerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmerId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 255)
    private String bio;

    @Column(length = 100)
    private String location;

    @Column(length = 255)
    private String photoUrl;

    @Column(nullable = false)
    private Boolean verified = false;
    // Add to FarmerProfile.java
    @OneToMany(mappedBy = "farmerProfile",fetch = FetchType.EAGER)
    private List<Product> products;

    // Constructors
    public FarmerProfile() {}

    // public FarmerProfile(User user, String bio, String location, String photoUrl, Boolean verified) {
    //     this.user = user;
    //     this.bio = bio;
    //     this.location = location;
    //     this.photoUrl = photoUrl;
    //     this.verified = verified;
    //     //this.products =
    // }
    public FarmerProfile(User user, String bio, String location, String photoUrl, Boolean verified, List<Product> products) {
        this.user = user;
        this.bio = bio;
        this.location = location;
        this.photoUrl = photoUrl;
        this.verified = verified;
        this.products = products;
    }
    // Getters and Setters
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public Long getFarmerId() {
        return farmerId;
    }
    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    public Boolean getVerified() {
        return verified;
    }
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}
