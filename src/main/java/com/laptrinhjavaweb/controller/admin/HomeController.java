package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.MenuDadModel;
import com.laptrinhjavaweb.service.IMenuDadService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@Autowired
	IMenuDadService menuDadService;
	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
	
	@RequestMapping(value = "/admin/menu/list", method = RequestMethod.GET)
	public ModelAndView showList() {
		MenuDadModel menuDadModel = new MenuDadModel();
		menuDadModel.setListResult(menuDadService.findAll());
		ModelAndView mav = new ModelAndView("admin/menu/list");
		mav.addObject("model",menuDadModel);
		return mav;
	}
	
	@RequestMapping(value = "/admin/menu/edit", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute(("model"))MenuDadModel menuDadModel) {
		if(menuDadModel.getId() != null){
			menuDadModel = menuDadService.findOne(menuDadModel.getId());
		}
		ModelAndView mav = new ModelAndView("admin/menu/edit");
		mav.addObject("model",menuDadModel);
		return mav;
	}
}
