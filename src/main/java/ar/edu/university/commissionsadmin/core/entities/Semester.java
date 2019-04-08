package ar.edu.university.commissionsadmin.core.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * Clase de semestres.
 * 
 */
@Entity
@Table(name="semester")
@NamedQuery(name="Semester.findAll", query="SELECT s FROM Semester s")
public class Semester implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=1)
	private String id;

	@Column(nullable=false, length=15)
	private String name;

	//bi-directional many-to-one association to Commission
	@OneToMany(mappedBy="semester")
	@JsonIgnore
	private List<Commission> commissions;

	public Semester() {
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
		commission.setSemester(this);

		return commission;
	}

	public Commission removeCommission(Commission commission) {
		getCommissions().remove(commission);
		commission.setSemester(null);

		return commission;
	}

}