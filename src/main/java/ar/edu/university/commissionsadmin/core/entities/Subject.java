package ar.edu.university.commissionsadmin.core.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * Clase de materias.
 * 
 */
@Entity
@Table(name="subject")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Professorship
	@OneToMany(mappedBy="subject")
	@JsonIgnore
	private List<Professorship> professorships;

	//bi-directional many-to-one association to Career
	@ManyToOne
	@JoinColumn(name="id_career", nullable=false)
	private Career career;

	public Subject() {
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

	public List<Professorship> getProfessorships() {
		return this.professorships;
	}

	public void setProfessorships(List<Professorship> professorships) {
		this.professorships = professorships;
	}

	public Professorship addProfessorship(Professorship professorship) {
		getProfessorships().add(professorship);
		professorship.setSubject(this);

		return professorship;
	}

	public Professorship removeProfessorship(Professorship professorship) {
		getProfessorships().remove(professorship);
		professorship.setSubject(null);

		return professorship;
	}

	public Career getCareer() {
		return this.career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

}