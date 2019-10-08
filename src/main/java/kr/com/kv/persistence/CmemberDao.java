package kr.com.kv.persistence;

import java.util.List;

import kr.com.kv.domain.CmemberVO;







public interface CmemberDao {
	public String getTime();
	public CmemberVO selectMember(String userid);
	public List<CmemberVO> selectAll();
	public void update(CmemberVO vo);	
	public CmemberVO selectcMemberByIdAndPw(String userid, String userpw);
	public void register(CmemberVO vo)throws Exception;
	public void remove(String memberid);
	public int idCheck(String memberid);
}
