package net.myeverlasting.phoenix.service;

import java.util.List;

import net.myeverlasting.phoenix.model.Modules;
import net.myeverlasting.phoenix.repository.ModulesRepo;
import net.myeverlasting.phoenix.vo.ModulesVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModulesServ {
	
	@Autowired
	private ModulesRepo modulesRep;
	
	public List<Modules> listAll(){
		return modulesRep.findAll();
	}
	

}
