package kr.km.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory == null) {
			InputStream  inputStream;
			
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}
