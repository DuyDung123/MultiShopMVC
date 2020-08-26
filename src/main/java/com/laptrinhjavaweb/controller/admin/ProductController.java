package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.IProductService;

@Controller(value = "ProductControllerOfAdmin")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
	public ModelAndView showList() {
		ProductModel productModel = new ProductModel();
		productModel.setListResult(productService.findAll());
		ModelAndView mav = new ModelAndView("admin/product/list");
		mav.addObject("model", productModel);
		return mav;
	}

}
