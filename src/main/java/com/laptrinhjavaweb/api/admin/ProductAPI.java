package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.IProductService;

@RestController(value = "ProductAPIOfAdmin")
public class ProductAPI {
	
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/api/product/{id}")
	public ProductModel findOne(@RequestBody @PathVariable("id") Integer id) {
		ProductModel productModel = new ProductModel();
		if(id == null) {
			productModel.setListResult(productService.findAll());
		}else {
			productModel= productService.findOne(id.longValue());
		}
		return productModel;
	}
	
	@GetMapping("/api/product")
	public ProductModel findAll() {
		ProductModel productModel = new ProductModel();
		productModel.setListResult(productService.findAll());
		return productModel;
	}
	
	@PostMapping("/api/product")
	public ProductModel createProduct(@RequestBody ProductModel productModel) {
		return productService.save(productModel);
	}
	
	@PutMapping(value = "/api/product/{id}")
	public ProductModel updateProduct(@RequestBody ProductModel model, @PathVariable("id") long id) {
		model.setId(id);
		return productService.save(model);
	}
	
	@DeleteMapping(value = "/api/product")
	public void deleteNew(@RequestBody Long[] ids) {
		productService.delete(ids);
	}

}
