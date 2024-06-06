package fr.groupe2.tp.dao;

import fr.groupe2.tp.model.Article;
import fr.groupe2.tp.model.Usershop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class UsershopDaoTest {

    @Autowired
    private UsershopDao usershopDao;

   /*@Test
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
    }*/

    @Test
    public void testGetUsershopByEmail() {
        //ARRANGE
        Usershop usershop = new Usershop();
        usershop.setEmail("olivsaksebnas@gmail.com");
        Usershop savedUsershop = usershopDao.save(usershop);
        //ACT
        Usershop usershopByEmail = usershopDao.getUsershopByEmail("olivsaksebnas@gmail.com");
        //ASSERT
        Assertions.assertNotNull(usershopByEmail);
        Assertions.assertEquals("olivsaksebnas@gmail.com", usershopByEmail.getEmail());
    }

}
