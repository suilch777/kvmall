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
import kr.com.kv.domain.CmemberVO;
import kr.com.kv.domain.SalelistVO;
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
		
		/*CartVO dbcrt = service.selectcartByIdAndPcode(crt.getCmid(), crt.getPcode());
		
			logger.info("-------- registerPOST, dbcrt= "+dbcrt);
		
		if(dbcrt == null) {
					
		 return service.register(crt);
		}else {
			logger.info("registerPOST ...... cart register fail, duplication");
			return 1;
		}
		*/
		return service.register(crt);
	}
	
	@RequestMapping(value="saleregister", method= RequestMethod.POST)
	@ResponseBody
	public int saleregister(SalelistVO slt, HttpServletRequest request,HttpServletResponse response) throws Exception{
		
				
		logger.info("------------- saleregisterPOST");	
				
    return	service.saleregister(slt);
				
	}
	
	@RequestMapping(value="cartlist", method=RequestMethod.GET)
	 public void cartlist( String cmid,Model model ) throws Exception {
	
		logger.info("------------ cartlist");
		
		List<CartVO> crt  = service.cartlist(cmid);
		model.addAttribute("crt", crt);
		
		logger.info("------------ cartlist:"+crt);
	
		
	}

	@RequestMapping(value="salelist", method=RequestMethod.GET)
	 public void salelist( String smid,Model model, CmemberVO cmv)throws Exception {
	
		logger.info("------------ salelist");
		
		List<SalelistVO> slist  = service.salelist(smid);
		
		
		model.addAttribute("slist", slist);
		
		
		logger.info("------------ stlist:"+slist);
		
		
	
		
	}

}
		
	


