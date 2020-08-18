package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.MenuDadModel;
import com.laptrinhjavaweb.service.IMenuDadService;

@Controller(value = "menuControllerOfAdmin")
public class MenuController {

	@Autowired
	IMenuDadService menuDadService;

	@RequestMapping(value = "/admin/menu/list", method = RequestMethod.GET)
	public ModelAndView showList() {
		MenuDadModel menuDadModel = new MenuDadModel();
		menuDadModel.setListResult(menuDadService.findAll());
		ModelAndView mav = new ModelAndView("admin/menu/list");
		mav.addObject("model", menuDadModel);
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
	public ModelAndView save(@ModelAttribute(("model")) MenuDadModel menuDadModel) {
		String view = "";
		if(menuDadModel.getId() == null) {
			if(menuDadModel.getName() != null) {
				menuDadService.save(menuDadModel);
				menuDadModel.setListResult(menuDadService.findAll());
				view = "admin/menu/list";
			}else {
				menuDadModel.setListResult(menuDadService.findAll());
				view = "admin/menu/list";
			}
		}else if (menuDadModel.getId() != null && menuDadModel.getName() != null) {
			menuDadService.save(menuDadModel);
			menuDadModel.setListResult(menuDadService.findAll());
			view = "admin/menu/list";
		}else {
			view = "admin/menu/list";
		}
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("model", menuDadModel);
		return mav;
	}
	
}
