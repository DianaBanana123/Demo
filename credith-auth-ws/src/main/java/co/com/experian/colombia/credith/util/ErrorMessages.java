package co.com.experian.colombia.credith.util;

public enum ErrorMessages {
	ERROR("Error: "),
	CREDIT_HISTORY_NOT_FOUND ("No se encontraron historias de crédito asociadas");


	private String errorMessage;

	ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;    
	}
	
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

}
