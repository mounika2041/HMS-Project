package com.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doctor.binding.ForgotpwdForm;
import com.doctor.binding.LoginForm;
import com.doctor.binding.ResetpwdForm;
import com.doctor.entity.DoctorEntity;
import com.doctor.service.DoctorService;
import com.doctor.utility.LoginResponse;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private LoginResponse loginResponse;

	@PostMapping(path = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> save(@RequestParam("pic") MultipartFile pic, @RequestParam("docname") String docname,
			@RequestParam("mobile") String mobile, @RequestParam("email") String email,
			@RequestParam("registerid") String registerid, @RequestParam("address") String address,
			@RequestParam("gender") String gender, @RequestParam("specialization") String specialization,
			@RequestParam("otherservices") String otherservices, @RequestParam("experience") Integer experience,
			@RequestParam("qualification") String qualification, @RequestParam("department") String department,
			@RequestParam("hod") String hod, @RequestParam("pwd") String pwd,
			@RequestParam("confirmPwd") String confirmPwd, @RequestParam("declaration") boolean declaration) {

		try {
			doctorService.save(pic, docname, mobile, email, registerid, address, gender, specialization, otherservices,
					experience, qualification, department, hod, pwd, confirmPwd, declaration);
			return ResponseEntity.ok().body("saved successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving: " + e.getMessage());
		}
	}

	@PutMapping(path = "/update/{docid}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<DoctorEntity> update(@PathVariable("docid") String docid,
			@RequestParam("pic") MultipartFile pic, @RequestParam("docname") String docname,
			@RequestParam("mobile") String mobile, @RequestParam("email") String email,
			@RequestParam("registerid") String registerid, @RequestParam("address") String address,
			@RequestParam("gender") String gender, @RequestParam("specialization") String specialization,
			@RequestParam("otherservices") String otherservices, @RequestParam("experience") Integer experience,
			@RequestParam("qualification") String qualification, @RequestParam("department") String department,
			@RequestParam("hod") String hod, @RequestParam("pwd") String pwd,
			@RequestParam("confirmPwd") String confirmPwd, @RequestParam("declaration") boolean declaration) {
		DoctorEntity updatedDoctorEntity = doctorService.update(pic, docid, docname, mobile, email, registerid, address,
				gender, specialization, otherservices, experience, qualification, department, hod, pwd, confirmPwd,
				declaration);

		if (updatedDoctorEntity != null) {
			return ResponseEntity.ok().body(updatedDoctorEntity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginForm login, RedirectAttributes attributes) {
		DoctorEntity doctor = doctorService.login(login);
		if (doctor != null) {
			attributes.addFlashAttribute("loggedInDoctor", doctor);
			LoginResponse response = new LoginResponse("/dashboard", doctor);
			return ResponseEntity.ok().body(response);
		} else {
			attributes.addFlashAttribute("errorMessage", "Invalid username or password");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@PostMapping("/forgotpwd")
	public ResponseEntity<Void> forgotPwd(@RequestBody ForgotpwdForm forgotPwd) {
		boolean isForgotPwd = doctorService.forgotPwd(forgotPwd);
		if (isForgotPwd) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/resetPwd")
	public ResponseEntity<?> resetPwd(@RequestBody ResetpwdForm resetPwd) {
		boolean isResetPwd = doctorService.resetPwd(resetPwd);
		if (isResetPwd) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
