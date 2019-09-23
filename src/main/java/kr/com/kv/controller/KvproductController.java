package kr.com.kv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kr.com.kv.domain.KvproductVO;
import kr.com.kv.service.KvproductService;

@Controller
@RequestMapping("/product/*")
public class KvproductController {
	private static final Logger logger = LoggerFactory.getLogger(KvproductController.class);
	
	@Autowired
	KvproductService service;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String registerGET() {
		logger.info("------------- registerGET");	
		
		return "product/productReg";
}
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerPOST(KvproductVO kvp) throws Exception {
		logger.info("------------- registerPOST");	
		logger.info(kvp.toString());
		
		service.register(kvp);
		//jsp가 아니라 controller로 감
		//리다이렉트 : 브라우저에 돌아갈때 /board/listAll주소로 바로 이동하라고 처리하는 것임
		//          브라우저가 화면을 그리기 전에 바로 http://localhost:8080/ex01/board/ListAll로 이동하게 됨
		
		return "redirect:/product/kvTopmenu"; 
	}
	
	@RequestMapping(value="listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("------------ listAll");
		
		List<KvproductVO> list = service.listAll();
		model.addAttribute("list", list);
		
		logger.info("------------ listAll"+list);
		
	}
	
	
}