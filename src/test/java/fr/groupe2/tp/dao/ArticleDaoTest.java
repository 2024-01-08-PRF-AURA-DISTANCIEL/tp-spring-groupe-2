package fr.groupe2.tp.dao;

import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void testSave(){
        //Arrange

        Article article = new Article();
        article.setName("RX-78");
        //Act
        Article savedArticle = articleDao.save(article);
        //Assert
        Assertions.assertNotNull(savedArticle);
        Assertions.assertNotNull(savedArticle.getId());
        Assertions.assertEquals("RX-78", savedArticle.getName());
    }

    @Test
    public void testGetArticleByNameIgnoreCase() {
        //ARRANGE
        Article article = new Article();
        article.setName("X-or");
//        article.setQuantity(3);
//        article.setPointfidelity(4);
//        article.setPrice(BigDecimal.valueOf(15));

         Article savedArticle = articleDao.save(article);
        //ACT
        List<Article> articles = articleDao.getArticleByNameIgnoreCase("x-or");
        //ASSERT
        Assertions.assertEquals(1, articles.size());
        Article loadedArticle = articles.get(0);
        Assertions.assertEquals("X-or", loadedArticle.getName());
    }

}
