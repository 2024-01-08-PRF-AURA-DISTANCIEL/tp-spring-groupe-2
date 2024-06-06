package fr.groupe2.tp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import fr.groupe2.tp.dao.OrdershopitemDao;
import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Ordershopitem;

@Component
public class OrdershopitemService {
	  	
		@Autowired
	    private OrdershopitemDao ordershopitemDao;

	    public Ordershopitem saveOrdershopitem(Ordershopitem ordershopitem){
	        System.out.println("j'enregistre l'Id d'un commande");
	        return ordershopitemDao.save(ordershopitem);

	    }

	    public void deleteOrdershopitemById(Integer id){
	        System.out.println("je supprime l'Id d'un commande");
	        ordershopitemDao.deleteById(id);
	    }

	    public Ordershopitem getOrdershopitem(Integer id) {
	        Optional<Ordershopitem> ordershopitemOptional = ordershopitemDao.findById(id);
	        if (ordershopitemOptional.isEmpty()) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No commande found");
	        }else{
	            return ordershopitemOptional.get();
	        }
	    }
}
