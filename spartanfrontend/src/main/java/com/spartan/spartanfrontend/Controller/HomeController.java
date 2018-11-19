package com.spartan.spartanfrontend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping({"/","/home"})
	public String homepage(Model m)
	{ m.addAttribute("sliderpage",true);
		return"index";
	}
	
	
	
	@RequestMapping("/aboutus")
	public String aboutuspage(Model m)
	{
		m.addAttribute("aboutuspage",true);
		return "index";
	}
	
	
	
	@RequestMapping("/contactus")
	public String contactuspage(Model m)
	{
		m.addAttribute("contactuspage",true);
		return "index";
	}

	
	
	
//	@RequestMapping("/register")
//	public String registerpage(Model m)
//	{
//		m.addAttribute("registerpage",true);
//		return "index";
//	}
}
