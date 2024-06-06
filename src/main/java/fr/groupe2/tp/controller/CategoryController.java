package fr.groupe2.tp.controller;

import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Category;
import fr.groupe2.tp.service.ArticleService;
import fr.groupe2.tp.service.CategoryService;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public Category save(@RequestBody Category category) {
        LOGGER.info("Sauvegarde d'un article par le contrôleur");
        return categoryService.saveCategory(category);

    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id")Integer id) {
        LOGGER.info("Récupération d'un article avec l'id : " + id);
        return  categoryService.getCategory(id);

    }


    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id")Integer id) {
        LOGGER.info("Suppression de Bateau " + id);
        categoryService.deleteCategoryById(id);
    }



}
