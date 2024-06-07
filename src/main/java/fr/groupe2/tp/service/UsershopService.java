package fr.groupe2.tp.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import fr.groupe2.tp.dao.ArticleDao;
import fr.groupe2.tp.dao.OrdershopDao;
import fr.groupe2.tp.dao.OrdershopitemDao;
import fr.groupe2.tp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import fr.groupe2.tp.dao.UsershopDao;

@Component
public class UsershopService {
	    
	 	@Autowired
	    private UsershopDao usershopDao;

		 @Autowired
		 private ArticleDao articleDao;

		 @Autowired
		 private OrdershopDao ordershopDao;

		 @Autowired
		 private OrdershopitemDao ordershopitemDao;

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

       //un identifiant utilisateur
	   //un identifant d'article
	  //un nombre d'articles
		public void addUsershop(Usershop user, Article article, Integer numberarticles){


			Optional<Usershop> usershopOptional = usershopDao.findById(user.getId());
			if (usershopOptional.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No usershop found");
			}

			Optional<Article> article1 = articleDao.findById(article.getId());
			if (article1.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No article found");
			}

			Optional<Ordershop> ordershopOptional = ordershopDao.findByIdUserAndStatus(user, Status.PANIER);
			if (ordershopOptional.isEmpty()) {
				Ordershop newOrdershop = new Ordershop();
				newOrdershop.setIdUser(user);
				newOrdershop.setStatus(Status.PANIER);
				newOrdershop.setCreatedAt(Instant.now());
				ordershopDao.save(newOrdershop);
			}


			List<Ordershopitem> ordershopitems = ordershopitemDao.findByIdOrder(ordershopOptional.get().getId());

			for (Ordershopitem ordershopitem : ordershopitems) {
				if (ordershopitem.getId().equals(ordershopOptional.get().getId())) {
					numberarticles++;
				}
			}
			Ordershopitem newOrdershopitem = new Ordershopitem();
			newOrdershopitem.setIdOrder(ordershopOptional.get());
			newOrdershopitem.setIdArticle(article);
			newOrdershopitem.setNumberarticles(numberarticles);
			ordershopitemDao.save(newOrdershopitem);
		}



}
