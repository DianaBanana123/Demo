package co.com.experian.colombia.credith.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestCreditHistory implements Serializable{
	
	/**
	 * Id de serializacion
	 */
	private static final long serialVersionUID = 7858904948088013129L;

	@NotNull
	@NotBlank
	@JsonProperty("documentType")
	private String documentType;
	
	@NotNull
	@NotBlank
	@JsonProperty("document")
	private String document;
	
	@NotNull
	@NotBlank
	@JsonProperty("lastName")
	private String lastName;

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
