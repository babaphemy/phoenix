package net.myeverlasting.phoenix.controller;

import java.util.List;

import net.myeverlasting.phoenix.model.Modules;
import net.myeverlasting.phoenix.service.ModulesServ;
import net.myeverlasting.phoenix.vo.ModulesVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/protected/modules")
public class ModulesController {
	
	@Autowired
	private ModulesServ modServ;
	
	
	public ResponseEntity<?> getMods(){
		List<Modules> mods = modServ.listAll();
		return (ResponseEntity<?>) mods;
	}
	
	

}
