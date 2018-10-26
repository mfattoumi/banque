package com.banque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banque.service.IBanqueService;

@Controller
public class BanqueController {

	@Autowired
	private IBanqueService banqueService;
	
	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
}
