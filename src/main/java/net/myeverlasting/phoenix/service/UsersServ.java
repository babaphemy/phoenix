package net.myeverlasting.phoenix.service;

import java.util.List;







import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.repository.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usersServ")
@Transactional
public class UsersServ {
	
	@Autowired
	private UsersRepo userRep;
	
	
	public User findByEmail(String email){
		return userRep.findByEmail(email);
	}
	
	public List<User> findZoneCusts(Long id){
		return userRep.findByZone(id);
	}
	
	public User addUser(User user){
		return userRep.save(user);
	}
	@Secured("ROLE_ADMIN")
	public void deleteUser(Long uid){
		userRep.delete(uid);
	}
	private boolean hasDatainDb(Page<User> result){
		return result.getTotalElements() > 0;
	}
	
	@Transactional
	public User findById(Long uid){
		return userRep.findById(uid);
	}

}
