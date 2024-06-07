package fr.groupe2.tp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Ordershop;
import fr.groupe2.tp.model.Ordershopitem;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  OrdershopitemDao  extends CrudRepository<Ordershopitem, Integer> { 
	
	public List<Ordershopitem> getByIdArticle(Article Id_article);
	
	public List<Ordershopitem> getByIdOrder(Ordershop orderId);

	@Query("SELECT ord FROM Ordershopitem ord"
			+ " INNER JOIN ord.idOrder ordershop "
	        + " WHERE ordershop.id = :ordershopid ")
	 List<Ordershopitem> findByIdOrder(@Param("ordershopid") Integer idOrder);
}
