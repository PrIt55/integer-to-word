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
	private static final String THOUSAND = "Thousand";
	private static final String MILLION = "Million";
	private static final String BILLION = "Billion";

	public static void main(String[] args) {
		int n = 2147083648;
		
		String result = integerToWord(n);
		System.out.println(result);
	}
	
	public static String integerToWord(int n) {
		String result = "";
		if (n == 0)
			return ZERO;
		
		else if (n < 0) {
			result += NEGATIVE + " ";
			n *= -1;
		}
		
		return result + integerToWordRecursive(n).trim();
	}
	
	private static String integerToWordRecursive(int n) {
		if (numberUnderTwentyMap.containsKey(n))
			return numberUnderTwentyMap.get(n);
		
		String nS = Integer.toString(n);
		
		// Skip the 0s in front
		if (Integer.valueOf(nS.substring(0, 1)) == 0) {
			return integerToWordRecursive(Integer.valueOf(nS.substring(1)));
		}
		
		int nLenght = nS.length();
		
		if (nLenght == 2)
			return numberTensMap.get(Integer.valueOf(nS.substring(0, 1))) + " " 
				+ integerToWordRecursive(Integer.valueOf(nS.substring(1))) + " " ;	
		
		if (nLenght == 3)
			return numberUnderTwentyMap.get(Integer.valueOf(nS.substring(0, 1))) + " " 
				+ HUNDRED + " "
				+ integerToWordRecursive(Integer.valueOf(nS.substring(1))) + " " ;
		
		if (nLenght == 4)
			return numberUnderTwentyMap.get(Integer.valueOf(nS.substring(0, 1))) + " " 
				+ THOUSAND + " "
				+ integerToWordRecursive(Integer.valueOf(nS.substring(1))) + " " ;
		
		if (nLenght == 5)
			return integerToWordRecursive(Integer.valueOf(nS.substring(0, 2)))
				+ THOUSAND + " "
				+ integerToWordRecursive(Integer.valueOf(nS.substring(2))) + " " ;
		
		if (nLenght == 6)
			return integerToWordRecursive(Integer.valueOf(nS.substring(0, 3)))
				+ THOUSAND + " "
				+ integerToWordRecursive(Integer.valueOf(nS.substring(3))) + " " ;
		
		if (nLenght == 7)
			return numberUnderTwentyMap.get(Integer.valueOf(nS.substring(0, 1))) + " " 
				+ MILLION + " "
				+ integerToWordRecursive(Integer.valueOf(nS.substring(1))) + " " ;
		
		if (nLenght == 8)
			return integerToWordRecursive(Integer.valueOf(nS.substring(0, 2)))
				+ MILLION + " "
				+ integerToWordRecursive(Integer.valueOf(nS.substring(2))) + " " ;
		
		if (nLenght == 9)
			return integerToWordRecursive(Integer.valueOf(nS.substring(0, 3))).trim() + " "
				+ MILLION + " "
				+ integerToWordRecursive(Integer.valueOf(nS.substring(3))) + " " ;
		
		if (nLenght == 10)
			return numberUnderTwentyMap.get(Integer.valueOf(nS.substring(0, 1))) + " " 
				+ BILLION + " "
				+ integerToWordRecursive(Integer.valueOf(nS.substring(1)));
		
		return "";
	}

}
