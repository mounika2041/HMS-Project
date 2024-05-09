package com.patient.binding;

public class ResetpwdForm {
	
	String otp;
	String newpwd;
	String confirmpwd;
	
	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	
	public ResetpwdForm(String otp, String newpwd, String confirmpwd) {
		super();
		this.otp = otp;
		this.newpwd = newpwd;
		this.confirmpwd = confirmpwd;
	}
	
	
	public ResetpwdForm() {
		super();
		// TODO Auto-generated constructor stub
	}

}
