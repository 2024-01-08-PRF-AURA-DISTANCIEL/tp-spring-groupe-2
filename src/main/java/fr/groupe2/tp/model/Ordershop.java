package fr.groupe2.tp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.Nullable;

import java.time.Instant;

@Entity
@Table(name = "ordershop")
public class Ordershop {
    @Id
    @Column(name = "Id_Order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("'PANIER'")
    @Lob
    @Column(name = "Status")
    private String status;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_User")
    private Usershop idUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Usershop getIdUser() {
        return idUser;
    }

    public void setIdUser(Usershop idUser) {
        this.idUser = idUser;
    }

}