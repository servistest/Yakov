package jtable;

import java.sql.Date;
import java.time.LocalDate;

public class Company {
	private Integer orderID;
	private String symbol;
	private String quanity;
	private Double price;
	private LocalDate dateOrder;

	Company(Integer orderID,String symbol,String quanity,Double price,LocalDate dateOrder){
		this.orderID=orderID;
		this.symbol=symbol;
		this.quanity=quanity;
		this.price=price;
		this.dateOrder=dateOrder;
	}
	Company(String symbol,String quanity,Double price,LocalDate dateOrder){
		this.symbol=symbol;
		this.quanity=quanity;
		this.price=price;
		this.dateOrder=dateOrder;
	}
	Company(){
		super();
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getQuanity() {
		return quanity;
	}
	public void setQuanity(String quanity) {
		this.quanity = quanity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDate getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(LocalDate dateOrder) {
		this.dateOrder = dateOrder;
	}
	
}

