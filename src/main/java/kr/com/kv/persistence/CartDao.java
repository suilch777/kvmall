package kr.com.kv.persistence;

import java.util.List;

import kr.com.kv.domain.CartVO;


public interface CartDao {
	
	
	public List<CartDao> listAll()throws Exception;

	public CartDao read(String memberid)throws Exception;

	public void register(CartVO crt)throws Exception;

}
