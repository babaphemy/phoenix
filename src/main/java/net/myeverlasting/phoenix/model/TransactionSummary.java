package net.myeverlasting.phoenix.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionSummary {
	
	  private BigDecimal incomingTotal;
	  private BigDecimal outgoingTotal;
	  private BigDecimal contributionTotal;
	  private Date transactionDate;
	public BigDecimal getIncomingTotal() {
		return incomingTotal;
	}
	public void setIncomingTotal(BigDecimal incomingTotal) {
		this.incomingTotal = incomingTotal;
	}
	public BigDecimal getOutgoingTotal() {
		return outgoingTotal;
	}
	public void setOutgoingTotal(BigDecimal outgoingTotal) {
		this.outgoingTotal = outgoingTotal;
	}
	public BigDecimal getContributionTotal() {
		return contributionTotal;
	}
	public void setContributionTotal(BigDecimal contributionTotal) {
		this.contributionTotal = contributionTotal;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	  
	  

}
