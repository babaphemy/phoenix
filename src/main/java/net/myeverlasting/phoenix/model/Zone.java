package net.myeverlasting.phoenix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_zones")
public class Zone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Area area;
	private String name;
	private String code;
	@OneToOne
	private User officer;
	@OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="tbl_zone_customers")
	private List<User> customers = new ArrayList();
	private boolean accountOfficerAssigned;
	@OneToOne
	private Modules mother;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@OneToOne
	public User getOfficer() {
		return officer;
	}
	public void setOfficer(User officer) {
		this.officer = officer;
	}
	
	public List<User> getCustomers() {
		return customers;
	}
	public void setCustomers(List<User> customers) {
		this.customers = customers;
	}
	public boolean isAccountOfficerAssigned() {
		return accountOfficerAssigned;
	}
	public void setAccountOfficerAssigned(boolean accountOfficerAssigned) {
		this.accountOfficerAssigned = accountOfficerAssigned;
	}
	
	
	

}
