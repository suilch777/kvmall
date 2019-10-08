package kr.com.kv.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.com.kv.domain.SmemberVO;



@Repository
public class SmemberDaoImpl implements SmemberDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "kr.com.kv.mappers.MemberMapper";

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespace+".getTime");
	}
	
	@Override
	public SmemberVO selectMember(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectMember", userid);
	}

	@Override
	public List<SmemberVO> selectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectAll");
	}

	@Override
	public void update(SmemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".update", vo);
	}

	

	@Override
	public SmemberVO selectsMemberByIdAndPw(String userid, String userpw) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace+".selectsMemberByIdAndPw",map );
	}

	@Override
	public void sregister(SmemberVO vo) throws Exception {
		sqlSession.insert(namespace+".sregister", vo);
		
	}

	@Override
	public void remove(String smid) {
		sqlSession.delete(namespace+".remove", smid);
		
	}

	@Override
	public int idCheck(String smid) {
		sqlSession.selectOne(namespace+".idCheck", smid);
		return sqlSession.selectOne(smid);
		
	}

}
