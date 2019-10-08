package kr.com.kv.persistence;

import java.util.List;

import kr.com.kv.domain.CartVO;


public interface SaleDao {
	
	
	public List<SaleDao> listAll()throws Exception;

	public SaleDao read(String memberid)throws Exception;

	public int register(CartVO crt)throws Exception;

	public void register(String memberid);

	public int saleregister(CartVO crt);

	public List<CartVO> cartlist(CartVO crt);
	

}
