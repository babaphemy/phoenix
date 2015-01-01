package net.myeverlasting.phoenix.repository;

import java.util.List;

import net.myeverlasting.phoenix.model.Contribution;
import net.myeverlasting.phoenix.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContribRepo extends JpaRepository<Contribution, Long> {
	
	@Query("SELECT d from Contribution d where d.customer = :cust")
	public List<Contribution> findConByCustomer(@Param("cust") User cust );
	
	

}
