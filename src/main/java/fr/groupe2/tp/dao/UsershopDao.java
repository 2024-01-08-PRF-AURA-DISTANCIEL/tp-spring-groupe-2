package fr.groupe2.tp.dao;

import fr.groupe2.tp.model.Article;
import org.springframework.data.repository.CrudRepository;

import fr.groupe2.tp.model.Usershop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsershopDao extends CrudRepository<Usershop, Integer> {


    public Usershop getUsershopByEmail(String email);

}
