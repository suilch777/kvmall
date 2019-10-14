package kr.com.kv.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.com.kv.domain.CmemberVO;
import kr.com.kv.domain.LoginDTO;
import kr.com.kv.domain.SmemberVO;
import kr.com.kv.domain.sLoginDTO;
import kr.com.kv.service.CmemberService;
import kr.com.kv.service.SmemberService;



@RequestMapping("/auth")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	CmemberService service;
	
	@Autowired
	SmemberService sservice;

	private String msg;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginGET() {
		logger.info("-------- login GET");
	
	}
	
	@RequestMapping(value="loginPost", method=RequestMethod.POST)
	public String loginPOST(LoginDTO member, Model model, HttpSession session) {
		logger.info("-------- login POST,"+member);
		
		CmemberVO dbMember = service.selectcMemberByIdAndPw(member.getUserid(), member.getUserpw());
		
		logger.info("-------- login POST, dbMember= "+dbMember);
		
		if(dbMember == null) {
			logger.info("loginPOST ...... login fail, not member");
		
			return "auth/loginPost";
			
		}
		else {
						
			
		sLoginDTO dto = new sLoginDTO();
		dto.setUserid(dbMember.getCmid());
		dto.setUsername(dbMember.getName());
		model.addAttribute("loginDTO", dto);
		
		
		session.setAttribute("Auther", dto);
		
		logger.info("-------- login POST, model= "+model);
		
		return "redirect:/product/listAll";
	}
}
	
	
	@RequestMapping(value="slogin", method=RequestMethod.GET)
	public String sloginGET() {
		logger.info("-------- slogin GET");
		
		return "auth/slogin";
	}
	
	@RequestMapping(value="sloginPost", method=RequestMethod.POST)
	public String sloginPOST(sLoginDTO member, Model model, HttpSession session) {
		logger.info("-------- slogin POST,"+member);
		
		SmemberVO dbMember = sservice.selectsMemberByIdAndPw(member.getUserid(), member.getUserpw());
		
		logger.info("-------- slogin POST, dbMember= "+dbMember);
		
		if(dbMember == null) {
			logger.info("sloginPOST ...... slogin fail, not member");
		
			return "/auth/slogin";
		}
		else {
						
			
		sLoginDTO dto = new sLoginDTO();
		dto.setUserid(dbMember.getSmid());
		dto.setUsername(dbMember.getName());
		model.addAttribute("sloginDTO", dto);
		
		String smid= dto.getUserid();
		
		session.setAttribute("sAuther", dto);
		
		logger.info("-------- slogin POST, model= "+model);
		
		return "redirect:/product/listAll";
	}
}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("-------- logout GET");
		alert(msg);
	     
		session.removeAttribute("Auther");
	        // /페이지로 리다이렉트 시킨다.
	        return "redirect:/product/listAll";
	    }

	private void alert(String string) {
		msg = "로그아웃 하시겠습닜까?";
		
	}
	

@RequestMapping(value="slogout", method=RequestMethod.GET)
public String slogout(HttpSession session) {
	logger.info("-------- logout GET");
	alert(msg);
     
	session.removeAttribute("sAuther");
        // /페이지로 리다이렉트 시킨다.
        return "redirect:/product/listAll";
    }


	
}






