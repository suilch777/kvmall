package kr.com.kv.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.com.kv.domain.CartVO;
import kr.com.kv.domain.KvproductVO;
import kr.com.kv.service.SaleService;

@Controller
@RequestMapping("/sale/*")
public class  SaleController {
	private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

	@Autowired
	SaleService service;

	
	@RequestMapping(value="register", method= RequestMethod.POST)
	@ResponseBody
	public int register(CartVO crt, HttpServletRequest request,HttpServletResponse response) throws Exception{
		/*CartVO cVo = new CartVO();
		cVo.setRmemberid(request.getParameter("rmemberid"));
		KvproductVO pname =  new KvproductVO();
		pname.setPname(request.getParameter("pname"));
		cVo.setPname(pname);  */
				
		logger.info("------------- registerPOST");	
		logger.info("------------- registerPOST crt="+crt);
				
		int result = service.register(crt);
		
		return result;
		
	}
	
	@RequestMapping(value="saleregister", method= RequestMethod.POST)
	@ResponseBody
	public int saleregister(CartVO crt, HttpServletRequest request,HttpServletResponse response) throws Exception{
		/*CartVO cVo = new CartVO();
		cVo.setRmemberid(request.getParameter("rmemberid"));
		KvproductVO pname =  new KvproductVO();
		pname.setPname(request.getParameter("pname"));
		cVo.setPname(pname);  */
				
		logger.info("------------- saleregisterPOST");	
		logger.info("------------- saleregisterPOST crt="+crt);
				
		int res = service.saleregister(crt);
		
		return res;
		
	}
	
	@RequestMapping(value="cartlist", method=RequestMethod.GET)
	public void cartlist(Model model, CartVO cmid) {
	
		logger.info("------------ cartlist");
		
		List<CartVO> list  = service.cartlist(cmid);
		model.addAttribute("list", list);
		
		logger.info("------------ cartlist"+list);
		
	}


}
		
	


