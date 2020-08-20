package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.MenuChildModel;
import com.laptrinhjavaweb.model.MenuDadModel;
import com.laptrinhjavaweb.service.IMenuChildService;
import com.laptrinhjavaweb.service.IMenuDadService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	IMenuDadService menuDadService;
	
	@Autowired
	IMenuChildService menuChildService;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		MenuDadModel menuDadModel = new MenuDadModel();
		MenuChildModel childModel = new MenuChildModel();
		childModel.setListResult(menuChildService.findAll());
		menuDadModel.setListResult(menuDadService.findAll());
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("model", menuDadModel);
		return mav;
	}
}
