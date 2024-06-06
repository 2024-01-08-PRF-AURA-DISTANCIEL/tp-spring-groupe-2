package fr.groupe2.tp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import fr.groupe2.tp.dao.OrdershopDao;
import fr.groupe2.tp.model.Ordershop;


@Component
public class OrdershopService {
	@Autowired
    private OrdershopDao ordershopDao;

    public Ordershop saveOrdershop(Ordershop ordershop){
        System.out.println("j'enregistre l'Id d'un panier");
        return ordershopDao.save(ordershop);
    }

    public void deleteOrdershopById(Integer id){
        System.out.println("je supprime l'Id d'un panier");
        ordershopDao.deleteById(id);
    }

    public Ordershop getOrdershop(Integer id) {
        Optional<Ordershop> ordershopOptional = ordershopDao.findById(id);
        if (ordershopOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No panier found");
        }else{
            return ordershopOptional.get();
        }
    }
}

