package kr.com.kv.controller;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.com.kv.domain.CmemberVO;
import kr.com.kv.domain.SmemberVO;
import kr.com.kv.service.CmemberService;
import kr.com.kv.service.SmemberService;



@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	CmemberService service;
	@Autowired
	SmemberService sservice;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String registerGET() {
		logger.info("------------- registerGET");	
		
		return "member/joinForm";
		
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String sregisterPOST(CmemberVO cm) throws Exception {
		logger.info("------------- registerPOST");	
		logger.info(cm.toString());
		
		service.register(cm);
		//jsp가 아니라 controller로 감
		//리다이렉트 : 브라우저에 돌아갈때 /board/listAll주소로 바로 이동하라고 처리하는 것임
		//          브라우저가 화면을 그리기 전에 바로 http://localhost:8080/ex01/board/ListAll로 이동하게 됨
		
		return "redirect:/product/listAll"; 
	}
	// Smember controller ====================
	
	@RequestMapping(value="sregister", method=RequestMethod.GET)
	public String sregisterGET() {
		logger.info("------------- sregisterGET");	
		
		return "member/sjoinForm";
		
	}
	
	@RequestMapping(value="sregister", method=RequestMethod.POST)
	public String registerPOST(SmemberVO sm) throws Exception {
		logger.info("------------- sregisterPOST");	
		logger.info(sm.toString());
		
		sservice.sregister(sm);
		//jsp가 아니라 controller로 감
		//리다이렉트 : 브라우저에 돌아갈때 /board/listAll주소로 바로 이동하라고 처리하는 것임
		//          브라우저가 화면을 그리기 전에 바로 http://localhost:8080/ex01/board/ListAll로 이동하게 됨
		
		return "redirect:/product/listAll"; 
	}
	
	//board/listAll
	@RequestMapping(value="memberList", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("------------ listAll");
		
		List<CmemberVO> list = service.selectAll();
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping(value="read", method=RequestMethod.GET)
	public void read(String memberid, Model model) throws Exception {
		logger.info("-------------- read, bno="+memberid);
		CmemberVO member = service.read(memberid);
		model.addAttribute("member", member);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(String memberid) throws Exception{
		service.remove(memberid
				);
		return "redirect:/member/listAll";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(String memberid, Model model) throws Exception{
		CmemberVO member = service.read(memberid);
		model.addAttribute("memebr", member);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(CmemberVO member) throws Exception{
		service.modify(member);		
		return "redirect:/member/listAll";
	}
	
	// 회원 확인
		@ResponseBody
		@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
		public String postIdCheck(String userid) throws Exception {
			 logger.info("post memberid=" + userid );	 
			
			 int res = service.idCheck(userid);
		
		 logger.info("post idCheck=" + res );
		 		
		 if(res>0) {
			 return "{\"cnt\": 1}";
		 } else {
		
		 return "{\"cnt\":0}";
	       
	    }
			
		}
	
}












