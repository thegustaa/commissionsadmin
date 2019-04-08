package ar.edu.university.commissionsadmin.core.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * Clase de estudiantes.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String firstname;

	@Column(nullable=false, length=45)
	private String lastname;

	//bi-directional many-to-one association to Commissionstudent
	@OneToMany(mappedBy="student")
	@JsonIgnore
	private List<Commissionstudent> commissionstudents;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Commissionstudent> getCommissionstudents() {
		return this.commissionstudents;
	}

	public void setCommissionstudents(List<Commissionstudent> commissionstudents) {
		this.commissionstudents = commissionstudents;
	}

	public Commissionstudent addCommissionstudent(Commissionstudent commissionstudent) {
		getCommissionstudents().add(commissionstudent);
		commissionstudent.setStudent(this);

		return commissionstudent;
	}

	public Commissionstudent removeCommissionstudent(Commissionstudent commissionstudent) {
		getCommissionstudents().remove(commissionstudent);
		commissionstudent.setStudent(null);

		return commissionstudent;
	}

}