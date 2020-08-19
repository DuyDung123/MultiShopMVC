package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.model.MenuDadModel;
import com.laptrinhjavaweb.service.IMenuDadService;



@RestController(value = "newAPIOfAdmin")
public class MenuAPI {
	
	@Autowired
	IMenuDadService menuDadService;
	
	@PostMapping("/api/menu")
	public MenuDadModel createNew(@RequestBody MenuDadModel menuDadModel) {
		return menuDadService.save(menuDadModel);
	}
	
	@PutMapping("/api/menu")
	public MenuDadModel updateNew(@RequestBody MenuDadModel menuDadModel) {
		return menuDadService.save(menuDadModel);
	}
	
	@DeleteMapping("/api/menu")
	public void deleteNew(@RequestBody long[] ids) {
		menuDadService.delete(ids);
	}
}