package com.laptrinhjavaweb.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class CustomUtils {

//	customCode 
	public static String customCode(String s) {
		CustomUtils utils = new CustomUtils();
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		temp = pattern.matcher(temp).replaceAll("");
		temp.replaceAll("đ", "d");
		return utils.removeAccent(temp.replace(" ", "-"));
	}

	public String removeAccent(String name) {
		name.toLowerCase();
		name.trim();
		return name.toLowerCase();
	}
//end customCode
}
