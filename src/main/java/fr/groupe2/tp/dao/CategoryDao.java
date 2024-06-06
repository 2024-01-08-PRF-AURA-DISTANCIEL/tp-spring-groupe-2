package fr.groupe2.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.groupe2.tp.model.Category;



@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {




    public List<Category> getByCategoryName(String name);
    
   

  



}