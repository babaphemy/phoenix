package net.myeverlasting.phoenix.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.myeverlasting.phoenix.model.Modules;
import net.myeverlasting.phoenix.service.ModulesServ;
import net.myeverlasting.phoenix.vo.ModulesVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(value="/protected/modules")
public class ModulesController {
	
	@Autowired
	private ModulesServ modServ;
	
	@ResponseBody
	@RequestMapping(value="/protected/modules", method=RequestMethod.GET, produces = "application/json")
	public List<Modules> mods(HttpServletRequest req){
		 return modServ.listAll();
	}
	
	

}
