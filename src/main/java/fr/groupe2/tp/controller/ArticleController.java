package fr.groupe2.tp.controller;

import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.service.ArticleService;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;


    @PostMapping
    public Article saveArticle(@RequestBody Article article) {
        LOGGER.info("Sauvegarde d'un article par le contrôleur");
        articleService.saveArticle(article);
        return article;
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable("id")Integer id) {
        LOGGER.info("Récupération d'un article avec l'id : " + id);
      return  articleService.getArticle(id);

    }


    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable("id")Integer id) {
        LOGGER.info("Suppression de Bateau " + id);
        articleService.deleteArticleById(id);
    }



}
