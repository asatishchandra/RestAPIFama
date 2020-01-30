package com.restapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restapi.beans.NumToEnglishModel;
import com.restapi.services.NumToEnglishSvc;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConvertNumToEnglishController 
{

	@RequestMapping(method = RequestMethod.GET, value="/num_to_english/{number}")
	
	@ResponseBody
	public NumToEnglishModel NumToEnglish(@PathVariable("number") String number) 
	{
		
		NumToEnglishModel model = new NumToEnglishModel();
		Long num = 0L;
		
		if(number.length() > 15) {
			model.setStatus("Number length cannot be more than 15 numbers long.");
			return model;
		}
		
		try {
			num = Long.parseLong(number);
		}
		catch(Exception e) {
			model.setStatus("Input parameter is not of accpetable type");
		}
		model.setStatus("Success");
		model.setNumber(num);
		model.setNumInEnglish(NumToEnglishSvc.convertToWords(num));
		//test
		return model;
	}
}
