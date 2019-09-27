package kr.com.kv.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.omg.CORBA.DynAnyPackage.Invalid;
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

	private String msg;
	
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
	}





