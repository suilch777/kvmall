package kr.com.kv.persistence;


import java.util.List;

import kr.com.kv.domain.CartVO;
import kr.com.kv.domain.SalelistVO;


public interface SaleDao {
				
	public int register(CartVO crt)throws Exception;
	
	public List<CartVO> cartlist(String cmember);

	public	CartVO selectcartByIdAndPcode(String cmid, String pcode);

	public int saleregister(SalelistVO slt);

	
	
	

}
