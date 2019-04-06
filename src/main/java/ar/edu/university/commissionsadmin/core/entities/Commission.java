package ar.edu.university.commissionsadmin.core.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the commission database table.
 * 
 */
@Entity
@Table(name="commission")
@NamedQuery(name="Commission.findAll", query="SELECT c FROM Commission c")
public class Commission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String year;

	//bi-directional many-to-one association to Professorship
	@ManyToOne
	@JoinColumn(name="id_professorship", nullable=false)
	private Professorship professorship;

	//bi-directional many-to-one association to Semester
	@ManyToOne
	@JoinColumn(name="id_semester", nullable=false)
	private Semester semester;

	//bi-directional many-to-one association to Timeshift
	@ManyToOne
	@JoinColumn(name="id_timeshift", nullable=false)
	private Timeshift timeshift;

	//bi-directional many-to-one association to Commissionstudent
	@OneToMany(mappedBy="commission")
	@JsonIgnore
	private List<Commissionstudent> commissionstudents;

	public Commission() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Professorship getProfessorship() {
		return this.professorship;
	}

	public void setProfessorship(Professorship professorship) {
		this.professorship = professorship;
	}

	public Semester getSemester() {
		return this.semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Timeshift getTimeshift() {
		return this.timeshift;
	}

	public void setTimeshift(Timeshift timeshift) {
		this.timeshift = timeshift;
	}

	public List<Commissionstudent> getCommissionstudents() {
		return this.commissionstudents;
	}

	public void setCommissionstudents(List<Commissionstudent> commissionstudents) {
		this.commissionstudents = commissionstudents;
	}

	public Commissionstudent addCommissionstudent(Commissionstudent commissionstudent) {
		getCommissionstudents().add(commissionstudent);
		commissionstudent.setCommission(this);

		return commissionstudent;
	}

	public Commissionstudent removeCommissionstudent(Commissionstudent commissionstudent) {
		getCommissionstudents().remove(commissionstudent);
		commissionstudent.setCommission(null);

		return commissionstudent;
	}

}