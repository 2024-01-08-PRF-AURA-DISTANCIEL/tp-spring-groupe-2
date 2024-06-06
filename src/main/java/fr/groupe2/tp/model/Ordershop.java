package fr.groupe2.tp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordershop database table.
 * 
 */
@Entity
@NamedQuery(name="Ordershop.findAll", query="SELECT o FROM Ordershop o")
public class Ordershop  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Order;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String status;

	//bi-directional many-to-one association to Usershop
	@ManyToOne
	@JoinColumn(name="Id_User")
	private Usershop usershop;

	//bi-directional many-to-one association to Ordershopitem
	@OneToMany(mappedBy="ordershop")
	private List<Ordershopitem> ordershopitems;

	public Ordershop() {
	}

	public int getId_Order() {
		return this.id_Order;
	}

	public void setId_Order(int id_Order) {
		this.id_Order = id_Order;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usershop getUsershop() {
		return this.usershop;
	}

	public void setUsershop(Usershop usershop) {
		this.usershop = usershop;
	}

	public List<Ordershopitem> getOrdershopitems() {
		return this.ordershopitems;
	}

	public void setOrdershopitems(List<Ordershopitem> ordershopitems) {
		this.ordershopitems = ordershopitems;
	}

	public Ordershopitem addOrdershopitem(Ordershopitem ordershopitem) {
		getOrdershopitems().add(ordershopitem);
		ordershopitem.setOrdershop(this);

		return ordershopitem;
	}

	public Ordershopitem removeOrdershopitem(Ordershopitem ordershopitem) {
		getOrdershopitems().remove(ordershopitem);
		ordershopitem.setOrdershop(null);

		return ordershopitem;
	}

}