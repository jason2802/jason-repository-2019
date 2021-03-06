package com.example.aop.controller;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.aop.configuration.RestService;
import com.example.aop.model.User_ApiGitHub;

@RestController
@RequestMapping( value = "/api")
public class ApiGitHubController {

	RestTemplate restTemplate = new RestTemplate();
		
	private RestService restService;
	
	@Inject
	public ApiGitHubController( RestService restService) {
		this.restService = restService;
	}
	
	
	/*
	 * Downside : getForEntity dovendo recuperare tutti gli headers mette troppo tempo per rispondere.
	 * 				- Rimuoviamo gli HTTP-CONTENTLENGTH da quanto restituito dall'API
	 * 
	 */	
	@RequestMapping( value = "/github/{username}")
	ResponseEntity<User_ApiGitHub> getUser(@PathVariable String username) throws HttpClientErrorException {
		HttpHeaders responseHeaders = new HttpHeaders();
		
		ResponseEntity<User_ApiGitHub> user_ApiGitHub = restTemplate.getForEntity( restService.getGithubEndpoint() + "/{username}", User_ApiGitHub.class, username );
		
		user_ApiGitHub.getHeaders().entrySet()
								   .forEach( e -> { 
									   					if (!( e.getKey().equalsIgnoreCase( HttpHeaders.CONTENT_LENGTH ))) {
									   						responseHeaders.addAll( e.getKey(), e.getValue() );
									   					}									   				
								   					});	
		
		return new ResponseEntity<>(user_ApiGitHub.getBody(), responseHeaders , HttpStatus.OK );
				// return new ResponseEntity<>( user_ApiGitHub, headers, HttpStatus.OK );
	}
	
	
	
}
