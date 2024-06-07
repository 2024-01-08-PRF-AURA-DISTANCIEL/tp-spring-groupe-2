package fr.groupe2.tp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import fr.groupe2.tp.dao.OrdershopDao;
import fr.groupe2.tp.dao.UsershopDao;
import fr.groupe2.tp.model.Usershop;

@Component
public class UsershopService {
	    
	 	@Autowired
	    private UsershopDao usershopDao;

		@Autowired
		private OrdershopDao ordershopDao;

	    public Usershop saveUsershop(Usershop usershop){
	        System.out.println("j'enregistre l'Id d'un achat d'un utilisateur");
	        return usershopDao.save(usershop);

	    }

	    public void deleteUsershopById(Integer id){
	        System.out.println("je supprime l'Id d'un achat d'un utilisateur");
			// Optional<Ordershop> ordershopOptional = ordershopDao.findById(id);
			// if (ordershopOptional.isEmpty()) {
			// }
			usershopDao.deleteById(id);

	    }


	    public Usershop getUsershop(Integer id) {
	        Optional<Usershop> usershopOptional = usershopDao.findById(id);
	        if (usershopOptional.isEmpty()) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No achat d'un utilisateur found");
	        }else{
	            return usershopOptional.get();
	        }
	    }

    
}
