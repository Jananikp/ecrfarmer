package com.localroots.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders", schema = "localroots")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;

    @Column(nullable = false)
    private Timestamp orderDate;

    @Column(nullable = false, length = 20)
    private String status; // PLACED, DELIVERED, CANCELLED

    @Column(nullable = false, length = 20)
    private String paymentStatus; // PENDING, PAID, FAILED

    // Constructors
    public Order() {
        this.orderDate = new Timestamp(System.currentTimeMillis());
    }

    public Order(User buyer, String status, String paymentStatus) {
        this.buyer = buyer;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.orderDate = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public User getBuyer() {
        return buyer;
    }
    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
    public Timestamp getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
