package it.eng.petarrelic.vezba.exception;

import org.springframework.http.HttpStatus;

/**
 * Use this exception to send message to the world
 */
public class StudentServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private HttpStatus httpStatus;

	
	public StudentServiceException() {
		super();
	}
	
	public StudentServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public StudentServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentServiceException(String message) {
        super(message);
    }

    public StudentServiceException(Throwable cause) {
        super(cause);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
