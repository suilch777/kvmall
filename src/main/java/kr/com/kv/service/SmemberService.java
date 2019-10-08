package kr.com.kv.service;

import java.util.List;
import kr.com.kv.domain.SmemberVO;

public interface SmemberService {
	public String getTime();
	public void sregister(SmemberVO vo) throws Exception;
	public SmemberVO readMember(String userid);
	public List<SmemberVO> selectAll();
	public SmemberVO read(String memberid);
	public void remove(String memberid);
	public void modify(SmemberVO memberid);
	public int idCheck(String memberid);
	public SmemberVO selectsMemberByIdAndPw(String userid, String userpw);
	
}
