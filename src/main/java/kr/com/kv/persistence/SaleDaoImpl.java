package kr.com.kv.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.kv.domain.CartVO;
import kr.com.kv.domain.SalelistVO;

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
	public int saleregister(SalelistVO slt) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".saleregister",slt);
	}
	
	@Override
	public List<CartVO> cartlist(String cmember) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".cartlist", cmember);
	}

	@Override
	public CartVO selectcartByIdAndPcode(String cmid, String pcode) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cmid", cmid);
		map.put("pcode", pcode);
				
		return sqlSession.selectOne(namespace+".selectcartByIdAndPcode",map);
	}

	@Override
	public List<SalelistVO> salelist(String smid) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".salelist", smid);
	}
}
