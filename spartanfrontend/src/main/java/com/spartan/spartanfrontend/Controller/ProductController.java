package com.spartan.spartanfrontend.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spartan.spartanbackend.DALayer.CategoryDAO;
import com.spartan.spartanbackend.DALayer.ProductDAO;
import com.spartan.spartanbackend.model.Category;
import com.spartan.spartanbackend.model.Product;



@Controller
public class ProductController {
	
    @Autowired
	ProductDAO productdaoiImpl;
    
    @Autowired
    CategoryDAO categorydaoImpl;


	
	
	
	@RequestMapping("admin/product")
		public String productpage(Model m) {
		System.out.println("hi");
			m.addAttribute("productpage",true);
			m.addAttribute("title","spartan-product");
			m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
			m.addAttribute("prodlist",productdaoiImpl.showallProduct());
			m.addAttribute("product",new Product());
			return "index";
			
		}
	
	@RequestMapping("admin/addProduct")
	public String addProduct(@Valid @ModelAttribute("product") Product Product, BindingResult BR, Model m) {
		if (BR.hasErrors()) {
			System.out.println("err");
			m.addAttribute("productpage", true);
			m.addAttribute("title", "spartan-Product");
			m.addAttribute("product", Product);
			m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
			m.addAttribute("prodlist",productdaoiImpl.showallProduct());

		} else {
			System.out.println(Product.getCategory().getCategory_id());
			if (productdaoiImpl.CreateProduct(Product)) {
				System.out.println("err1");
				addimage(Product.getPimage(),Product.getProduct_id());
				m.addAttribute("productpage", true);
				m.addAttribute("title", "spartan-Product");
				m.addAttribute("product", new Product());
				m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
				m.addAttribute("prodlist",productdaoiImpl.showallProduct());

			} else {
				System.out.println("err2");
				m.addAttribute("productpage", true);
				m.addAttribute("title", "spartan-Product");
				m.addAttribute("product", Product);
				m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
				m.addAttribute("prodlist",productdaoiImpl.showallProduct());

			}

	}
		return "index";
	}
	
	@RequestMapping("admin/deleteproduct")
	public String deleteproduct(@RequestParam("pid") int pid)
	{
		productdaoiImpl.DeleteProduct(productdaoiImpl.SelectProduct(pid));

		String path="G:\\project\\spartanfrontend\\src\\main\\webapp\\resources\\pimages\\";
		path=path+String.valueOf(pid)+".jpg";
		File x=new File(path);
		if(x.exists())
		{
				x.delete();
		}	
		return "redirect:/admin/product";
	}
	
	@RequestMapping("admin/editproduct")
	public String editproduct(@RequestParam("pid") int pid,Model m)
	{

		
		m.addAttribute("productpage",true);
		m.addAttribute("title","spartan-product");
		m.addAttribute("product", productdaoiImpl.SelectProduct(pid));
		m.addAttribute("prodlist",productdaoiImpl.showallProduct());
		m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
		m.addAttribute("edit",true);
		return "index";
		
}


	@RequestMapping("admin/updateproduct")
	public String editproduct(@Valid @ModelAttribute("product") Product Product, BindingResult BR, Model m) {
		if (BR.hasErrors()) {
			System.out.println("err");
			m.addAttribute("productpage", true);
			m.addAttribute("title", "spartan-product");
			m.addAttribute("product", Product);
			m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
			m.addAttribute("prodlist",productdaoiImpl.showallProduct());
			m.addAttribute("edit",true);

		} else {
			if (productdaoiImpl.UpdateProduct(Product)) {
				System.out.println("err1");
				m.addAttribute("productpage", true);
				m.addAttribute("title", "spartan-Category");
				m.addAttribute("product",new Product());
				m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
				m.addAttribute("prodlist",productdaoiImpl.showallProduct());
				m.addAttribute("edit",false);

			} else {
				System.out.println("err2");
				m.addAttribute("productpage", true);
				m.addAttribute("title", "spartan-product");
				m.addAttribute("product", Product);
				m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
				m.addAttribute("prodlist",productdaoiImpl.showallProduct());
				m.addAttribute("edit",true);

			}
		}
		return "index";
	}
	
	
	void addimage(MultipartFile f,int id)
	{
		try
		{
			String path="G:\\project\\spartanfrontend\\src\\main\\webapp\\resources\\pimages\\";
			path=path+String.valueOf(id)+".jpg";
			if(!f.isEmpty())
			{
				byte[] imagebytes=f.getBytes();
				File x=new File(path);
				if(x.exists())
				{
					x.delete();
					BufferedOutputStream bs=new  BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
				else
				{
					BufferedOutputStream bs=new  BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
			}
			Thread.sleep(3000);
		}
		catch (Exception e) {
			
		}
		
	}


	@RequestMapping(value = "/allproducts")
	 public String registepage(Model m) {
	  m.addAttribute("viewallproductspage", true);
	  m.addAttribute("title", "Spartan-Products");
	  m.addAttribute("prodlist", productdaoiImpl.showallProduct());
	  m.addAttribute("catlist",categorydaoImpl.ViewAllCategory());
	  return "index";
	 }

	
	@RequestMapping(value = "/oneproduct")
	 public String oneproductpage(Model m,@RequestParam("pid")int pid) {
	  m.addAttribute("oneproductpage", true);
	  m.addAttribute("title", "Spartan-Products");
	  m.addAttribute("prod", productdaoiImpl.SelectProduct(pid));
	  return "index";
	 }

	@RequestMapping(value = "/products")//2nd change
	 public String catproducts(Model m,@RequestParam("catname") String name) {
	  m.addAttribute("viewallproductspage", true);
	  m.addAttribute("title", "Spartan-Products");
	  m.addAttribute("prodlist", productdaoiImpl.SelectCatproduct(name));
	  m.addAttribute("catlist", categorydaoImpl.ViewAllCategory());
	  return "index";
	 }


}



