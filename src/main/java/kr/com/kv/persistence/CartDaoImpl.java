package kr.com.kv.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.kv.domain.CartVO;

@Repository
public class CartDaoImpl implements CartDao {
	private static final String namespace = "kr.com.kv.mappers.CartMapper";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<CartDao> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDao read(String memberid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(CartVO crt) throws Exception {
		sqlSession.insert(namespace + ".register",crt);

	}

}
