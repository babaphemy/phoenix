package net.myeverlasting.phoenix.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_trust_fund_activity_log")
public class TrustFundActivityLog implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;  
	private Long customerId;
	  private BigDecimal amount;
	  private BigDecimal previousAmount;
	  private BigDecimal currentAmount;
	  @Enumerated(EnumType.STRING)
	  private MONTHS months;
	  @Column(name="year_")
	  private int year;
	  private Long userPerformedBy;
	  @Temporal(TemporalType.DATE)
	  private Date createdDate;
	  @Temporal(TemporalType.TIMESTAMP)
	  private Date createdTime;
	  private String description;
	  @Enumerated(EnumType.STRING)
	  private TrustFundLogType trustFundLogType;
	
	
	  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getPreviousAmount() {
		return previousAmount;
	}
	public void setPreviousAmount(BigDecimal previousAmount) {
		this.previousAmount = previousAmount;
	}
	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}
	
	public MONTHS getMonths() {
		return months;
	}
	public void setMonths(MONTHS months) {
		this.months = months;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Long getUserPerformedBy() {
		return userPerformedBy;
	}
	public void setUserPerformedBy(Long userPerformedBy) {
		this.userPerformedBy = userPerformedBy;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public TrustFundLogType getTrustFundLogType() {
		return trustFundLogType;
	}
	public void setTrustFundLogType(TrustFundLogType trustFundLogType) {
		this.trustFundLogType = trustFundLogType;
	}
	  
	  

}
