package kr.com.kv;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import kr.com.kv.domain.KvproductVO;
import kr.com.kv.persistence.kvproductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class KvproductDaoTest {
	
	@Autowired
	kvproductDao dao;
	
	
	@Test
	public  List<KvproductVO> listAll()throws Exception {
		List<KvproductVO> list = dao.listAll();
		for(KvproductVO vo :list) {
			System.out.println(vo);
		}
		
		return list;
		
	}

}
