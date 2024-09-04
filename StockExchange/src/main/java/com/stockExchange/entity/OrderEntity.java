package com.stockExchange.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.stockExchange.dto.OrderStatus;
import com.stockExchange.dto.OrderType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "order_history")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
	private Integer orderId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "userName")
	private UserEntity user;

	@ManyToOne(optional = false)
	@JoinColumn(name = "stock_id", referencedColumnName = "symbol")
	private StockEntity stockDetail;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_type", nullable = false)
	private OrderType orderType;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private OrderStatus status;
	
	private LocalDateTime createdAt;
	
//	public OrderEntity(String stockId, String userId,Integer quantity, String orderType) {
//		
//	}
}
