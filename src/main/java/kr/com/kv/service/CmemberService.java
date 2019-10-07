package kr.com.kv.service;

import java.util.List;

import kr.com.kv.domain.CmemberVO;







public interface CmemberService {
	public String getTime();
	public void register(CmemberVO vo) throws Exception;
	public CmemberVO readMember(String userid);
	public CmemberVO selectMemberByIdAndPw(String userid, String userpw);
	public List<CmemberVO> selectAll();
	public CmemberVO read(String memberid);
	public void remove(String memberid);
	public void modify(CmemberVO memberid);
	public int idCheck(String memberid);
	
}
