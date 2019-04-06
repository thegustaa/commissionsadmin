package ar.edu.university.commissionsadmin.core.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the studentsituation database table.
 * 
 */
@Entity
@Table(name="studentsituation")
@NamedQuery(name="Studentsituation.findAll", query="SELECT s FROM Studentsituation s")
public class Studentsituation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=1)
	private String id;

	@Column(nullable=false, length=15)
	private String name;

	//bi-directional many-to-one association to Commissionstudent
	@OneToMany(mappedBy="studentsituation")
	@JsonIgnore
	private List<Commissionstudent> commissionstudents;

	public Studentsituation() {
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

	public List<Commissionstudent> getCommissionstudents() {
		return this.commissionstudents;
	}

	public void setCommissionstudents(List<Commissionstudent> commissionstudents) {
		this.commissionstudents = commissionstudents;
	}

	public Commissionstudent addCommissionstudent(Commissionstudent commissionstudent) {
		getCommissionstudents().add(commissionstudent);
		commissionstudent.setStudentsituation(this);

		return commissionstudent;
	}

	public Commissionstudent removeCommissionstudent(Commissionstudent commissionstudent) {
		getCommissionstudents().remove(commissionstudent);
		commissionstudent.setStudentsituation(null);

		return commissionstudent;
	}

}