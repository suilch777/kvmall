package kr.com.kv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.com.kv.domain.SmemberVO;
import kr.com.kv.persistence.SmemberDao;

@Service
public class SmemberServiceImpl implements SmemberService {
	
	@Autowired
	SmemberDao dao;
	
	@Override
	public String getTime() {
		
		return dao.getTime();
	}
	
		
	@Override
	public SmemberVO selectsMemberByIdAndPw(String userid, String userpw) {
		// TODO Auto-generated method stub
		return dao.selectsMemberByIdAndPw(userid, userpw);
	}

	@Override
	public void sregister(SmemberVO vo) throws Exception {
		dao.sregister(vo);
		
	}


	@Override
	public SmemberVO readMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<SmemberVO> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}


	@Override
	public SmemberVO read(String smid) {
		// TODO Auto-generated method stub
		return dao.selectMember(smid);
	}


	@Override
	public void remove(String smid) {
		dao.remove(smid);
		
	}


	@Override
	public void modify(SmemberVO smid) {
		dao.update(smid);
		
	}


	@Override
	public int idCheck(String smid) {
		
		
		return dao.idCheck(smid);
	}

}
