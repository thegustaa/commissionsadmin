package ar.edu.university.commissionsadmin.core.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the professorship database table.
 * 
 */
@Entity
@Table(name="professorship")
@NamedQuery(name="Professorship.findAll", query="SELECT p FROM Professorship p")
public class Professorship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Commission
	@OneToMany(mappedBy="professorship")
	@JsonIgnore
	private List<Commission> commissions;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="id_subject", nullable=false)
	private Subject subject;

	public Professorship() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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
		commission.setProfessorship(this);

		return commission;
	}

	public Commission removeCommission(Commission commission) {
		getCommissions().remove(commission);
		commission.setProfessorship(null);

		return commission;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}