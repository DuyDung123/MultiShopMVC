package com.laptrinhjavaweb.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.ProductModel;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/home");
		ProductModel value = new ProductModel();
		value.setName("session okokokokok"+1);
		value.setQuantity(value.getQuantity()+1);
		   request.getSession().getAttribute("cart");
		return mav;
	}
	
	@RequestMapping(value = "/admin/home1", method = RequestMethod.GET)
	public ModelAndView testMestod(HttpServletRequest request,ProductModel model){
		ModelAndView mav = new ModelAndView("admin/NewFile");
		ProductModel cart = (ProductModel)request.getSession().getAttribute("cart");
		mav.addObject("testSession", cart);
		return mav;
	}
	@RequestMapping(value = "/admin/home2", method = RequestMethod.GET)
	public ModelAndView addvalueSession(HttpServletRequest request,ProductModel model){
		ModelAndView mav = new ModelAndView("admin/NewFile");
		ProductModel cart = (ProductModel)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new ProductModel();
		}
		cart.setQuantity(cart.getQuantity()+ 1);
		request.getSession().setAttribute("cart", cart);
		mav.addObject("testSession", cart);
		return mav;
	}
}
