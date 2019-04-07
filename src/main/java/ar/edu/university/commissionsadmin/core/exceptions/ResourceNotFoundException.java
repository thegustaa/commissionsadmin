package ar.edu.university.commissionsadmin.core.exceptions;

/**
 * Entidad no encontrada.
 * @author Gustavo
 *
 */
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
		super(message);
	}


	private static final long serialVersionUID = 1L;

}
