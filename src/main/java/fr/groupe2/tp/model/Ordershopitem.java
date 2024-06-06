package fr.groupe2.tp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

@Entity
@Table(name = "ordershopitem")
public class Ordershopitem {
    @Id
    @Column(name = "Id_OrderItem")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "numberarticles")
    private Integer numberarticles;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Article idArticle;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Order")
    private Ordershop idOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberarticles() {
        return numberarticles;
    }

    public void setNumberarticles(Integer numberarticles) {
        this.numberarticles = numberarticles;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public Ordershop getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Ordershop idOrder) {
        this.idOrder = idOrder;
    }

}