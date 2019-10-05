package co.com.experian.colombia.credith.service.impl;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.com.experian.colombia.credith.exception.AuthHCException;
import co.com.experian.colombia.credith.model.RequestCreditHistory;
import co.com.experian.colombia.credith.service.IAuthHC;
import co.com.experian.colombia.credith.util.ErrorMessages;



@Service
public class AuthHCImpl implements IAuthHC{

	public static final Logger logger = LoggerFactory.getLogger(AuthHCImpl.class);


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<Object> getCreditHistory(RequestCreditHistory request) throws AuthHCException {
		JSONObject creditHistory = null;
		try {
			File file = new File(AuthHCImpl.class.getResource("/creditInfo.json").getFile());		
			FileReader reader = new FileReader(file);

			//Read JSON file
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(reader); 

			JSONArray creditStories = (JSONArray) obj;
			if(creditStories != null && !creditStories.isEmpty()) {
				for (Object diagnostic : creditStories) {
					JSONObject diagnosticInfo = (JSONObject) diagnostic;	            
					JSONObject requestHc = (JSONObject) diagnosticInfo.get("request");
					if(requestHc.get("documentType").toString().equalsIgnoreCase(request.getDocumentType())
							&& requestHc.get("document").toString().equalsIgnoreCase(request.getDocument())
							&& requestHc.get("lastName").toString().equalsIgnoreCase(request.getLastName())) {	
						diagnosticInfo.remove("request");
						creditHistory = diagnosticInfo;
						break;
					}
				}
			}else {
				throw new AuthHCException(ErrorMessages.CREDIT_HISTORY_NOT_FOUND.getErrorMessage());
			}

			
			if(creditHistory != null) {
				return new ResponseEntity(creditHistory, HttpStatus.OK);
			}else {
				throw new AuthHCException(ErrorMessages.CREDIT_HISTORY_NOT_FOUND.getErrorMessage());
			}

		}catch (Exception e) {
			logger.error(ErrorMessages.ERROR.getErrorMessage(), e);
			throw new AuthHCException(e);
		}
		
	}

}
