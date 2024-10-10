package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SalesOrder {

	private int orderNo;
	private LocalDateTime date;
	private String deliveryStatus;// i designklassediagram står Status, skal vi have som klasse Status?
	private LocalDate deliveryDate;
	private BigDecimal totalPrice;
	private List<SalesOrderLine> orderlines;
	private Customer customer;

	public SalesOrder(int orderNo, String deliveryStatus, LocalDate deliveryDate) {
		this.orderNo = orderNo;
		this.date = LocalDateTime.now();
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		orderlines = new ArrayList<SalesOrderLine>();
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<SalesOrderLine> getOrderlines() {
		return orderlines;
	}

	public boolean setOrderLines(List<SalesOrderLine> orderlines) {
		return this.setOrderLines(orderlines);
	}

	public boolean addOrderLine(SalesOrderLine orderline) {
		return orderlines.add(orderline);
	}

	public void addSaleOrderLinetoSaleOrder(Product product, int quantity) {
		SalesOrderLine orderline = new SalesOrderLine(product, quantity);
		addOrderLine(orderline);
	}

	public void addCustomerToOrder(Customer customer) {
		this.customer = customer;
	}

}
