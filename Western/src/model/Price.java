package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Price {
	
	private LocalDate date;
	private BigDecimal amount;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


}
