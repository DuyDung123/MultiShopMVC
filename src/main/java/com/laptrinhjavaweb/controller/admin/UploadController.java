package com.laptrinhjavaweb.controller.admin;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.MyFileUpload;
import com.laptrinhjavaweb.model.ProductModel;

@Controller(value = "UploadControllerOfAdmin")
public class UploadController {
	
	@RequestMapping(value = "/admin/upload", method = RequestMethod.GET)
	public ModelAndView showList() {
		ProductModel productModel = new ProductModel();
		ModelAndView mav = new ModelAndView("admin/upload/upload");
		mav.addObject("model", productModel);
		return mav;
	}
	
	@RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
	public String upload(MyFileUpload myFile, Model model) {
		model.addAttribute("message", "upload success");
	    model.addAttribute("description", myFile.getDescription());
	    
	    try {
	        MultipartFile multipartFile = myFile.getMultipartFile();
	        String fileName = multipartFile.getOriginalFilename();
	        File file = new File("D:/chorme", fileName);
	        multipartFile.transferTo(file);
	      } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("message", "upload failed");
	      }
	      return "result";
	    
	}

}
