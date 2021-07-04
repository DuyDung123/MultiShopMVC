package com.laptrinhjavaweb.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.ProductModel;

public class UploadController {
	
	@RequestMapping(value = "/admin/menu/upload", method = RequestMethod.POST)
	public ModelAndView showList() {
		ProductModel productModel = new ProductModel();
		ModelAndView mav = new ModelAndView("admin/upload/upload");
		mav.addObject("model", productModel);
		return mav;
	}

}
