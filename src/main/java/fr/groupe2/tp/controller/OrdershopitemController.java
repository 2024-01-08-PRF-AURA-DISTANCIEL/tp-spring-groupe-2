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

import fr.groupe2.tp.service.OrdershopitemService;

@RestController
@RequestMapping("/ordershopitem")
public class OrdershopitemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrdershopitemController.class);
	@Autowired
	OrdershopitemService ordershopitemService;

	@PostMapping
	public OrdershopitemService saveOrdershopService(@RequestBody OrdershopitemService ordershopitemService) {
		LOGGER.info("Sauvegarde d'un user par le contrôleur");
		ordershopitemService.saveOrdershopitem(ordershopitemService);
		return ordershopitemService;
	}

	@GetMapping("/{id}")
	public ordershopitemService getUsershopById(@PathVariable("id") Integer id) {
		LOGGER.info("Récupération d'un user avec l'id : " + id);
		return ordershopitemService.getOrdershopitem(id);
	}

	@DeleteMapping("/{id}")
	public void deleteUsershopById(@PathVariable("id") Integer id) {
		LOGGER.info("Suppression de Bateau " + id);
		ordershopitemService.deleteOrdershopitem(id);
	}

}
