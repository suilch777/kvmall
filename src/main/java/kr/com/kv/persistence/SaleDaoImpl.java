package kr.com.kv.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.kv.domain.CartVO;

@Repository
public class SaleDaoImpl implements SaleDao {
	private static final String namespace = "kr.com.kv.mappers.SaleMapper";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int register(CartVO crt) throws Exception {
		return sqlSession.insert(namespace  + ".register", crt);
	}
		
	@Override
	public int saleregister(CartVO crt) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".saleregister",crt);
	}
	
	@Override
	public CartVO cartlist(String cmember) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".cartlist", cmember);
	}

	@Override
	public CartVO selectcartByIdAndPcode(String cmid, String pcode) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmid", cmid);
		map.put("pcode", pcode);
				
		return sqlSession.selectOne(namespace+".selectcartByIdAndPcode",map);
	}
}
