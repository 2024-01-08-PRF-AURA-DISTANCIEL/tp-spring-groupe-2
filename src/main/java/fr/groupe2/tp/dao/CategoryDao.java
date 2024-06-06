package fr.groupe2.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.groupe2.tp.model.Category;



@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {

//    @Query("select a from Article a where a.name = :ArticleNameParam")
//    public List<Company> getCompanyParNom(@Param("companyNameParam") String companyName);

//    @Query("select c from Company c where c.cash > 10000")
//    public List<Company> getCompaniesDontCashSuperieur10_000();


    public List<Category> getByCategoryName(String name);
    
   

  



}