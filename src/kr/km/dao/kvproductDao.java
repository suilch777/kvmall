package kr.km.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.km.model.Kvproduct;
import kr.km.model.Member;





public interface kvproductDao {
	
	
	public List<Kvproduct> selectListPage(Map<String, Object> map) throws SQLException;
	public List<Kvproduct> selectList() throws SQLException;
	public void insertkvproduct(Kvproduct kvp)throws SQLException;
	public Kvproduct selectBykvproductNo(int pcode) throws SQLException;
	public void deletekvproduct(int pcode)throws SQLException;
	public List<Kvproduct> selectListPage1(Map<String, Object> map);
	public int selectTotalCount();
	public void updatekvproduct(Kvproduct kvp)throws SQLException;
	public void insert(Kvproduct kvp);
	public Member selectById(Object id);
	
}
