package fr.groupe2.tp.dao;

import java.math.BigDecimal;
import java.util.List;

import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {

//    @Query("select c from Company c where c.name = :companyNameParam")
//    public List<Company> getCompanyParNom(@Param("companyNameParam") String companyName);

//    @Query("select c from Company c where c.cash > 10000")
//    public List<Company> getCompaniesDontCashSuperieur10_000();


    public List<Category> getByCategoryName(String name);


}