package net.myeverlasting.phoenix.repository;

import java.util.List;



import net.myeverlasting.phoenix.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsersRepo extends CrudRepository<User, Long>{
	User findByEmail(String email);
	@Query("select u from User u where u.id = :id")
	List<User> findByZone(@Param("id") Long id);
	
	

}
