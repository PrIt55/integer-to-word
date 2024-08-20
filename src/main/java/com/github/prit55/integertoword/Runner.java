package com.github.prit55.integertoword;

import java.util.HashMap;
import java.util.Map;

public class Runner {
	
	/*
	 * Given an integer N, the task is to convert the given number into words.
	 * 
	 * Example 1:
	 * Input: N = 438237764
	 * Output: Four Hundred Thirty Eight Million Two Hundred Thirty Seven Thousand Seven Hundred Sixty Four
	 * 
	 * Example 2:
	 * Input N = 1000
	 * Output: One Thousand
	 */
	
	private static final String ZERO = "Zero";
	
	private static final Map<Integer, String> numberUnderTwentyMap = new HashMap<>();
	static {
		numberUnderTwentyMap.put(1, "One");
		numberUnderTwentyMap.put(2, "Two");
		numberUnderTwentyMap.put(3, "Three");
		numberUnderTwentyMap.put(4, "Four");
		numberUnderTwentyMap.put(5, "Five");
		numberUnderTwentyMap.put(6, "Six");
		numberUnderTwentyMap.put(7, "Seven");
		numberUnderTwentyMap.put(8, "Eight");
		numberUnderTwentyMap.put(9, "Nine");
		
		numberUnderTwentyMap.put(10, "Ten");
		numberUnderTwentyMap.put(11, "Eleven");
		numberUnderTwentyMap.put(12, "Twelve");
		numberUnderTwentyMap.put(13, "Thirteen");
		numberUnderTwentyMap.put(14, "Fourteen");
		numberUnderTwentyMap.put(15, "Fifteen");
		numberUnderTwentyMap.put(16, "Sixteen");
		numberUnderTwentyMap.put(17, "Seventeen");
		numberUnderTwentyMap.put(18, "Eighteen");
		numberUnderTwentyMap.put(19, "Nineteen");
	}
	
	private static final Map<Integer, String> numberTensMap = new HashMap<>();
	static {
		numberTensMap.put(2, "Twenty");
		numberTensMap.put(3, "Thirty");
		numberTensMap.put(4, "Forty");
		numberTensMap.put(5, "Fifty");
		numberTensMap.put(6, "Sixty");
		numberTensMap.put(7, "Seventy");
		numberTensMap.put(8, "Eighty");
		numberTensMap.put(9, "Ninety");
	}
	
	private static final String NEGATIVE = "Negative";
	
	private static final String HUNDRED = "Hundred";
	
	private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

	public static void main(String[] args) {
		int n = 2147083648;
		
		String result = integerToWord(n);
		System.out.println(result);
	}
	
	public static String integerToWord(int n) {
		if (n == 0)
			return ZERO;
		
		else if (n < 0)
			return NEGATIVE + " " + integerToWord(-n);
		
		StringBuilder result = new StringBuilder();
        int thousandCounter = 0;
        
        while (n > 0) {
            if (n % 1000 != 0) {
                result.insert(0, integerToWordUnderThousand(n % 1000) + " " + THOUSANDS[thousandCounter] + " ");
            }
            n /= 1000;
            
            ++thousandCounter;
        }
        
        return result.toString().trim();
	}
	
	private static String integerToWordUnderThousand(int n) {
        StringBuilder result = new StringBuilder();
        
        if (n >= 100) {
            result.append(numberUnderTwentyMap.get(n / 100)).append(" ").append(HUNDRED).append(" ");
            n %= 100;
        }
        
        if (n >= 20) {
            result.append(numberTensMap.get(n / 10)).append(" ");
            n %= 10;
        }
        
        if (n > 0) {
            result.append(numberUnderTwentyMap.get(n)).append(" ");
        }
        
        return result.toString().trim();
    }

}
