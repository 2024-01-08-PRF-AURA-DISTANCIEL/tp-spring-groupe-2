package fr.groupe2.tp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @Column(name = "Id_Article")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;


    @Column(name = "quantity")
    private Integer quantity;


    @Column(name = "pointfidelity")
    private Integer pointfidelity;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Category")
    private Category idCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Integer getPointfidelity() {
        return pointfidelity;
    }

    public void setPointfidelity(Integer pointfidelity) {
        this.pointfidelity = pointfidelity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Category getIdCategory() {
        return idCategory;
    }


    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

}
