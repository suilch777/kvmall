package kr.com.kv.service;

import java.util.List;

import kr.com.kv.domain.MemberVO;





public interface MemberService {
	public String getTime();
	public void register(MemberVO vo) throws Exception;
	public MemberVO readMember(String userid);
	public MemberVO selectMemberByIdAndPw(String userid, String userpw);
	public List<MemberVO> selectAll();
	public MemberVO read(String memberid);
	public void remove(String memberid);
	public void modify(MemberVO memberid);
	public int idCheck(String memberid);
	
}
