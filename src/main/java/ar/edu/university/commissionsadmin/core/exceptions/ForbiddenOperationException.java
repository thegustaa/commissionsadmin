package ar.edu.university.commissionsadmin.core.exceptions;

/**
 * Operación inválida.
 * @author Gustavo
 *
 */
public class ForbiddenOperationException extends RuntimeException {
	public ForbiddenOperationException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
}
