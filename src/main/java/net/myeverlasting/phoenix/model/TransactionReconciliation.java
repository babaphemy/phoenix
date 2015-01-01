package net.myeverlasting.phoenix.model;

import java.math.BigDecimal;
import java.util.Date;


public class TransactionReconciliation {
	
	  private BigDecimal amountAccountOfficerProvided;
	  private BigDecimal amountSummationProvidedByClerk;
	  private Date dateInFocus;
	  private Zone zone;
	public BigDecimal getAmountAccountOfficerProvided() {
		return amountAccountOfficerProvided;
	}
	public void setAmountAccountOfficerProvided(
			BigDecimal amountAccountOfficerProvided) {
		this.amountAccountOfficerProvided = amountAccountOfficerProvided;
	}
	public BigDecimal getAmountSummationProvidedByClerk() {
		return amountSummationProvidedByClerk;
	}
	public void setAmountSummationProvidedByClerk(
			BigDecimal amountSummationProvidedByClerk) {
		this.amountSummationProvidedByClerk = amountSummationProvidedByClerk;
	}
	public Date getDateInFocus() {
		return dateInFocus;
	}
	public void setDateInFocus(Date dateInFocus) {
		this.dateInFocus = dateInFocus;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	  
	  

}
