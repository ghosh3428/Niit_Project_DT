package com.niit.Frontend_Niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.Backend_Niit.DAO.ProductDAO;
import com.niit.Backend_Niit.model.Product;

@Controller
public class JsonController 
{
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/json/data/all/active/product")
	@ResponseBody
	public List<Product> getActiveproduct()
	{
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping(value="/json/data/category/{id}/product")
	@ResponseBody
	public List<Product> getcategoryproduct(@PathVariable("id") int category_id)
	{
		return productDAO.listActiveProductsByCategory(category_id);
	}
		
	

}
