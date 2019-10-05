package co.com.experian.colombia.credith.service;

import org.springframework.http.ResponseEntity;

import co.com.experian.colombia.credith.exception.AuthHCException;
import co.com.experian.colombia.credith.model.RequestCreditHistory;




public interface IAuthHC {

	public ResponseEntity<Object> getCreditHistory(RequestCreditHistory requestCreditHistory) throws AuthHCException;
}
