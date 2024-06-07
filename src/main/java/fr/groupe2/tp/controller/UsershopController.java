package fr.groupe2.tp.controller;

import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.groupe2.tp.model.Usershop;
import fr.groupe2.tp.service.UsershopService;

@RestController
@RequestMapping("/users")
public class UsershopController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsershopController.class);

	@Autowired
	private UsershopService usershopService;
    @Autowired
    private ArticleService articleService;

	@PostMapping
	public Usershop saveUsershop(@RequestBody Usershop usershop) {
		LOGGER.info("Sauvegarde d'un user par le contrôleur");
		return usershopService.saveUsershop(usershop);
	}

	@GetMapping("/{id}")
	public Usershop getUsershopById(@PathVariable("id") Integer id) {
		LOGGER.info("Récupération d'un user avec l'id : " + id);
		return usershopService.getUsershop(id);
	}

	@DeleteMapping("/{id}")
	public void deleteUsershopById(@PathVariable("id") Integer id) {
		LOGGER.info("Suppression d'un user " + id);
		usershopService.deleteUsershopById(id);
	}

	@GetMapping("/{iduser}/{idarticle}/{number}")
	public void addProductUsershop(@PathVariable("iduser") Integer iduser, @PathVariable("idarticle") Integer idarticle, @PathVariable("number") Integer numberarticles ) {
		//LOGGER.info("Suppression d'un user " + user);
		Article article = articleService.getArticle(idarticle);

		Usershop usershop = usershopService.getUsershop(iduser);
		usershopService.addUsershop(usershop, article, numberarticles);
		
	}

}
