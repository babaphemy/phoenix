package net.myeverlasting.phoenix.service;

import java.util.List;

import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.model.Zone;
import net.myeverlasting.phoenix.repository.ZoneRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ZoneService {
	
	@Autowired
	private ZoneRepo zoneRep;
	
	public List<Zone> allZones(){
		return zoneRep.findAll();
	}
	
	public Zone findZoneById(Long id){
		return zoneRep.findById(id);
	}
	
	public void saveZone(Zone zone){
		zoneRep.save(zone);
	}
	
	public List<User> findCustomers(Long zoid){
		return zoneRep.findCustomers(zoid);
		
	}
	
	

}
