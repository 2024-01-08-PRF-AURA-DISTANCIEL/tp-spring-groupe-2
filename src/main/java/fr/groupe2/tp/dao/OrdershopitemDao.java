package fr.groupe2.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.groupe2.tp.model.Ordershopitem;
import org.springframework.stereotype.Repository;

@Repository
public interface  OrdershopitemDao  extends CrudRepository<Ordershopitem, Integer> { 
	
	public List<Ordershopitem> getByArticleId(Integer Id_article);
	
	public List<Ordershopitem> getByOrderId(Integer orderId);
	
	public List<Ordershopitem> getByUserId(Integer userId);
	
	
    
	
	
}
