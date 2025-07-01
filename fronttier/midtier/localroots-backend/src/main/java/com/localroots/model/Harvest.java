package com.localroots.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.sql.Timestamp;

@Entity
@Table(name = "harvests", schema = "localroots")
public class Harvest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long harvestId;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerProfile farmer;

    @Column(nullable = false)
    private LocalDate harvestDate;

    @Column(nullable = false)
    private Timestamp createdAt;

    // Constructors
    public Harvest() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public Harvest(FarmerProfile farmer, LocalDate harvestDate) {
        this.farmer = farmer;
        this.harvestDate = harvestDate;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters

    public Long getHarvestId() {
        return harvestId;
    }
    public void setHarvestId(Long harvestId) {
        this.harvestId = harvestId;
    }
    public FarmerProfile getFarmer() {
        return farmer;
    }
    public void setFarmer(FarmerProfile farmer) {
        this.farmer = farmer;
    }
    public LocalDate getHarvestDate() {
        return harvestDate;
    }
    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
