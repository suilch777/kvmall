package kr.com.kv.service;

import java.util.List;

import kr.com.kv.domain.CartVO;
import kr.com.kv.domain.SalelistVO;


public interface SaleService {
	
	public int register(CartVO crt)throws Exception ;
	public int saleregister(SalelistVO slt)throws Exception;
	List<CartVO> cartlist(String cmid) throws Exception;
	public CartVO selectcartByIdAndPcode(String cmid, String pcode);
	List<SalelistVO> salelist(String smid) throws Exception;
	
}
