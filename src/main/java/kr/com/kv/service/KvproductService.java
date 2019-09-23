package kr.com.kv.service;

import java.util.List;

import kr.com.kv.domain.KvproductVO;


public interface KvproductService {
	
	public void register(KvproductVO kvp) throws Exception;

	public List<KvproductVO> listAll()throws Exception;

}
