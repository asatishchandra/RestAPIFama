package com.restapi.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.restapi.services.NumToEnglishSvc;

@SpringBootTest
class NumToEnglishSvcTests {

	@Test
	void IsValidNumber() {
		String expectedOutput = "Number length cannot be more than 15 numbers long.";
		long num = 12345678910111111L;
		String output = NumToEnglishSvc.convertToWords(num);
		assert(output).equals(expectedOutput);
	}
	
	@Test
	void NumberToEnglish() {
		String expectedOutput = "Zero";
		long num = 0;
		String output = NumToEnglishSvc.convertToWords(num);
		assert(output).equals(expectedOutput);
		
		expectedOutput = "One";
		num = 1;
		output = NumToEnglishSvc.convertToWords(num);
		assert(output).equals(expectedOutput);
		
		expectedOutput = "One Hundred Twenty Three";
		num = 123;
		output = NumToEnglishSvc.convertToWords(num);
		assert(output).equals(expectedOutput);
		
		expectedOutput = "Twelve Million Three Hundred Forty Five Thousand Six Hundred Seventy Eight";
		num = 12345678;
		output = NumToEnglishSvc.convertToWords(num);
		assert(output).equals(expectedOutput);
	}
	
	@Test
	void negativeNumberToEnglish() {
		String expectedOutput = "Minus One";
		long num = -1;
		String output = NumToEnglishSvc.convertToWords(num);
		assert(output).equals(expectedOutput);
		
		expectedOutput = "Minus One Hundred Twenty Three";
		num = -123;
		output = NumToEnglishSvc.convertToWords(num);
		assert(output).equals(expectedOutput);
		
		expectedOutput = "Minus Twelve Million Three Hundred Forty Five Thousand Six Hundred Seventy Eight";
		num = -12345678;
		output = NumToEnglishSvc.convertToWords(num);
		assert(output).equals(expectedOutput);
	}
}
