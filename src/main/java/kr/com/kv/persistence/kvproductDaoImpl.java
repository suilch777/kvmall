package kr.com.kv.persistence;

import java.sql.SQLException;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.kv.domain.KvproductVO;
import kr.com.kv.domain.MemberVO;

@Repository
public class kvproductDaoImpl implements kvproductDao {

private static final String namespace = "kr.com.kv.mappers.KvproductMapper";
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void register(KvproductVO kvp) throws SQLException {
		sqlSession.insert(namespace + ".register",kvp);
	}

	@Override
	public List<KvproductVO> listAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".listAll");
	}

		

}
