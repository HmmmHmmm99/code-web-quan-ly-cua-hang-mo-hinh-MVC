package com.example.demo.service.amazonService;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ItemSale;

public interface AmazonService {
	void uploadFile(MultipartFile multipartFile, ItemSale itemSale);
}
