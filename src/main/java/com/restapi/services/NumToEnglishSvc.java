package com.restapi.services;

public class NumToEnglishSvc {
	private static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

    private static final  String[] tens = { 
		    "", 		// 0
		    "",		    // 1
		    "Twenty", 	// 2
		    "Thirty", 	// 3
		    "Forty", 	// 4
		    "Fifty", 	// 5
		    "Sixty", 	// 6
		    "Seventy",	// 7
		    "Eighty", 	// 8
		    "Ninety" 	// 9
    };
	    
	
	public static String convertToWords(Long num)
    {
		if(num.toString().length() > 15) {
			return "Number length cannot be more than 15 numbers long.";
		}
		return converToWordsHelper(num);
    }
    
    private static String converToWordsHelper(long num) {
	    if (num < 0)
	    {
	        return "Minus " + converToWordsHelper(-num);
	    }
	
	    if (num < 20)
	    {
	        return units[(int) num];
	    }
	
	    if (num < 100)
	    {
	        return tens[(int) (num / 10)] + ((num % 10 != 0) ? " " : "") + units[(int) (num % 10)];
	    }
	
	    if (num < 1000)
	    {
	        return units[(int) (num / 100)] + " Hundred" + ((num % 100 != 0) ? " " : "") + converToWordsHelper(num % 100);
	    }
	
	    if (num < 10000 || num < 100000 || num < 1000000)
	    {
	        return converToWordsHelper(num / 1000) + " Thousand" + ((num % 1000 != 0) ? " " : "") + converToWordsHelper(num % 1000);
	    }
	
	    if (num < 10000000 || num < 100000000 || num < 1000000000)
	    {
	        return converToWordsHelper(num / 1000000) + " Million" + ((num % 1000000 != 0) ? " " : "") + converToWordsHelper(num % 1000000);
	    }
	
	    if (num < 10000000000L || num < 100000000000L || num < 1000000000000L)
	    {
	        return converToWordsHelper(num / 1000000000) + " Billion" + ((num % 1000000000 != 0) ? " " : "") + converToWordsHelper(num % 1000000000);
	    }
	    return converToWordsHelper(num / 1000000000000L) + " Trillion" + ((num % 1000000000000L != 0) ? " " : "") + converToWordsHelper(num % 1000000000000L);
    }
}
