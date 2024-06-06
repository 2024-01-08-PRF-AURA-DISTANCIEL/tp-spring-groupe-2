package fr.groupe2.tp.dao;

import org.springframework.data.repository.CrudRepository;

import fr.groupe2.tp.model.Ordershopitem;

public interface  OrdershopitemDao  extends CrudRepository<Ordershopitem, Integer> { 
	
	
}
