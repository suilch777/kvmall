package kr.com.kv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.com.kv.domain.CmemberVO;

import kr.com.kv.persistence.CmemberDao;







@Service
public class CmemberServiceImpl implements CmemberService {
	
	@Autowired
	CmemberDao dao;
	
	@Override
	public String getTime() {
		
		return dao.getTime();
	}
	
		
	@Override
	public CmemberVO selectMemberByIdAndPw(String userid, String userpw) {
		// TODO Auto-generated method stub
		return dao.selectMemberByIdAndPw(userid, userpw);
	}

	@Override
	public void register(CmemberVO vo) throws Exception {
		dao.register(vo);
		
	}


	@Override
	public CmemberVO readMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CmemberVO> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}


	@Override
	public CmemberVO read(String memberid) {
		// TODO Auto-generated method stub
		return dao.selectMember(memberid);
	}


	@Override
	public void remove(String memberid) {
		dao.remove(memberid);
		
	}


	@Override
	public void modify(CmemberVO member) {
		dao.update(member);
		
	}


	@Override
	public int idCheck(String memberid) {
		
		
		return dao.idCheck(memberid);
	}

}
