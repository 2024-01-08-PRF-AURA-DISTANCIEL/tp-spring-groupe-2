package fr.groupe2.tp.dao;

import java.util.List;
import java.util.Optional;

import fr.groupe2.tp.model.Status;
import fr.groupe2.tp.model.Usershop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.groupe2.tp.model.Ordershop;

@Repository
public interface OrdershopDao extends CrudRepository<Ordershop, Integer>{
	
	 //public List<Ordershop> getByStatus(String orderStatus);

    Optional<Ordershop> findByIdUserAndStatus(Usershop idUser, Status status);
}
