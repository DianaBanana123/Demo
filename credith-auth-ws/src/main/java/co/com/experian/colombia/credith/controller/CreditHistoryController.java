package co.com.experian.colombia.credith.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.experian.colombia.credith.exception.AuthHCException;
import co.com.experian.colombia.credith.model.RequestCreditHistory;
import co.com.experian.colombia.credith.service.IAuthHC;

@EnableResourceServer
@RestController
public class CreditHistoryController extends ResourceServerConfigurerAdapter{

	@Autowired
	IAuthHC authHistory;
	
	@RequestMapping("/creditinfo")
	public ResponseEntity<Object> getCreditHistory(@RequestBody @Valid RequestCreditHistory requestCreditHistory) throws AuthHCException{
		return authHistory.getCreditHistory(requestCreditHistory);		
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/publica").permitAll();			
		http.requestMatchers().antMatchers("/creditinfo")
		.and().authorizeRequests()
		.antMatchers("/creditinfo").access("hasRole('USER')");
	}   

}

