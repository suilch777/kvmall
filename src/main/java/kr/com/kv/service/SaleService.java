package kr.com.kv.service;

import kr.com.kv.domain.CartVO;


public interface SaleService {
	
	public int register(CartVO crt)throws Exception ;
	public int saleregister(CartVO crt);
	CartVO cartlist(String cmember) throws Exception;
	public CartVO selectcartByIdAndPcode(String cmid, String pcode);
	
}
