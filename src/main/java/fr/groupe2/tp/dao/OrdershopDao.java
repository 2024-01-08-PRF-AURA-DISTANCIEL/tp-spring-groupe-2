package fr.groupe2.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.groupe2.tp.model.Ordershop;

@Repository
public interface OrderShopDao extends CrudRepository<Ordershop, Integer>{
	
	 public List<Ordershop> getByOrderStatus(String orderStatus);
	
}
