package net.myeverlasting.phoenix.model;

import java.math.BigDecimal;

public class TrustfundReportData {
	
	  private String zoneName;
	  private String areaName;
	  private BigDecimal trustfundBalance;
	  private BigDecimal withdrawers;
	  private BigDecimal currentCommisionGenerated;
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public BigDecimal getTrustfundBalance() {
		return trustfundBalance;
	}
	public void setTrustfundBalance(BigDecimal trustfundBalance) {
		this.trustfundBalance = trustfundBalance;
	}
	public BigDecimal getWithdrawers() {
		return withdrawers;
	}
	public void setWithdrawers(BigDecimal withdrawers) {
		this.withdrawers = withdrawers;
	}
	public BigDecimal getCurrentCommisionGenerated() {
		return currentCommisionGenerated;
	}
	public void setCurrentCommisionGenerated(BigDecimal currentCommisionGenerated) {
		this.currentCommisionGenerated = currentCommisionGenerated;
	}
	  
	  

}
