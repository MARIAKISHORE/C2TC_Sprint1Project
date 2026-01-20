package com.devmart.orderflowservice;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_records")
public class OrderRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long customerId;
    private Long shopId;
    private double totalAmount;
    private String orderStatus;
    private LocalDateTime orderDate;

    public OrderRecordEntity() {
        this.orderDate = LocalDateTime.now();
        this.orderStatus = "PLACED";
    }

    // Getters and Setters
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public Long getShopId() { return shopId; }
    public void setShopId(Long shopId) { this.shopId = shopId; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public LocalDateTime getOrderDate() { return orderDate; }
}
