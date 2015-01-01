package net.myeverlasting.phoenix.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.myeverlasting.phoenix.model.Contribution;
import net.myeverlasting.phoenix.model.MONTHS;
import net.myeverlasting.phoenix.model.RoleCategory;
import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.model.Zone;
import net.myeverlasting.phoenix.service.ContributionService;
import net.myeverlasting.phoenix.service.UsersServ;
import net.myeverlasting.phoenix.service.ZoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/protected/users")
public class UsersController {
	
	@Autowired
	private UsersServ useful;
	@Autowired
	private ZoneService zoneServ;
	@Autowired
	private ContributionService consSer;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcome(){
		return new ModelAndView("usersList");
		
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<User> zoneCusts(HttpServletRequest request){
		return findZoneCusts(request);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public String createUser(@ModelAttribute("user") User user,
							@RequestParam(required = false) String searchFor,
							HttpServletRequest request
						){
		user.setRole(RoleCategory.CUSTOMER);
		
		useful.addUser(user);
		System.out.println(user.getId() + " Saved");
		//HttpSession session = request.getSession();
		//User useri = (User) session.getAttribute("user");
		//Zone userz = zoneServ.findZoneById(useri.getId());
		
		//System.out.println(userz.getName() + " is the zone");
		//List<User> customers = findZoneCusts(request);
		//customers.add(user);
		//System.out.println(customers.size() + "customers got new guy");
		//zoneServ.saveZone(userz);
		//System.out.println(user.getId() + " addedd" + "to" + userz.getName());
		return "redirect:/protected/users";
		
	}
	
	@RequestMapping(value="/protected/users/configure", method = RequestMethod.POST, produces = "application/json")
	public String configure(@ModelAttribute("contribution") Contribution contribution,
											HttpServletRequest request){
		User customer = contribution.getCustomer();
		Calendar cal = Calendar.getInstance();
		cal.setTime(contribution.getStartDate());
		String month = cal.getDisplayName(2, 2, Locale.ENGLISH).toUpperCase();
	    int year = cal.get(1);
	    MONTHS monthEnum = MONTHS.valueOf(month);
	    contribution.setContributionMonth(monthEnum);
	    contribution.setContributionYear(year);
	    contribution.setStartTime(contribution.getStartDate());
	    contribution.setEndTime(contribution.getEndDate());
	    contribution.setStatus("NOT_CONSUMED");
	    contribution.setCustomer(customer);
	    // check if contribution exist
	    consSer.saveCon(contribution);
		return "redirect:/protected/users";
		
	}
	
	
	
	public List<User> findZoneCusts(HttpServletRequest request){
		HttpSession session = request.getSession();
		User useri = (User) session.getAttribute("user");
		Zone userz = zoneServ.findZoneById(useri.getId());
		List<User> customers = zoneServ.findCustomers(userz.getId());
		return customers;
	}
}
