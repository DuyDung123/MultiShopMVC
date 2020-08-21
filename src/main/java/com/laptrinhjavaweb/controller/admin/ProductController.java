package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.IProductService;

@Controller(value = "ProductControllerOfAdmin")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
	public ModelAndView showList() {
		ModelAndView mav = new ModelAndView("admin/product/list");
		
		return mav;
	}

}
