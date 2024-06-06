package fr.groupe2.tp.dao;

import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryDaoTest {
    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void testSave(){
        //Arrange

        Category category = new Category();
        category.setCategoryName("Boisson");
        //Act
        Category savedCategory = categoryDao.save(category);
        //Assert
        Assertions.assertNotNull(savedCategory);
        Assertions.assertNotNull(savedCategory.getId());
        Assertions.assertEquals("Boisson", savedCategory.getCategoryName());
    }

    @Test
    public void testGetByCategoryName() {
        //ARRANGE
        Category category = new Category();
        category.setCategoryName("Chaussures");

        Category savedCategory = categoryDao.save(category);
        //ACT
        List<Category> categories = categoryDao.getByCategoryName("Chaussures");
        //ASSERT
        Assertions.assertEquals(1, categories.size());
        Category loadedCategory = categories.get(0);
        Assertions.assertEquals("Chaussures", loadedCategory.getCategoryName());
    }


}
