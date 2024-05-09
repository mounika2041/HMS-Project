package com.doctor.service;

import org.springframework.web.multipart.MultipartFile;

import com.doctor.binding.ForgotpwdForm;
import com.doctor.binding.LoginForm;
import com.doctor.binding.ResetpwdForm;
import com.doctor.entity.DoctorEntity;

public interface DoctorService {

	public DoctorEntity save(MultipartFile pic, String docname, String mobile, String email, String registerid,
			String address, String gender, String specialization, String otherservices, Integer experience,
			String qualification, String department, String hod, String pwd, String confirmPwd, boolean declaration);

	public DoctorEntity update(MultipartFile pic, String docid, String docname, String mobile, String email,
			String registerid, String address, String gender, String specialization, String otherservices,
			Integer experience, String qualification, String department, String hod, String pwd, String confirmPwd,
			boolean declaration);

	public DoctorEntity login(LoginForm login);

	public boolean forgotPwd(ForgotpwdForm forgotPwd);

	public boolean resetPwd(ResetpwdForm resetPwd);

	public String generateUniqueId();
}
