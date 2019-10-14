package kr.com.kv.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.com.kv.domain.KvproductVO;
import kr.com.kv.service.KvproductService;
import kr.com.kv.util.UploadFileUtils;

@Controller
@RequestMapping("/product/*")
public class KvproductController<HttpHttpServletRequest> {
	private static final Logger logger = LoggerFactory.getLogger(KvproductController.class);
	
	@Autowired
	KvproductService service;
	
	private String innerUploadPath = "resources/upload";
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public void registerGET() {
		logger.info("------------- registerGET");	
		
		
}
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerPOST(KvproductVO kvp,List<MultipartFile> imgFiles)throws Exception {
		logger.info("------------- registerPOST");	
		logger.info(kvp.toString());
		
				
		ArrayList<String> list = new ArrayList<>();
		for(MultipartFile file :imgFiles) {
		
			logger.info("file name :" + file.getOriginalFilename());
		logger.info("file size :" + file.getSize());	
				
		String savedName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		
		kvp.setPic(savedName);
		logger.info("------------- registerPOST kvp="+kvp.getPcode());
		
		service.register(kvp);		
						
		}	
		
				//jsp가 아니라 controller로 감
		//리다이렉트 : 브라우저에 돌아갈때 /board/listAll주소로 바로 이동하라고 처리하는 것임
		//          브라우저가 화면을 그리기 전에 바로 http://localhost:8080/ex01/board/ListAll로 이동하게 됨
		
		return "redirect:pRead?= "+ kvp.getPcode();
		
	}
	
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> displayFile(String filename){
		logger.info("-------------- displayFile, filename="+filename);
		String ofn=filename.substring(0,12)+filename.substring(14);
		
		logger.info("-------------- displayFile, ofn="+ofn);
		
		
		String formatName = filename.substring(filename.lastIndexOf(".")+1);//확장자만 뽑아냄
		MediaType mType = null;
		ResponseEntity<byte[]> entity = null;
		
		if(formatName.equalsIgnoreCase("jpg")) {
			mType = MediaType.IMAGE_JPEG;
		}else if(formatName.equalsIgnoreCase("gif")) {
			mType = MediaType.IMAGE_GIF;
		}else if(formatName.equalsIgnoreCase("png")) {
			mType = MediaType.IMAGE_PNG;
		}
		InputStream in = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath+"/"+ofn);
			headers.setContentType(mType);
			
			entity = new ResponseEntity<byte[]>(
												IOUtils.toByteArray(in),
												headers,
												HttpStatus.CREATED
												);		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);			
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return entity;
	}
	
	@RequestMapping(value="listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("------------ listAll");
		
		List<KvproductVO> list = service.listAll();
		model.addAttribute("list", list);
		
		logger.info("------------ listAll"+list);
			
	}
	
	@RequestMapping(value="pRead", method=RequestMethod.GET)
	public void read(String pcode, Model model)throws Exception {
		
		KvproductVO vo = service.read(pcode);
		
		logger.info("-------------- read, pcode="+pcode);
		
		logger.info("-------------- read, vo="+vo);
		
		
		model.addAttribute("kvp", vo);
		
	}
	
	
}