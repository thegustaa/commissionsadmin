package ar.edu.university.commissionsadmin.core.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * Clase de turnos.
 * 
 */
@Entity
@Table(name="timeshift")
@NamedQuery(name="Timeshift.findAll", query="SELECT t FROM Timeshift t")
public class Timeshift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=1)
	private String id;

	@Column(nullable=false, length=15)
	private String name;

	//bi-directional many-to-one association to Commission
	@OneToMany(mappedBy="timeshift")
	@JsonIgnore
	private List<Commission> commissions;

	public Timeshift() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Commission> getCommissions() {
		return this.commissions;
	}

	public void setCommissions(List<Commission> commissions) {
		this.commissions = commissions;
	}

	public Commission addCommission(Commission commission) {
		getCommissions().add(commission);
		commission.setTimeshift(this);

		return commission;
	}

	public Commission removeCommission(Commission commission) {
		getCommissions().remove(commission);
		commission.setTimeshift(null);

		return commission;
	}

}