package com.patient.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.binding.ForgotpwdForm;
import com.patient.binding.LoginForm;
import com.patient.binding.ResetpwdForm;
import com.patient.entity.PatientEntity;
import com.patient.repository.PatientRepo;
import com.patient.utility.EmailUtil;
import com.patient.utility.OtpUtil;

import jakarta.servlet.http.HttpSession;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	public PatientRepo patientRepo;

	@Autowired
	private HttpSession session;

	@Autowired
	private EmailUtil emailService;

	@Autowired
	private OtpUtil otpUtil;

	private AtomicInteger idCounter = new AtomicInteger(0);

	@Override
	public String generateUniqueId() {
		int newId = idCounter.incrementAndGet();
		return "P" + newId;
	}

	@Override
	public PatientEntity savePatient(PatientEntity patient) {

		if (patient != null) {
			String uniqueId = generateUniqueId();
			patient.setPid(uniqueId);
			PatientEntity save = patientRepo.save(patient);
			return save;
		}
		return null;
	}

	@Override
	public PatientEntity updatePatient(PatientEntity patient) {
		if (patient != null) {
			String id = patient.getPid();
			PatientEntity existingPatient = patientRepo.findByPid(id);
			if (existingPatient != null) {
				existingPatient.setFirstName(patient.getFirstName());
				existingPatient.setLastName(patient.getLastName());
				existingPatient.setEmail(patient.getEmail());
				existingPatient.setOtp(patient.getOtp());
				existingPatient.setMobile(patient.getMobile());
				existingPatient.setAge(patient.getAge());
				existingPatient.setGender(patient.getGender());
				existingPatient.setRelationship(patient.getRelationship());
				existingPatient.setBloodGroup(patient.getBloodGroup());
				existingPatient.setFamilyDoctor(patient.getFamilyDoctor());
				existingPatient.setAddress(patient.getAddress());
		        existingPatient.setDisclaimer(patient.isDisclaimer());
				existingPatient.setRole(patient.getRole());
				existingPatient.setPwd(patient.getPwd());
				existingPatient.setConfirmPwd(patient.getConfirmPwd());
				existingPatient.setAadhar(patient.getAadhar());
				existingPatient.setChronicdiseases(patient.getChronicdiseases());
				existingPatient.setRefferedby(patient.getRefferedby());
				existingPatient.setServiceopt(patient.getServiceopt());
				existingPatient.setInsurance(patient.isInsurance());

				existingPatient.setEmergencycontactperson(patient.getEmergencycontactperson());
				existingPatient.setEmergencymobile(patient.getEmergencymobile());
				existingPatient.setEmergencyaddress(patient.getEmergencyaddress());

				PatientEntity updatedPatient = patientRepo.save(existingPatient);

				return updatedPatient;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public PatientEntity login(LoginForm login) {
		PatientEntity byEmail = patientRepo.findByEmail(login.getEmail());
		if (byEmail != null && byEmail.getPwd().equals(login.getPwd())) {
			return byEmail;
		} else {
			return null;
		}
	}

	@Override
	public boolean forgotPwd(ForgotpwdForm forgotPwd) {
		String email = forgotPwd.getEmail();
		PatientEntity password = patientRepo.findByEmail(email);

		if (password == null) {
			return false;
		}
		String otp = otpUtil.generateOTP();
		session.setAttribute("forgotpwdEmail", email);
		session.setAttribute("forgotpwdOtp", otp);
		session.setMaxInactiveInterval(5 * 60);

		String subject = "Reset Password OTP";
		String body = "<p>Dear User,</p><p>Your OTP for resetting your password is:</p><h2>" + otp + "</h2>";
		emailService.sendEmail(email, subject, body);
		return true;
	}

	@Override
	public boolean resetPwd(ResetpwdForm resetPwd) {
		String email = (String) session.getAttribute("forgotpwdEmail");
		String sessionOtp = (String) session.getAttribute("forgotpwdOtp");
		String formOtp = resetPwd.getOtp();
		String newPwd = resetPwd.getNewpwd();
		String confirmPwd = resetPwd.getConfirmpwd();

		if (!formOtp.equals(sessionOtp)) {
			return false;
		}

		if (!newPwd.equals(confirmPwd)) {
			return false;
		}

		PatientEntity entity = patientRepo.findByEmail(email);

		if (entity == null) {
			return false;
		}
		entity.setPwd(newPwd);
		patientRepo.save(entity);
		session.invalidate();
		return true;
	}

}
