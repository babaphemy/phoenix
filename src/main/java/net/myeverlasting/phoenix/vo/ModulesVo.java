package net.myeverlasting.phoenix.vo;

import java.util.List;

import net.myeverlasting.phoenix.model.Modules;

public class ModulesVo {
	
	private List<Modules> modules;
	private Long totalModules;
	
	public ModulesVo(){
		
	}
	public ModulesVo(List<Modules> modules, Long totalModules) {
		this.modules = modules;
		this.totalModules = totalModules;
	}
	public List<Modules> getModules() {
		return modules;
	}
	public void setModules(List<Modules> modules) {
		this.modules = modules;
	}
	public Long getTotalModules() {
		return totalModules;
	}
	public void setTotalModules(Long totalModules) {
		this.totalModules = totalModules;
	}
	
	
	

}
