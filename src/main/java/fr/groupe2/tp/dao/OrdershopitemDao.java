package fr.groupe2.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Ordershop;
import fr.groupe2.tp.model.Ordershopitem;

public interface  OrdershopitemDao  extends CrudRepository<Ordershopitem, Integer> { 
	
	public List<Ordershopitem> getByIdArticle(Article Id_article);
	
	public List<Ordershopitem> getByIdOrder(Ordershop orderId);
}
