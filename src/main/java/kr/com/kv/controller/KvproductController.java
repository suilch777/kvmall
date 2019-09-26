package kr.com.kv.controller;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		logger.info("------------- registerPOST kvp="+kvp);
		
		service.register(kvp);		
						
		}	
		
				//jsp가 아니라 controller로 감
		//리다이렉트 : 브라우저에 돌아갈때 /board/listAll주소로 바로 이동하라고 처리하는 것임
		//          브라우저가 화면을 그리기 전에 바로 http://localhost:8080/ex01/board/ListAll로 이동하게 됨
		
		return "redirect:listAll";
		
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
		model.addAttribute("kvp", vo);
		
	}
	
	
}