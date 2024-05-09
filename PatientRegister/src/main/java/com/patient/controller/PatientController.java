package com.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patient.binding.ForgotpwdForm;
import com.patient.binding.LoginForm;
import com.patient.binding.ResetpwdForm;
import com.patient.entity.PatientEntity;
import com.patient.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	public PatientService patientService;

	@PostMapping("/patients")
	public ResponseEntity<PatientEntity> savePatient(@RequestBody PatientEntity patient) {
		PatientEntity savedPatient = patientService.savePatient(patient);
		if (savedPatient != null) {
			return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{pid}")
	public ResponseEntity<?> updatePatient(@PathVariable("pid") String pid, @RequestBody PatientEntity patient) {
	    patient.setPid(pid);
	   
	    PatientEntity updatedPatient = patientService.updatePatient(patient);
	    
	    if (updatedPatient != null) {
	        return ResponseEntity.ok(updatedPatient);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
    
	   @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginForm login) {
	        PatientEntity patient = patientService.login(login);
	        if (patient != null) {
	            return ResponseEntity.ok(patient);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	        }
	    }
	    
		@PostMapping("/forgotpwd")
		public ResponseEntity<Void> forgotPwd(@RequestBody ForgotpwdForm forgotPwd) {
			boolean isForgotPwd = patientService.forgotPwd(forgotPwd);
			if (isForgotPwd) {
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@PostMapping("/resetPwd")
		public ResponseEntity<?> resetPwd(@RequestBody ResetpwdForm resetPwd) {
			boolean isResetPwd = patientService.resetPwd(resetPwd);
			if (isResetPwd) {
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}
	   
}
