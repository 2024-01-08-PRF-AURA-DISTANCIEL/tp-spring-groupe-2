package fr.groupe2.tp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Category;

	private String categoryName;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="category")
	private List<Article> articles;

	public Category() {
	}

	public int getId_Category() {
		return this.id_Category;
	}

	public void setId_Category(int id_Category) {
		this.id_Category = id_Category;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setCategory(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setCategory(null);

		return article;
	}

}