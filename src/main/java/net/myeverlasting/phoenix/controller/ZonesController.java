package net.myeverlasting.phoenix.controller;

import java.util.List;





import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.model.Zone;
import net.myeverlasting.phoenix.service.ZoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/protected/zones")
public class ZonesController {
	
	@Autowired
	private ZoneService zoneServ;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcome(){
		return new ModelAndView("zonesList");
		
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Zone> listAll(){
		return zoneServ.allZones();
	}
	
	public List<User> zoneCustomers(){
		return null;
		
	}

}
