package kr.com.kv.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.com.kv.domain.LoginDTO;
import kr.com.kv.domain.MemberVO;
import kr.com.kv.service.MemberService;



@RequestMapping("/auth")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginGET() {
		logger.info("-------- login GET");
	}
	
	@RequestMapping(value="loginPost", method=RequestMethod.POST)
	public String loginPOST(LoginDTO member, Model model, HttpSession session) {
		logger.info("-------- login POST,"+member);
		
		MemberVO dbMember = service.selectMemberByIdAndPw(member.getUserid(), member.getUserpw());
		
		logger.info("-------- login POST, dbMember= "+dbMember);
		
		if(dbMember == null) {
			logger.info("loginPOST ...... login fail, not member");
			return "auth/login";
		}
		else {
						
			
		LoginDTO dto = new LoginDTO();
		dto.setUserid(dbMember.getMemberid());
		dto.setUsername(dbMember.getName());
		model.addAttribute("loginDTO", dto);
		
		
		session.setAttribute("Auther", "model");
		
		logger.info("-------- login POST, model= "+model);
		
		return "product/listAll";
	}
}
}




