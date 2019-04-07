package ar.edu.university.commissionsadmin.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the commissionstudent database table.
 * 
 */
@Entity
@Table(name="commissionstudent")
@NamedQuery(name="Commissionstudent.findAll", query="SELECT c FROM Commissionstudent c")
public class Commissionstudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	private Float finalscore;

	//bi-directional many-to-one association to Commission
	@ManyToOne
	@JoinColumn(name="id_commission", nullable=false)
	private Commission commission;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="id_student", nullable=false)
	private Student student;

	//bi-directional many-to-one association to Studentsituation
	@ManyToOne
	@JoinColumn(name="id_studentsituation", nullable=false)
	private Studentsituation studentsituation;

	public Commissionstudent() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getFinalscore() {
		return this.finalscore;
	}

	public void setFinalscore(Float finalscore) {
		this.finalscore = finalscore;
	}

	public Commission getCommission() {
		return this.commission;
	}

	public void setCommission(Commission commission) {
		this.commission = commission;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Studentsituation getStudentsituation() {
		return this.studentsituation;
	}

	public void setStudentsituation(Studentsituation studentsituation) {
		this.studentsituation = studentsituation;
	}

}