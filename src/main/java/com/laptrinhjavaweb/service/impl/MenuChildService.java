package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.repository.MenuChildRepository;
import com.laptrinhjavaweb.service.IMenuChildService;

@Service
public class MenuChildService implements IMenuChildService{

	@Autowired
	MenuChildRepository menuChildRepository;

}
