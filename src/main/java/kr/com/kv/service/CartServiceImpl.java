package kr.com.kv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.com.kv.domain.CartVO;
import kr.com.kv.persistence.CartDao;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao dao;

	
	@Override
	public int register(CartVO crt) throws Exception {
		return dao.register(crt);
		

	}


	@Override
	public int saleregister(CartVO crt) {
		// TODO Auto-generated method stub
		return dao.saleregister(crt);
	}



}
