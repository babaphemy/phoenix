package net.myeverlasting.phoenix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="st_roles")
public class Roles implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rid;
	@Enumerated(EnumType.STRING)
	private RoleCategory category;
	private String rolename;
	private String roledescription;
	@OneToMany
	private List<Modules> roleModules = new ArrayList();
	
	public Roles(){
		
	}

	
	public Roles(String rolename) {
		this.rolename = rolename;
	}


	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledescription() {
		return roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}
	


	public RoleCategory getCategory() {
		return category;
	}


	public void setCategory(RoleCategory category) {
		this.category = category;
	}


	public List<Modules> getRoleModules() {
		return roleModules;
	}


	public void setRoleModules(List<Modules> roleModules) {
		this.roleModules = roleModules;
	}


	@Override
	public int hashCode() {
		return this.rid.intValue() ;
	}


	public boolean equals(Object obj)
	  {
	    if ((obj instanceof Roles))
	    {
	      Roles role = (Roles)obj;
	      return this.rid.intValue() == role.getRid().intValue();
	    }
	    return false;
	  }
	  
	
	
	

}
