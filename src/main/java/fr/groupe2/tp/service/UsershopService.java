package fr.groupe2.tp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import fr.groupe2.tp.dao.UsershopDao;
import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Usershop;

@Component
public class UsershopService {
	    
	 	@Autowired
	    private UsershopDao usershopDao;

//	 	1 id utilisteur getId classe userShopDao 
	// Si aucun utilisateur ne correspond à l'identifiant utilisateur, renvoyer une erreur.

//	 	1 id article getId classe articleDao
//	 	1 nombre d'articles getNumberArticles de la classe orderShopItem
//	 	Si aucun user n'existe alors erreur 400
	 	
	    public Usershop saveUsershop(Usershop usershop){
	        System.out.println("j'enregistre l'Id d'un achat d'un utilisateur");
	        return usershopDao.save(usershop);

	    }

	    public void deleteUsershopById(Integer id){
	        System.out.println("je supprime l'Id d'un achat d'un utilisateur");
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
