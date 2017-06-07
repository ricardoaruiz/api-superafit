package br.com.superafit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.service.FirebaseService;

@RestController
@RequestMapping("firebase")
public class FirebaseController {

	@Autowired
	private FirebaseService firebaseService;
	
	@RequestMapping(value="validate", method=RequestMethod.POST)
	public ResponseEntity<Void> validate() {		
		boolean validateFirebaseAccess = firebaseService.validateFirebaseAccess();		
		return validateFirebaseAccess ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
	}
	
}
