package fr.groupe2.tp.service;

import fr.groupe2.tp.dao.ArticleDao;
import fr.groupe2.tp.dao.CategoryDao;
import fr.groupe2.tp.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;



    public Article saveArticle(Article article){
        System.out.println("j'enregistre l'Id d'un article");
        return articleDao.save(article);

    }

    public void deleteArticleById(Integer id){
        System.out.println("je supprime l'Id d'un article");
        articleDao.deleteById(id);
    }


    public Article getArticle(Integer id) {
        Optional<Article> articleOptional = articleDao.findById(id);
        if (articleOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No article found");
        }else{
            return articleOptional.get();
        }
    }
}
