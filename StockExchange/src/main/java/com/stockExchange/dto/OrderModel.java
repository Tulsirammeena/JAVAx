package com.stockExchange.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderModel {
	private Integer orderId;
    public String OrderType; // Equivalent to OrderType
    private String companyName; // Requires a lookup or join to get the company name
    private LocalDateTime date;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal totalPrice;
    public String status; // Equivalent to OrderStatus

    public Integer getOrderId() {
        return orderId;
    }

    public void setTransactionId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setTransactionType(String OrderType) {
        this.OrderType = OrderType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setSharePrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
