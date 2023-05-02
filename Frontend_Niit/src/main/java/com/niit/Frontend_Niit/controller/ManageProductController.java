package com.niit.Frontend_Niit.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend_Niit.DAO.CategoryDAO;
import com.niit.Backend_Niit.DAO.ProductDAO;
import com.niit.Backend_Niit.DAO.UserDAO;
import com.niit.Backend_Niit.model.Product;
import com.niit.Backend_Niit.model.Category;
import com.niit.Backend_Niit.model.User;

@Controller
@RequestMapping(value = "/manage")
public class ManageProductController {
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/product")
	public ModelAndView manageProduct(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("userclickmanageproduct", true);
		mv.addObject("title", "Online Shopping - Manage Product");

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product submitted successfully!");
			}
		}
		
		Product newProduct = new Product();
		newProduct.setActive(true);

		mv.addObject("product", newProduct);

		return mv;
	}

	@ModelAttribute("categoryList")
	public List<Category> getcategoryList() {
		return categoryDAO.activeCategoryList();
	}

	@ModelAttribute("supplierList")
	public List<User> getSupplierList() {
		return userDAO.getSupplierList();
	}

	@RequestMapping(value = "/add/product")
	public String addProduct(@Valid @ModelAttribute("product") Product n_product, BindingResult results, Model model) {

		System.out.println(n_product.toString());
		if (results.hasErrors()) {

			model.addAttribute("userclickmanageproduct", true);
			model.addAttribute("title", "Online Shopping - Manage Product");
			return "index";
		}

		productDAO.addProduct(n_product);

		return "redirect:/manage/product?operation=product";

	}

}
