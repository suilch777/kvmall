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
		// TODO Auto-generated method stub
		return dao.register(crt);
	}
	
	@Override
	public CartVO cartlist(String cmember) throws Exception {
		// TODO Auto-generated method stub
		return dao.cartlist(cmember);
	}

	@Override
	public int saleregister(CartVO crt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CartVO selectcartByIdAndPcode(String cmid, String pcode) {
		// TODO Auto-generated method stub
		return dao.selectcartByIdAndPcode(cmid, pcode);
		}
}
