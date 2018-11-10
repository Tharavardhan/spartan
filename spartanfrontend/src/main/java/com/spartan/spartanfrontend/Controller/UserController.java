package com.spartan.spartanfrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spartan.spartanbackend.DALayer.UserDAO;

import com.spartan.spartanbackend.model.UserDetails;

@Controller
public class UserController {
	@Autowired
	UserDAO userdaoImpl;

	@RequestMapping("/register")
	public String regpage(Model m) {
		System.out.println("hi");
		m.addAttribute("registerpage", true);
		m.addAttribute("title", "spartan-Register");
		m.addAttribute("ud", new UserDetails());
		
		return "index";

	}

	@RequestMapping("/addUser")
	public String addCategory(@Valid @ModelAttribute("ud") UserDetails UserDetails, BindingResult BR, Model m) {
		if (BR.hasErrors()) {
			System.out.println("err");
			m.addAttribute("registerpage", true);
			m.addAttribute("title", "spartan-Register");
			m.addAttribute("ud", UserDetails);

		} else {
			if (userdaoImpl.CreateUserDetails(UserDetails)) {
				System.out.println("err1");
				m.addAttribute("loginpage", true);
				m.addAttribute("title", "spartan-Login");

			} else {
				System.out.println("err2");
				m.addAttribute("registerpage", true);
				m.addAttribute("title", "spartan-Register");
				m.addAttribute("ud", UserDetails);

			}
		}
		return "index";
	}

}
