package com.laptrinhjavaweb.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.MenuChildModel;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.IMenuChildService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.utils.CustomUtils;

@Controller(value = "ProductControllerOfAdmin")
public class ProductController {
	
	

	
	
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IMenuChildService menuChildService;
	
	@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
	public ModelAndView showList() {
		ProductModel productModel = new ProductModel();
		productModel.setListResult(productService.findAll());
		ModelAndView mav = new ModelAndView("admin/product/list");
		mav.addObject("model", productModel);
		return mav;
	}
	
	@RequestMapping(value = "/admin/product/edit", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id", required = false) Integer id) {
		ProductModel productModel = new ProductModel();
		if(id !=null) {
			productModel = productService.findOne(id.longValue());
		}
		MenuChildModel childModel = new MenuChildModel();
		childModel.setListResult(menuChildService.findAll());
		ModelAndView mav = new ModelAndView("admin/product/edit");
		mav.addObject("model", productModel);
		mav.addObject("menuchilds", childModel);
		return mav;
	}
	
	
	@RequestMapping(value = "/admin/product/add", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute(("model")) ProductModel productModel, HttpSession session) {
		productModel = productService.save(productModel);
		ModelAndView mav = new ModelAndView("redirect:" + "edit"+"?id="+productModel.getId());
		return mav;
	}
}








