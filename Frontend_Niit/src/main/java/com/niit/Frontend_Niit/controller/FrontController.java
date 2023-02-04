package com.niit.Frontend_Niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController 
{
	
	@RequestMapping(value={"/index","/home","/"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","ONLINE SHOPPING - INDEX");
		mv.addObject("welcome","Hello User!!! Welcome to ONLINE SHOPPING HOME PAGE");
		mv.addObject("userclickhome" , true);
		
		return mv;
	}
	
	
	@RequestMapping(value="/aboutus")
	public ModelAndView aboutus()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","ONLINE SHOPPING - ABOUT US");
		mv.addObject("welcome","Hello User!!! Welcome to ONLINE SHOPPING ABOUT US PAGE");
		mv.addObject("userclickaboutus" , true);
		
		return mv;
	}
	
	@RequestMapping(value="/contactus")
	public ModelAndView contactus()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","ONLINE SHOPPING - CONTACT US");
		mv.addObject("welcome","Hello User!!! Welcome to ONLINE SHOPPING CONTACT US PAGE");
		mv.addObject("userclickcontactus" , true);
		
		return mv;
	}
	

}
