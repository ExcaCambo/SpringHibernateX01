package com.knongdai.restaurant.services;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.knongdai.restaurant.entities.UploadedFileInfo;

public interface FileUploadService {
	
	/***
	 * Upload to default location
	 */
	public UploadedFileInfo upload(List<MultipartFile> files, String folder);
	
	public UploadedFileInfo upload(MultipartFile file, String folder);
	
	public UploadedFileInfo upload(List<MultipartFile> files, String folder, HttpServletRequest request);
	
	public UploadedFileInfo delete(List<String> file, String folder);
	
	
	
}
