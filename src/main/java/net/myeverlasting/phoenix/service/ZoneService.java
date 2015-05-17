package net.myeverlasting.phoenix.service;

import java.util.List;

import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.model.Zone;
import net.myeverlasting.phoenix.repository.ZoneRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service("zoneServ")
public class ZoneService {
	
	@Autowired
	private ZoneRepo zoneRep;
	
	public List<Zone> allZones(){
		return zoneRep.findAll();
	}
	
	@Transactional
	public Zone findZoneById(Long id){
		Zone zone =  zoneRep.findById(id);
		System.out.println(zone.getCustomers().size() + "customers");
		return zone;
	}
	
	public void saveZone(Zone zone){
		zoneRep.saveAndFlush(zone);
	}
	
	public List<User> findCustomers(Long zoid){
		return zoneRep.findCustomers(zoid);
		
	}
	
	

}
