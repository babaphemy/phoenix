package net.myeverlasting.phoenix.model;

import java.math.BigDecimal;

public class WithdrawalHolder {
	  private Long zoneId;
	  private Long areaId;
	  private Long customerId;
	  private String customerName;
	  private String customerNickName;
	  private BigDecimal trustFundAmount;
	  public Long getZoneId() {
		return zoneId;
	}
	
	  public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNickName() {
		return customerNickName;
	}
	public void setCustomerNickName(String customerNickName) {
		this.customerNickName = customerNickName;
	}
	public BigDecimal getTrustFundAmount() {
		return trustFundAmount;
	}
	public void setTrustFundAmount(BigDecimal trustFundAmount) {
		this.trustFundAmount = trustFundAmount;
	}
	public BigDecimal getCurrentCummulativeAmount() {
		return currentCummulativeAmount;
	}
	public void setCurrentCummulativeAmount(BigDecimal currentCummulativeAmount) {
		this.currentCummulativeAmount = currentCummulativeAmount;
	}
	public BigDecimal getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}
	private BigDecimal currentCummulativeAmount;
	  private BigDecimal withdrawalAmount;
	  
	  

}
