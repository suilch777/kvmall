package kr.com.kv.service;

import java.util.List;

import kr.com.kv.domain.CartVO;

public interface SaleService {
	
	public int register(CartVO crt)throws Exception ;

	public int saleregister(CartVO crt);

	public List<CartVO> cartlist(CartVO crt);

}
