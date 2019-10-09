package kr.com.kv.persistence;


import kr.com.kv.domain.CartVO;


public interface SaleDao {
				
	public int register(CartVO crt)throws Exception;

	public int saleregister(CartVO crt);

	public CartVO cartlist(String cmember);

	public	CartVO selectcartByIdAndPcode(String cmid, String pcode);

	
	
	

}
