package com.stockExchange.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "holding")
public class HoldingEntity {
	
	@Id
	private Integer holdingId;
	private int noOfStocks;
	private Double averagePrice;
	private Double investedValue;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "stock_id", referencedColumnName ="symbol")
	private StockEntity stock;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "user_name",referencedColumnName = "userName")
	private UserEntity user;

}
