package com.example.demo.service.amazonService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.example.demo.entity.ItemSale;
import com.example.demo.service.productsale.ItemSaleService;
import com.example.demo.utils.Utils;

@Service
public class AmazonServiceImpl implements AmazonService {

	private AmazonS3 s3Client;
	
	@Autowired
	private ItemSaleService itemSaleService;
	
	@PostConstruct
	private void initializeAmazon() {
		this.s3Client = new AmazonS3Client(new BasicAWSCredentials(Utils.ACCESS_KEY, Utils.SECRET_KEY));
	}
	
	@Override
	public void uploadFile(MultipartFile multipartFile, ItemSale itemSale) {
		String fileUrl = "";
		JSONObject jsonObject = new JSONObject();
		try {
			File file = convertMultipartToFile(multipartFile);
			String fileName = new Date().getTime()+"-"+multipartFile.getOriginalFilename().replace(" ", "_");
			fileUrl = Utils.END_POINT_URL+"/"+Utils.BUCKET_NAME+"/"+fileName;
			s3Client.putObject(new PutObjectRequest(Utils.BUCKET_NAME, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
			itemSale.setPath(fileUrl);
			itemSaleService.save(itemSale);
			/*
			 * jsonObject.put("status", "success"); jsonObject.put("imageUrl", fileUrl);
			 * jsonObject.put("message", "File Uploaded Successfully.");
			 */
		}catch(IOException e) {
			e.printStackTrace();
		}
		
//		return jsonObject.toString();
	}
	
	private File convertMultipartToFile(MultipartFile file) throws IOException{
		File convertFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convertFile);
		fos.write(file.getBytes());
		fos.close();
		return convertFile;	
	}
}
