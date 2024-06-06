

package fr.groupe2.tp.service;

import fr.groupe2.tp.dao.ArticleDao;
import fr.groupe2.tp.dao.CategoryDao;
import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;




    public Category saveCategory(Category category){
        System.out.println("j'enregistre l'Id d'une catégorie");
        return category;
    }

    public void deleteCategoryById(Integer id){
        System.out.println("je supprime l'Id d'un catégorie");
        categoryDao.deleteById(id);
    }


    public Category getCategory(Integer id) {
        Optional<Category> categoryOptional = categoryDao.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No category found");
        }else{
            return categoryOptional.get();
        }
    }


}
