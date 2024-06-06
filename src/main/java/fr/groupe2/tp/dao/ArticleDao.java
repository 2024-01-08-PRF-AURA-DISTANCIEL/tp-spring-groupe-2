package fr.groupe2.tp.dao;

import java.math.BigDecimal;
import java.util.List;

import fr.groupe2.tp.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ArticleDao extends CrudRepository<Article, Integer> {


    public List<Article> getArticleByNameIgnoreCase(String name);

    public List<Article> getArticleByNameAndPrice(String name, BigDecimal price);

}