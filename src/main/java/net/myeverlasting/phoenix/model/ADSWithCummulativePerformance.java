package net.myeverlasting.phoenix.model;

import java.math.BigDecimal;
import java.util.Date;

public class ADSWithCummulativePerformance {
	
	private String customerSerialNumber;
	  private String accountNumber;
	  private String CustomerName;
	  private BigDecimal ADS;
	  private BigDecimal cummulative;
	  private BigDecimal compareADS;
	  private BigDecimal compareCummulative;
	  private String zoneName;
	  private Date refDate;
	public String getCustomerSerialNumber() {
		return customerSerialNumber;
	}
	public void setCustomerSerialNumber(String customerSerialNumber) {
		this.customerSerialNumber = customerSerialNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public BigDecimal getADS() {
		return ADS;
	}
	public void setADS(BigDecimal aDS) {
		ADS = aDS;
	}
	public BigDecimal getCummulative() {
		return cummulative;
	}
	public void setCummulative(BigDecimal cummulative) {
		this.cummulative = cummulative;
	}
	public BigDecimal getCompareADS() {
		return compareADS;
	}
	public void setCompareADS(BigDecimal compareADS) {
		this.compareADS = compareADS;
	}
	public BigDecimal getCompareCummulative() {
		return compareCummulative;
	}
	public void setCompareCummulative(BigDecimal compareCummulative) {
		this.compareCummulative = compareCummulative;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public Date getRefDate() {
		return refDate;
	}
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}
	  
	  
	  

}
