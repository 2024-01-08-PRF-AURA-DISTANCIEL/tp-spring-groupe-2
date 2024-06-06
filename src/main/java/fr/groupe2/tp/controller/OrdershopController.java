package fr.groupe2.tp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.groupe2.tp.model.Ordershop;
import fr.groupe2.tp.service.OrdershopService;

@RestController
@RequestMapping("/ordersshop")
public class OrdershopController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrdershopService.class);

	@Autowired
	OrdershopService ordershopService;

	@PostMapping
	public Ordershop saveOrdershopService(@RequestBody Ordershop Ordershop) {
		LOGGER.info("Sauvegarde d'un user par le contrôleur");
		return ordershopService.saveOrdershop(Ordershop);
	}

	@GetMapping("/{id}")
	public Ordershop getUsershopById(@PathVariable("id") Integer id) {
		LOGGER.info("Récupération d'un user avec l'id : " + id);
		return ordershopService.getOrdershop(id);
	}

	@DeleteMapping("/{id}")
	public void deleteUsershopById(@PathVariable("id") Integer id) {
		LOGGER.info("Suppression de Bateau " + id);
		ordershopService.deleteOrdershopById(id);
	}

}
