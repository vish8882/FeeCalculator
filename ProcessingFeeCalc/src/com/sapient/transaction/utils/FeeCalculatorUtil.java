package com.sapient.transaction.utils;

public class FeeCalculatorUtil {

	public static boolean getPriority(String priority) {
		return priority.equals("Y");
	}
	
	public static String getPriorityString(boolean priority) {
		return priority ? "Y" : "N";
	}
}
