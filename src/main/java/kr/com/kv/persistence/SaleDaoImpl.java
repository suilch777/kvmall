package kr.com.kv.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.kv.domain.CartVO;

@Repository
public class SaleDaoImpl implements SaleDao {
	private static final String namespace = "kr.com.kv.mappers.SaleCartMapper";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<SaleDao> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleDao read(String memberid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int register(CartVO crt) throws Exception {
		return sqlSession.insert(namespace + ".register",crt);

	}

	@Override
	public void register(String memberid) {
		sqlSession.insert(namespace + ".register",memberid);
		
	}

	@Override
	public int saleregister(CartVO crt) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".register",crt);
	}

	@Override
	public List<CartVO> cartlist(CartVO crt) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".cartlist(crt)");
	}

}
