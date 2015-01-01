package net.myeverlasting.phoenix.repository;

import net.myeverlasting.phoenix.model.Modules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ModulesRepo extends JpaRepository<Modules, Long> {

}
