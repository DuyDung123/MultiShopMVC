package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.laptrinhjavaweb.model.UploadFileResponseModel;
import com.laptrinhjavaweb.utils.CustomUtils;

@Controller(value = "UploadFileAPIOfSysTem")
public class UpLoadFileAPI {
	
	 @PostMapping("/upLoadFile")
	 public @ResponseBody UploadFileResponseModel saveFile( @RequestParam("file") MultipartFile file, HttpSession session) {
		 String path = CustomUtils.saveFile(session, file);
		 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path(path)
	                .toUriString();
		 return new UploadFileResponseModel(path, fileDownloadUri,
	                file.getContentType(), file.getSize());
	 }
	 
	 @PostMapping("/upLoadMultiFile")
	 public @ResponseBody List<UploadFileResponseModel> saveMultiFile( @RequestParam("file") MultipartFile[] files, HttpSession session) {
		 List<UploadFileResponseModel> uploadFileResponseModel = new ArrayList<>();
		 for(MultipartFile file: files) {
			 String path1 = CustomUtils.saveFile(session, file);
			 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path(path1)
		                .toUriString();
			 uploadFileResponseModel.add(new UploadFileResponseModel(path1, fileDownloadUri, file.getContentType(), file.getSize()));
		 }
		 return uploadFileResponseModel;
	 }
}
