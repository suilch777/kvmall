package kr.com.kv.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.kv.domain.CmemberVO;
import kr.com.kv.domain.MemberVO;



@Repository
public class CmemberDaoImpl implements CmemberDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "kr.com.kv.mappers.MemberMapper";

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespace+".getTime");
	}
	
	@Override
	public CmemberVO selectMember(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectMember", userid);
	}

	@Override
	public List<CmemberVO> selectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectAll");
	}

	@Override
	public void update(CmemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".update", vo);
	}

	

	@Override
	public CmemberVO selectcMemberByIdAndPw(String userid, String userpw) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace+".selectcMemberByIdAndPw",map );
	}

	@Override
	public void register(CmemberVO vo) throws Exception {
		sqlSession.insert(namespace+".register", vo);
		
	}

	@Override
	public void remove(String memberid) {
		sqlSession.delete(namespace+".remove", memberid);
		
	}

	@Override
	public int idCheck(String memberid) {
		sqlSession.selectOne(namespace+".idCheck", memberid);
		return sqlSession.selectOne(namespace+".idCheck", memberid);
		
	}

}
