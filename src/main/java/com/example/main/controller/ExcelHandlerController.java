package com.example.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.main.service.ExcelService;

@Controller
public class ExcelHandlerController {

	@Autowired
	private ExcelService excelService;

	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	public ModelAndView move() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("excel");
		return modelAndView;
	}

	@RequestMapping(value = "excelOperation", method = RequestMethod.POST)
	public ModelAndView readOrWrite() {
		ModelAndView modelAndView = new ModelAndView();
		excelService.readExcel("Books.xlsx");
		modelAndView.setViewName("excel");
		return modelAndView;
	}
}