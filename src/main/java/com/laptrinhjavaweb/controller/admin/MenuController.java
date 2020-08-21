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
	public ModelAndView edit(@ModelAttribute(("model")) MenuDadModel menuDadModel, MenuChildModel menuchildModel) {
		String type = menuDadModel.getType();
		Long dadId = (menuchildModel.getDadId());
		ModelAndView mav = new ModelAndView("admin/menu/edit");
		if (menuDadModel.getType().equals("dad") && menuDadModel.getId() != null) {
			menuDadModel = menuDadService.findOne(menuDadModel.getId());
			mav.addObject("model", menuDadModel);
		} else if (menuchildModel.getType().equals("child") && menuchildModel.getId() != null) {
			menuchildModel = menuChildService.findOne(menuDadModel.getId());
			mav.addObject("model", menuchildModel);
		}
		mav.addObject("type", type);
		mav.addObject("dadId", dadId);
		return mav;
	}

	@RequestMapping(value = "/admin/menu/update", method = RequestMethod.POST)
	public ModelAndView saves(@ModelAttribute(("model")) MenuDadModel menuDadModel, MenuChildModel menuchildModel) {
		if (menuDadModel.getType().equals("dad")) {
			menuDadService.save(menuDadModel);
		} else if (menuchildModel.getType().equals("child")) {
			menuChildService.save(menuchildModel);
		}
		ModelAndView mav = new ModelAndView("redirect:" + "list");
		return mav;
	}

}
