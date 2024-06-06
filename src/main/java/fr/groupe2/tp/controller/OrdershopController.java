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

import fr.groupe2.tp.model.Usershop;
import fr.groupe2.tp.service.OrdershopService;

@RestController
@RequestMapping("/ordersshop")
public class OrdershopController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrdershopService.class);

	@Autowired
	OrdershopService ordershopService;

	@PostMapping
	public OrdershopService saveOrdershopService(@RequestBody OrdershopService ordershopService) {
		LOGGER.info("Sauvegarde d'un user par le contrôleur");
		ordershopService.saveOrdershop(ordershopService);
		return ordershopService;
	}

	@GetMapping("/{id}")
	public Usershop getUsershopById(@PathVariable("id") Integer id) {
		LOGGER.info("Récupération d'un user avec l'id : " + id);
		return userOrdershop.getOrdershopService(id);
	}

	@DeleteMapping("/{id}")
	public void deleteUsershopById(@PathVariable("id") Integer id) {
		LOGGER.info("Suppression de Bateau " + id);
		OrdershopService.deleteOrdershopById(id);
	}

}
