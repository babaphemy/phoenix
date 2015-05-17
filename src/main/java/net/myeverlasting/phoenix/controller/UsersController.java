package net.myeverlasting.phoenix.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.myeverlasting.phoenix.model.Contribution;
import net.myeverlasting.phoenix.model.Record;
import net.myeverlasting.phoenix.model.RoleCategory;
import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.model.Zone;
import net.myeverlasting.phoenix.service.ContributionService;
import net.myeverlasting.phoenix.service.UsersServ;
import net.myeverlasting.phoenix.service.ZoneService;
import net.myeverlasting.phoenix.vo.Contribs;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping()
public class UsersController {
	
	@Autowired
	private UsersServ useful;
	@Autowired
	private ZoneService zoneServ;
	@Autowired
	private ContributionService consSer;
	
	@RequestMapping(value="/protected/users", method = RequestMethod.GET)
	public ModelAndView welcome(){
		return new ModelAndView("usersList");
		
	}
	
	@ResponseBody
	@RequestMapping(value="/protected/users",method = RequestMethod.GET, produces = "application/json")
	public List<User> zoneCusts(HttpServletRequest request){
		return findZoneCusts(request);
	}
	
	@RequestMapping(value="/protected/users", method = RequestMethod.POST, produces = "application/json")
	public String createUser(@ModelAttribute("user") User user,
							@RequestParam(required = false) String searchFor,
							HttpServletRequest request
						){
		user.setRole(RoleCategory.CUSTOMER);
		
		useful.addUser(user);
		System.out.println(user.getId() + " Saved");
		HttpSession session = request.getSession();
		User useri = (User) session.getAttribute("user");
		Zone userz = zoneServ.findZoneById(useri.getId());
		
		System.out.println(userz.getName() + " is the zone");
		//List<User> customers = findZoneCusts(request);
		Hibernate.initialize(userz.getCustomers());
		System.out.println(userz.getCustomers().size() + "customers in zone");
		//List<User> customers = userz.getCustomers();
		//customers.add(user);
		userz.getCustomers().add(user);
		zoneServ.saveZone(userz);
		System.out.println(user.getId() + " addedd" + "to" + userz.getName());
		return "usersList";
		
	}
	
	@RequestMapping(value="/protected/users/conf", method = RequestMethod.POST,produces = "application/json")
	public @ResponseBody void saveRecords(@RequestBody List<Record> record) {
		System.out.println(record);
		 Map<String, String> properties = new HashMap<String, String>();
		    properties.put("javax.persistence.jdbc.user", "root");
		    properties.put("javax.persistence.jdbc.password", "admin");
		    EntityManagerFactory ems = Persistence.createEntityManagerFactory("punit", properties);
		    EntityManager em = ems.createEntityManager();
		    
		for(int i=0; i<record.size(); i++ ){
			try {
				TypedQuery<User> q1 = em.createQuery(
						"SELECT c FROM User c where c.name='"+record.get(i).getName()+"' "
				                + "and c.accountNumber='"+record.get(i).getAccountNumber()+"' "
				                    + "and c.serialNumber='"+record.get(i).getSerialNumber()+"'", User.class
						);
				 List<User> users = q1.getResultList();
				 System.out.println(users.size() + "found");
				 
				 if(users.size() > 0){
					 TypedQuery<Contribution> q2 = em.createQuery("SELECT c FROM Contribution c WHERE c.customer = :customer", Contribution.class);
					 q2.setParameter("customer", users.get(0));
					 List<Contribution> cons = q2.getResultList();
					 if(cons.size()>0){
						 em.getTransaction().begin();
						 cons.get(0).setExpectedAmount(new BigDecimal(record.get(i).getExpected()));
				            cons.get(0).setMonthlyContributable(new BigDecimal(record.get(i).getAds()));
				            cons.get(0).setNoOfDaysInMonth(Integer.parseInt(record.get(i).getDaysInMonth()));
				            em.getTransaction().commit();
					 }
				 }
				 
				 
			}//catch (HibernateException e) {
               // e.printStackTrace(System.err);
                //LOG.error(e.getMessage(), e);
            //} 
			finally{
				em.close();
			}
		}
		
		//consSer.saveCons(record);
	}
	
	
	
	public List<User> findZoneCusts(HttpServletRequest request){
		HttpSession session = request.getSession();
		User useri = (User) session.getAttribute("user");
		Zone userz = zoneServ.findZoneById(useri.getId());
		List<User> customers = zoneServ.findCustomers(userz.getId());
		return customers;
	}
}
