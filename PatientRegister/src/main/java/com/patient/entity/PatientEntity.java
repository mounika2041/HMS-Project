package com.patient.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class PatientEntity {

	@Id
	@Column(name = "pid")
	private String pid;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String otp;
	private String mobile;
	private Integer age;
	private String gender;
	private String relationship;
	private String bloodGroup;
	private String familyDoctor;
	private String address;
	private boolean disclaimer;
	private String role;
	private String pwd;
	private String confirmPwd;
	
	private String aadhar;
	private String chronicdiseases;
	private String refferedby;
	private String serviceopt;
	private boolean insurance;
	
	private String emergencycontactperson;
	private Long emergencymobile;
	private String emergencyaddress;
	
	public PatientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientEntity(String pid, String firstName, String lastName, String email, String otp, String mobile,
			Integer age, String gender, String relationship, String bloodGroup, String familyDoctor, String address,
			boolean disclaimer, String role, String pwd, String confirmPwd, String aadhar, String chronicdiseases,
			String refferedby, String serviceopt, boolean insurance, String emergencycontactperson,
			Long emergencymobile, String emergencyaddress) {
		super();
		this.pid = pid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.otp = otp;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		this.relationship = relationship;
		this.bloodGroup = bloodGroup;
		this.familyDoctor = familyDoctor;
		this.address = address;
		this.disclaimer = disclaimer;
		this.role = role;
		this.pwd = pwd;
		this.confirmPwd = confirmPwd;
		this.aadhar = aadhar;
		this.chronicdiseases = chronicdiseases;
		this.refferedby = refferedby;
		this.serviceopt = serviceopt;
		this.insurance = insurance;
		this.emergencycontactperson = emergencycontactperson;
		this.emergencymobile = emergencymobile;
		this.emergencyaddress = emergencyaddress;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getFamilyDoctor() {
		return familyDoctor;
	}

	public void setFamilyDoctor(String familyDoctor) {
		this.familyDoctor = familyDoctor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(boolean disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getChronicdiseases() {
		return chronicdiseases;
	}

	public void setChronicdiseases(String chronicdiseases) {
		this.chronicdiseases = chronicdiseases;
	}

	public String getRefferedby() {
		return refferedby;
	}

	public void setRefferedby(String refferedby) {
		this.refferedby = refferedby;
	}

	public String getServiceopt() {
		return serviceopt;
	}

	public void setServiceopt(String serviceopt) {
		this.serviceopt = serviceopt;
	}

	public boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}

	public String getEmergencycontactperson() {
		return emergencycontactperson;
	}

	public void setEmergencycontactperson(String emergencycontactperson) {
		this.emergencycontactperson = emergencycontactperson;
	}

	public Long getEmergencymobile() {
		return emergencymobile;
	}

	public void setEmergencymobile(Long emergencymobile) {
		this.emergencymobile = emergencymobile;
	}

	public String getEmergencyaddress() {
		return emergencyaddress;
	}

	public void setEmergencyaddress(String emergencyaddress) {
		this.emergencyaddress = emergencyaddress;
	}    

}
