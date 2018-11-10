package com.spartan.spartanfrontend.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spartan.spartanbackend.DALayer.CategoryDAO;
import com.spartan.spartanbackend.DALayer.CategoryDAOImpl;
import com.spartan.spartanbackend.model.Category;


@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categorydaoImpl;


	
	@RequestMapping("/category")
		public String categorypage(Model m) {
		System.out.println("hi");
			m.addAttribute("categorypage",true);
			m.addAttribute("title","spartan-Category");
			m.addAttribute("category",new Category());
			m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
			m.addAttribute("edit",false);
			return "index";
			
		}
	 
	@RequestMapping("/addCategory")
	public String addCategory(@Valid @ModelAttribute("category") Category Category, BindingResult BR, Model m) {
		if (BR.hasErrors()) {
			System.out.println("err");
			m.addAttribute("categorypage", true);
			m.addAttribute("title", "spartan-Category");
			m.addAttribute("category", Category);
			m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());

		} else {
			if (categorydaoImpl.CreateCategory(Category)) {
				System.out.println("err1");
				m.addAttribute("categorypage", true);
				m.addAttribute("title", "spartan-Category");
				m.addAttribute("category", new Category());
				m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());

			} else {
				System.out.println("err2");
				m.addAttribute("categorypage", true);
				m.addAttribute("title", "spartan-Category");
				m.addAttribute("category", Category);
				m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());

			}
		}
		return "index";
	}


	@RequestMapping("/deletecategory")
	public String deletecategory(@RequestParam("cname") String cname)
	{
		categorydaoImpl.DeleteCategory(cname);
		return "redirect:/category";
	}
	
	@RequestMapping("/editcategory")
	public String editcategory(@RequestParam("cname") String cname,Model m)
	{

		
		m.addAttribute("categorypage",true);
		m.addAttribute("title","spartan-Category");
		m.addAttribute("category", categorydaoImpl.ViewOneCategory(cname));
		m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
		m.addAttribute("edit",true);
		return "index";
		
}


	@RequestMapping("/updatecategory")
	public String editCategory(@Valid @ModelAttribute("category") Category Category, BindingResult BR, Model m) {
		if (BR.hasErrors()) {
			System.out.println("err");
			m.addAttribute("categorypage", true);
			m.addAttribute("title", "spartan-Category");
			m.addAttribute("category", Category);
			m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
			m.addAttribute("edit",true);

		} else {
			if (categorydaoImpl.UpdateCategory(Category)) {
				System.out.println("err1");
				m.addAttribute("categorypage", true);
				m.addAttribute("title", "spartan-Category");
				m.addAttribute("category",new Category());
				m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
				m.addAttribute("edit",false);

			} else {
				System.out.println("err2");
				m.addAttribute("categorypage", true);
				m.addAttribute("title", "spartan-Category");
				m.addAttribute("category", Category);
				m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
				m.addAttribute("edit",true);

			}
		}
		return "index";
	}

}
