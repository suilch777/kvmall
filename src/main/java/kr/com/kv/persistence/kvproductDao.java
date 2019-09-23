package kr.com.kv.persistence;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.com.kv.domain.KvproductVO;




public interface kvproductDao {
	
	

	public void register(KvproductVO kvp)throws SQLException;

	public List<KvproductVO> listAll()throws Exception;
	
	

	
}
