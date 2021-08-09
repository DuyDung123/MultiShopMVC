package com.laptrinhjavaweb.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

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
	
	public static String getBaseUrl(HttpServletRequest request) {
	    String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    return scheme + serverName + serverPort + contextPath;
	  }
	
	public static List<String> savefile(HttpSession session, MultipartFile[] files) {
		
		List<String> paths = new ArrayList<String>();
		
		ServletContext context = session.getServletContext();
		
		for(MultipartFile file: files) {
			String uploadPath = "";
			String f = file.getOriginalFilename();
			String[] d = f.split("[.]");
			if(d[d.length-1].equalsIgnoreCase("PNG") ||d[d.length-1].equalsIgnoreCase("jpg") || d[d.length-1].equalsIgnoreCase("jpeg")|| d[d.length-1].equalsIgnoreCase("jpe")) {
				uploadPath = context.getRealPath("/images/");
				try {
					byte[] bytes = file.getBytes();
					Path path = Paths.get(uploadPath + file.getOriginalFilename());
					Files.write(path, bytes);
					paths.add("/images/"+ file.getOriginalFilename());
				} catch (IOException e) {
				}
			}else{
				uploadPath = context.getRealPath("/file/");
				try {
					byte[] bytes = file.getBytes();
					Path path = Paths.get(uploadPath + file.getOriginalFilename());
					Files.write(path, bytes);
					paths.add("/file/" + file.getOriginalFilename());
				} catch (IOException e) {
				}
			}
		}
		return paths;
	}
	
	
	public static String saveFile(HttpSession session, MultipartFile file) {
		
		ServletContext context = session.getServletContext();
		
		String uploadPath = "";
		String f = file.getOriginalFilename();
		String[] d = f.split("[.]");
		if(d[d.length-1].equalsIgnoreCase("PNG") ||d[d.length-1].equalsIgnoreCase("jpg") || d[d.length-1].equalsIgnoreCase("jpeg")|| d[d.length-1].equalsIgnoreCase("jpe")) {
			uploadPath = context.getRealPath("/images/");
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(uploadPath + file.getOriginalFilename());
				Files.write(path, bytes);
				return "/images/"+ file.getOriginalFilename();
			} catch (IOException e) {
				return null;
			}
		}else{
			uploadPath = context.getRealPath("/file/");
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(uploadPath + file.getOriginalFilename());
				Files.write(path, bytes);
				return "/file/" + file.getOriginalFilename();
			} catch (IOException e) {
				return null;
			}
		}	    
	}
}
