package ar.edu.university.commissionsadmin.rest.requests;

/**
 * Petición de modificación de nota final del estudiante.
 * @author Gustavo
 *
 */
public class EditStudentCommissionScoreRequest {
	Float finalscore;

	public Float getFinalscore() {
		return finalscore;
	}

	public void setFinalscore(Float finalscore) {
		this.finalscore = finalscore;
	}
}
