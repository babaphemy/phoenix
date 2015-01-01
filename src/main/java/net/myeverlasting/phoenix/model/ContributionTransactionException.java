package net.myeverlasting.phoenix.model;

public class ContributionTransactionException {
	
	  private Long contributionId;
	  private String exceptionMessage;
	public Long getContributionId() {
		return contributionId;
	}
	public void setContributionId(Long contributionId) {
		this.contributionId = contributionId;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	  
	  

}
