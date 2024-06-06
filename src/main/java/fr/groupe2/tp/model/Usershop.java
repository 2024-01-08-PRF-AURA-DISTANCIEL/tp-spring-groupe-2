package fr.groupe2.tp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usershop")
public class Usershop {
    @Id
    @Column(name = "Id_User", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstname;

    @Size(max = 100)

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastname;

    @Size(max = 255)

    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "pointfidelity", nullable = false)
    private Integer pointfidelity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPointfidelity() {
        return pointfidelity;
    }

    public void setPointfidelity(Integer pointfidelity) {
        this.pointfidelity = pointfidelity;
    }

}