package net.myeverlasting.phoenix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.myeverlasting.phoenix.model.Contribution;
import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.model.Zone;
import net.myeverlasting.phoenix.service.ContributionService;
import net.myeverlasting.phoenix.service.ZoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/protected/contributions")
public class ContributionsController {
	
	@Autowired
	private ContributionService consServ;
	@Autowired
	private ZoneService zoneServ;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcome(){
		return new ModelAndView("contrib");
		
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Contribution> findContributions(HttpServletRequest request){ // configured contributions for zone cust
		HttpSession session = request.getSession();
		User useri = (User) session.getAttribute("user");
		Zone userz = zoneServ.findZoneById(useri.getId());
		List<User> customers = zoneServ.findCustomers(userz.getId());
		List<Contribution> conc = new ArrayList<Contribution>();
		for(User u : customers){
			conc = consServ.findConByUser(u);
			
		}
		return conc;
		
		
	}
	
	
	
	

}
