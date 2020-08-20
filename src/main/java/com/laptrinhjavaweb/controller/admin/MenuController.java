package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.MenuChildModel;
import com.laptrinhjavaweb.model.MenuDadModel;
import com.laptrinhjavaweb.service.IMenuChildService;
import com.laptrinhjavaweb.service.IMenuDadService;

@Controller(value = "menuControllerOfAdmin")
public class MenuController {

	@Autowired
	IMenuDadService menuDadService;
	
	@Autowired
	IMenuChildService menuChildService;

	@RequestMapping(value = "/admin/menu/list", method = RequestMethod.GET)
	public ModelAndView showList() {
		MenuDadModel menuDadModel = new MenuDadModel();
		MenuChildModel menuchildModel = new MenuChildModel();
		menuDadModel.setListResult(menuDadService.findAll());
		menuchildModel.setListResult(menuChildService.findAll());
		ModelAndView mav = new ModelAndView("admin/menu/menu");
		mav.addObject("modelDad", menuDadModel);
		mav.addObject("modelChild", menuchildModel);
		return mav;
	}

	@RequestMapping(value = "/admin/N/menu/edit", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute(("model")) MenuDadModel menuDadModel) {
		if (menuDadModel.getId() != null) {
			menuDadModel = menuDadService.findOne(menuDadModel.getId());
		}
		ModelAndView mav = new ModelAndView("admin/menu/edit");
		mav.addObject("model", menuDadModel);
		return mav;
	}

	@RequestMapping(value = "/admin/menu/update", method = RequestMethod.POST)
	public ModelAndView saves(@ModelAttribute(("model")) MenuDadModel menuDadModel) {
		menuDadService.save(menuDadModel);
		menuDadModel.setListResult(menuDadService.findAll());
		ModelAndView mav = new ModelAndView("redirect:" + "list");
		mav.addObject("model", menuDadModel);
		return mav;
	}

}
