package net.myeverlasting.phoenix.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_customer_contribution")
public class Contribution implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private User customer;
	private BigDecimal monthlyContributable;
	@OneToMany(mappedBy="contribution", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
	private List<Transaction> transactions;
	private BigDecimal cummulative = new BigDecimal("0.00");
	private BigDecimal expectedAmount;
	@Enumerated(EnumType.STRING)
	private MONTHS contributionMonth;
	private int contributionYear;
	private int noOfDaysContributed;
	private int noOfDaysInMonth;
	@Enumerated(EnumType.STRING)
	private ContributionPaymentStatus paymentStatus;
	private Date startDate;
	private Date startTime;
	private Date endDate;
	private Date endTime;
	private Long previousContributionId;
	private String status;
	
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public BigDecimal getMonthlyContributable() {
		return monthlyContributable;
	}
	public void setMonthlyContributable(BigDecimal monthlyContributable) {
		this.monthlyContributable = monthlyContributable;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public BigDecimal getCummulative() {
		return cummulative;
	}
	public void setCummulative(BigDecimal cummulative) {
		this.cummulative = cummulative;
	}
	public BigDecimal getExpectedAmount() {
		return expectedAmount;
	}
	public void setExpectedAmount(BigDecimal expectedAmount) {
		this.expectedAmount = expectedAmount;
	}
	
	public MONTHS getContributionMonth() {
		return contributionMonth;
	}
	public void setContributionMonth(MONTHS contributionMonth) {
		this.contributionMonth = contributionMonth;
	}
	public int getContributionYear() {
		return contributionYear;
	}
	public void setContributionYear(int contributionYear) {
		this.contributionYear = contributionYear;
	}
	public int getNoOfDaysContributed() {
		return noOfDaysContributed;
	}
	public void setNoOfDaysContributed(int noOfDaysContributed) {
		this.noOfDaysContributed = noOfDaysContributed;
	}
	public int getNoOfDaysInMonth() {
		return noOfDaysInMonth;
	}
	public void setNoOfDaysInMonth(int noOfDaysInMonth) {
		this.noOfDaysInMonth = noOfDaysInMonth;
	}
	public ContributionPaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(ContributionPaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Long getPreviousContributionId() {
		return previousContributionId;
	}
	public void setPreviousContributionId(Long previousContributionId) {
		this.previousContributionId = previousContributionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
