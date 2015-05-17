package net.myeverlasting.phoenix.repository;



import java.util.List;

import net.myeverlasting.phoenix.model.User;
import net.myeverlasting.phoenix.model.Zone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository("zoneRep")
public interface ZoneRepo extends JpaRepository<Zone, Long> {
	Zone findByName(String name);
	
	@Query("SELECT z from Zone z where z.officer.id= :zid")
	Zone findById(@Param("zid") Long zid);
	
	@Query("SELECT c.customers from Zone c where c.officer.id= :zoid")
	List<User> findCustomers(@Param("zoid") Long zoid);
	

		


}
