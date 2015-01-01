package net.myeverlasting.phoenix.model;

import java.math.BigDecimal;

public class FooterDetails {
	
	  private BigDecimal totalAmountContributed = new BigDecimal(0);
	  private BigDecimal totalExpectedAmount = new BigDecimal(0);
	public BigDecimal getTotalAmountContributed() {
		return totalAmountContributed;
	}
	public void setTotalAmountContributed(BigDecimal totalAmountContributed) {
		this.totalAmountContributed = totalAmountContributed;
	}
	public BigDecimal getTotalExpectedAmount() {
		return totalExpectedAmount;
	}
	public void setTotalExpectedAmount(BigDecimal totalExpectedAmount) {
		this.totalExpectedAmount = totalExpectedAmount;
	}
	  
	  
	  
	  

}
