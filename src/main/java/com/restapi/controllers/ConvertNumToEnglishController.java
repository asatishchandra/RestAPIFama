package com.restapi.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.restapi.beans.NumToEnglishModel;
import com.restapi.services.NumToEnglishSvc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/api/v1")
public class ConvertNumToEnglishController 
{

	
	@RequestMapping(method = RequestMethod.GET, value="/num_to_english/")
	
	@ResponseBody
	public ArrayList<NumToEnglishModel> GetAllNumToEnglish() 
	{
		
		ArrayList<NumToEnglishModel> models = new ArrayList<NumToEnglishModel>();
		
		return models;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/num_to_english/{number}")
	
	@ResponseBody
	public NumToEnglishModel NumToEnglish(@PathVariable("number") String number) 
	{
		
		NumToEnglishModel model = new NumToEnglishModel();
		Long num = 0L;
		
		try {
			num = Long.parseLong(number);
			
			if(num.toString().length() > 15) {
				model.setStatus("Number length cannot be more than 15 numbers long.");
				return model;
			}
		}
		catch(Exception e) {
			model.setStatus("Input parameter is not a number.");
			return model;
		}
		model.setStatus("Success");
		model.setNumber(num);
		model.setNumInEnglish(NumToEnglishSvc.convertToWords(num));
		
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/num_to_english/")
	
	@ResponseBody
	public NumToEnglishModel SaveNumToEnglish(@RequestBody NumToEnglishModel model) 
	{
		NumToEnglishModel newModel = new NumToEnglishModel();
		
		return newModel;
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/num_to_english/")
	
	@ResponseBody
	public NumToEnglishModel UpdateNumToEnglish(@RequestBody NumToEnglishModel model) 
	{
		NumToEnglishModel newModel = new NumToEnglishModel();
		
		return newModel;
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/num_to_english/{number}")
	
	@ResponseBody
	public void DeleteNumToEnglish(@PathVariable("number") String number) 
	{
		
		
	}
}
