package kr.com.kv;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.kv.domain.KvproductVO;
import kr.com.kv.persistence.kvproductDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class kvproductDaoTest {


	@Autowired
	kvproductDao dao;
	
	@Test
	public void test01Register() throws SQLException {
		 KvproductVO kvp = new KvproductVO();
		 kvp.setPcode("p000009");
		 kvp.setPname("겨울옷");
		 kvp.setPcontent("따뜻한 거위털");
		 kvp.setPrice(200000);
		 kvp.setDcprice(100000);
		 kvp.setColor("gray");
		 kvp.setSize(90);
		 
		 kvp.setStock(100);
		 
		 dao.register(kvp);
		 
		 
	}

}
