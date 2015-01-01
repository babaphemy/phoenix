package net.myeverlasting.phoenix.model;

import java.math.BigDecimal;
import java.util.Date;

public class ContributionSummary {
	
	  private Long contributionId;
	  private User user;
	  private BigDecimal totalContributed;
	  private BigDecimal expectedContribution;
	  private BigDecimal todaysContribution = new BigDecimal("0");
	  private Date today;
	  private String status;
	  private int noOfDaysContributed;
	public Long getContributionId() {
		return contributionId;
	}
	public void setContributionId(Long contributionId) {
		this.contributionId = contributionId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BigDecimal getTotalContributed() {
		return totalContributed;
	}
	public void setTotalContributed(BigDecimal totalContributed) {
		this.totalContributed = totalContributed;
	}
	public BigDecimal getExpectedContribution() {
		return expectedContribution;
	}
	public void setExpectedContribution(BigDecimal expectedContribution) {
		this.expectedContribution = expectedContribution;
	}
	public BigDecimal getTodaysContribution() {
		return todaysContribution;
	}
	public void setTodaysContribution(BigDecimal todaysContribution) {
		this.todaysContribution = todaysContribution;
	}
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNoOfDaysContributed() {
		return noOfDaysContributed;
	}
	public void setNoOfDaysContributed(int noOfDaysContributed) {
		this.noOfDaysContributed = noOfDaysContributed;
	}
	  
	  
	  
	  

}
