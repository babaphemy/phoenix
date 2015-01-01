package net.myeverlasting.phoenix.service;

import java.util.List;

import net.myeverlasting.phoenix.model.Contribution;
import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.repository.ContribRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContributionService {
	
	@Autowired
	private ContribRepo crep;
	
	public List<Contribution> allCons(){
		return crep.findAll();
	}
	
	public List<Contribution> findConByUser(User user){
		return crep.findConByCustomer(user);
	}
	
	public Long saveCon(Contribution contribution){
		crep.save(contribution);
		return contribution.getId();
	}
	
	

}
