package com.shoping.onlineshoping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoping.shopingbackend.dao.CategoryDAO;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO CategoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		/* mv.addObject("greeting", "Welcome to spring mvc"); */
		mv.addObject("title", "Home");

		mv.addObject("categories", CategoryDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		/* mv.addObject("greeting", "Welcome to spring mvc"); */
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		/* mv.addObject("greeting", "Welcome to spring mvc"); */
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = { "/services" })
	public ModelAndView services() {
		ModelAndView mv = new ModelAndView("page");
		/* mv.addObject("greeting", "Welcome to spring mvc"); */
		mv.addObject("title", "Services");
		mv.addObject("userClickServices", true);
		return mv;
	}

	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		if (greeting == null) {
			greeting = "greeting is null";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}

}
