package net.myeverlasting.phoenix.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_archives")
public class Archives implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private BigDecimal amount;
	@Temporal(TemporalType.DATE)
	private Date dateentered;
	private String narration;
	@Temporal(TemporalType.DATE)
	private Date archivedduedate;
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="tbl_archives_customers")
	List<User> customers;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDateentered() {
		return dateentered;
	}
	public void setDateentered(Date dateentered) {
		this.dateentered = dateentered;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public Date getArchivedduedate() {
		return archivedduedate;
	}
	public void setArchivedduedate(Date archivedduedate) {
		this.archivedduedate = archivedduedate;
	}
	public List<User> getCustomers() {
		return customers;
	}
	public void setCustomers(List<User> customers) {
		this.customers = customers;
	}

	
	

}
