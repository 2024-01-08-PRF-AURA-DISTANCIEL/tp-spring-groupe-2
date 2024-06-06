package fr.groupe2.tp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ordershopitem database table.
 * 
 */
@Entity
@NamedQuery(name="Ordershopitem.findAll", query="SELECT o FROM Ordershopitem o")
public class Ordershopitem  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_OrderItem;

	private int numberarticles;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="Id_Article")
	private Article article;

	//bi-directional many-to-one association to Ordershop
	@ManyToOne
	@JoinColumn(name="Id_Order")
	private Ordershop ordershop;

	public Ordershopitem() {
	}

	public int getId_OrderItem() {
		return this.id_OrderItem;
	}

	public void setId_OrderItem(int id_OrderItem) {
		this.id_OrderItem = id_OrderItem;
	}

	public int getNumberarticles() {
		return this.numberarticles;
	}

	public void setNumberarticles(int numberarticles) {
		this.numberarticles = numberarticles;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Ordershop getOrdershop() {
		return this.ordershop;
	}

	public void setOrdershop(Ordershop ordershop) {
		this.ordershop = ordershop;
	}

}