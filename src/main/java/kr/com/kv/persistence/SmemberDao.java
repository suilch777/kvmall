package kr.com.kv.persistence;

import java.util.List;
import kr.com.kv.domain.SmemberVO;

public interface SmemberDao {
	public String getTime();
	public SmemberVO selectMember(String userid);
	public List<SmemberVO> selectAll();
	public void update(SmemberVO vo);	
	public void sregister(SmemberVO vo)throws Exception;
	public void remove(String smid);
	public int idCheck(String smid);
	public SmemberVO selectsMemberByIdAndPw(String userid, String userpw);
	

}
