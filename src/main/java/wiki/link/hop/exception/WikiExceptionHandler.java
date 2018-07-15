package wiki.link.hop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WikiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAll(Exception ex) {
		return handleExceptionInternal(ex, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(WikiException.class)
	public ResponseEntity<Object> handleWikiException(WikiException ex) {
		return handleExceptionInternal(ex, ex.getLocalizedMessage(),
				ex.getCode() == null ? HttpStatus.BAD_REQUEST : ex.getCode());
	}

	private ResponseEntity<Object> handleExceptionInternal(Exception ex, String message, HttpStatus status) {

		ApiError apiError = new ApiError(status, message, ex);
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
