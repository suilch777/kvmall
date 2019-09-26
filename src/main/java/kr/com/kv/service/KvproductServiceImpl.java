package kr.com.kv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.com.kv.domain.KvproductVO;
import kr.com.kv.persistence.kvproductDao;

@Service
public class KvproductServiceImpl implements KvproductService {
	
	@Autowired
	kvproductDao dao;

	@Override
	public void register(KvproductVO kvp) throws Exception {
		dao.register(kvp);
		
	}

	@Override
	public List<KvproductVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public KvproductVO read(String pcode) throws Exception {
		KvproductVO vo = dao.read(pcode);
		return null;
	}

	
		
	}


