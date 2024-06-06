package fr.groupe2.tp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usershop database table.
 * 
 */
@Entity
@NamedQuery(name="Usershop.findAll", query="SELECT u FROM Usershop u")
public class Usershop  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_User;

	private String email;

	private String firstname;

	private String lastname;

	private int pointfidelity;

	//bi-directional many-to-one association to Ordershop
	@OneToMany(mappedBy="usershop")
	private List<Ordershop> ordershops;

	public Usershop() {
	}

	public int getId_User() {
		return this.id_User;
	}

	public void setId_User(int id_User) {
		this.id_User = id_User;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getPointfidelity() {
		return this.pointfidelity;
	}

	public void setPointfidelity(int pointfidelity) {
		this.pointfidelity = pointfidelity;
	}

	public List<Ordershop> getOrdershops() {
		return this.ordershops;
	}

	public void setOrdershops(List<Ordershop> ordershops) {
		this.ordershops = ordershops;
	}

	public Ordershop addOrdershop(Ordershop ordershop) {
		getOrdershops().add(ordershop);
		ordershop.setUsershop(this);

		return ordershop;
	}

	public Ordershop removeOrdershop(Ordershop ordershop) {
		getOrdershops().remove(ordershop);
		ordershop.setUsershop(null);

		return ordershop;
	}

}