package kr.com.kv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.com.kv.domain.CartVO;
import kr.com.kv.service.CartService;

@Controller
@RequestMapping("/cart/*")
public class CartController<HttpHttpServletRequest> {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartService service;
	
	
	@RequestMapping(value="register", method= RequestMethod.POST)
	public String register(CartVO crt) throws Exception {
		logger.info("------------- registerPOST");	
		
		service.register(crt);
		
		return "redirect:product/listAll ";
		
	}
		
	
}

