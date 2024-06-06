package fr.groupe2.tp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article  {
	private static final long serialVersionUID = 1L;
	private int id_Article;
	private String name;
	private int pointfidelity;
	private BigDecimal price;
	private int quantity;
	private Category category;
	private List<Ordershopitem> ordershopitems;

	public Article() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId_Article() {
		return this.id_Article;
	}

	public void setId_Article(int id_Article) {
		this.id_Article = id_Article;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getPointfidelity() {
		return this.pointfidelity;
	}

	public void setPointfidelity(int pointfidelity) {
		this.pointfidelity = pointfidelity;
	}


	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="Id_Category")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	//bi-directional many-to-one association to Ordershopitem
	@OneToMany(mappedBy="article")
	public List<Ordershopitem> getOrdershopitems() {
		return this.ordershopitems;
	}

	public void setOrdershopitems(List<Ordershopitem> ordershopitems) {
		this.ordershopitems = ordershopitems;
	}

	public Ordershopitem addOrdershopitem(Ordershopitem ordershopitem) {
		getOrdershopitems().add(ordershopitem);
		ordershopitem.setArticle(this);

		return ordershopitem;
	}

	public Ordershopitem removeOrdershopitem(Ordershopitem ordershopitem) {
		getOrdershopitems().remove(ordershopitem);
		ordershopitem.setArticle(null);

		return ordershopitem;
	}

}