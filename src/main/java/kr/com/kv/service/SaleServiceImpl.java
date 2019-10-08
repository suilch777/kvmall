package kr.com.kv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.com.kv.domain.CartVO;
import kr.com.kv.persistence.SaleDao;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleDao dao;

	
	@Override
	public int register(CartVO crt) throws Exception {
		return dao.register(crt);
		

	}


	@Override
	public int saleregister(CartVO crt) {
		// TODO Auto-generated method stub
		return dao.saleregister(crt);
	}


	@Override
	public List<CartVO> cartlist(CartVO crt) {
		
		return dao.cartlist(crt);
	}



}
