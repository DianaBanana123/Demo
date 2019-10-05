package co.com.experian.colombia.credith.exception;

public class AuthHCException extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2272662390581596636L;
	
	public AuthHCException(String message) {
		super(message);
	}
	
	public AuthHCException(Throwable code) {
		super(code);
	}

}
