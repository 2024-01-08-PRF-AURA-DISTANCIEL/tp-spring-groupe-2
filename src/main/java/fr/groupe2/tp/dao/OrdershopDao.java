package fr.groupe2.tp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.groupe2.tp.model.Ordershop;

@Repository
public interface OrdershopDao extends CrudRepository<Ordershop, Integer>{
	
}
