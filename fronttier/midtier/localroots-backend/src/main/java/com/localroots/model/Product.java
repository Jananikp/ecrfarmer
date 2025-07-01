package com.localroots.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products", schema = "localroots")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "harvest_id", nullable = false)
    private Harvest harvest;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private FarmerProfile farmerProfile;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(length = 255)
    private String imageUrl;

    // Constructors
    public Product() {}

    public Product(Harvest harvest, FarmerProfile farmerProfile, String name, String description, BigDecimal price, Integer quantity, String imageUrl) {
        this.harvest = harvest;
        this.farmerProfile = farmerProfile;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Harvest getHarvest() {
        return harvest;
    }
    public void setHarvest(Harvest harvest) {
        this.harvest = harvest;
    }
    public FarmerProfile getFarmerProfile() {
        return farmerProfile;
    }
    public void setFarmerProfile(FarmerProfile farmerProfile) {
        this.farmerProfile = farmerProfile;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}