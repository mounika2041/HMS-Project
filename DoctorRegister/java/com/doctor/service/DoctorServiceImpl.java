package com.doctor.service;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.doctor.binding.ForgotpwdForm;
import com.doctor.binding.LoginForm;
import com.doctor.binding.ResetpwdForm;
import com.doctor.entity.DoctorEntity;
import com.doctor.repo.DoctorRepo;
import com.doctor.utility.EmailUtil;
import com.doctor.utility.OtpUtil;

import jakarta.servlet.http.HttpSession;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepo doctorRepo;

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
		return "DOC" + newId;
	}

	@Override
	public DoctorEntity save(MultipartFile pic, String docname, String mobile, String email, String registerid,
			String address, String gender, String specialization, String otherservices, Integer experience,
			String qualification, String department, String hod, String pwd, String confirmPwd, boolean declaration) {

		DoctorEntity doctor = new DoctorEntity();
		String uniqueId = generateUniqueId();
		doctor.setDocid(uniqueId);
		doctor.setDocname(docname);
		doctor.setMobile(mobile);
		doctor.setEmail(email);
		doctor.setRegisterid(registerid);
		doctor.setAddress(address);
		doctor.setGender(gender);
		doctor.setSpecialization(specialization);
		doctor.setOtherservices(otherservices);
		doctor.setExperience(experience);
		doctor.setQualification(qualification);
		doctor.setDepartment(department);
		doctor.setHod(hod);
		doctor.setPwd(pwd);
		doctor.setConfirmPwd(confirmPwd);
		doctor.setDeclaration(declaration);

		try {
			doctor.setPic(Base64.getEncoder().encodeToString(pic.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		doctorRepo.save(doctor);
		return doctor;
	}

	@Override
	public DoctorEntity update(MultipartFile pic, String docid, String docname, String mobile, String email,
			String registerid, String address, String gender, String specialization, String otherservices,
			Integer experience, String qualification, String department, String hod, String pwd, String confirmPwd,
			boolean declaration) {

		DoctorEntity existingDoctor = doctorRepo.findByDocid(docid);
		existingDoctor.setDocname(docname);
		existingDoctor.setMobile(mobile);
		existingDoctor.setEmail(email);
		existingDoctor.setRegisterid(registerid);
		existingDoctor.setAddress(address);
		existingDoctor.setGender(gender);
		existingDoctor.setSpecialization(specialization);
		existingDoctor.setOtherservices(otherservices);
		existingDoctor.setExperience(experience);
		existingDoctor.setQualification(qualification);
		existingDoctor.setDepartment(department);
		existingDoctor.setHod(hod);
		existingDoctor.setPwd(pwd);
		existingDoctor.setConfirmPwd(confirmPwd);
		existingDoctor.setDeclaration(declaration);

		try {
			if (pic != null && !pic.isEmpty()) {
				String base64Image = Base64.getEncoder().encodeToString(pic.getBytes());
				existingDoctor.setPic(base64Image);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doctorRepo.save(existingDoctor);
	}

	@Override
	public DoctorEntity login(LoginForm login) {
		DoctorEntity doctor = doctorRepo.findByEmail(login.getEmail());
		if (doctor != null && doctor.getPwd().equals(login.getPwd())) {
			return doctor;
		} else {
			return null;
		}
	}

	@Override
	public boolean forgotPwd(ForgotpwdForm forgotPwd) {
		String email = forgotPwd.getEmail();
		DoctorEntity doctor = doctorRepo.findByEmail(email);

		if (doctor == null) {
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

		DoctorEntity doctor = doctorRepo.findByEmail(email);

		if (doctor == null) {
			return false;
		}
		doctor.setPwd(newPwd);
		doctorRepo.save(doctor);
		session.invalidate();
		return true;
	}
}