package wiki.link.hop.exception;

import org.springframework.http.HttpStatus;

public class WikiException extends RuntimeException {

	private HttpStatus code;

	public WikiException() {

	}

	public WikiException(String message) {
		super(message);
	}

	public WikiException(String message, HttpStatus code) {
		super(message);
		this.code = code;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}
}
