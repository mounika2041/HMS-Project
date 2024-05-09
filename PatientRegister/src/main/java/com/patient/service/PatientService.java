package com.patient.service;

import com.patient.binding.ForgotpwdForm;
import com.patient.binding.LoginForm;
import com.patient.binding.ResetpwdForm;
import com.patient.entity.PatientEntity;

public interface PatientService {
	
	public PatientEntity savePatient(PatientEntity patient);
	
	public PatientEntity updatePatient(PatientEntity patient); 
	
	
	public PatientEntity login(LoginForm login);

	public boolean forgotPwd(ForgotpwdForm forgotPwd);

	public boolean resetPwd(ResetpwdForm resetPwd);

	public String generateUniqueId();

}
