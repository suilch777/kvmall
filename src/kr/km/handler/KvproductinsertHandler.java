package kr.km.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.km.controller.CommandHandler;
import kr.km.dao.kvproductDao;
import kr.km.model.Kvproduct;
import kr.km.util.MySqlSessionFactory;







public class KvproductinsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/spmsWriterForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
		
			
			String pcode = req.getParameter("pcode");
			String pname = req.getParameter("pname");
			String pcontent = req.getParameter("pcontent");
			String sPrice = req.getParameter("price");
			int price = Integer.parseInt(sPrice);
			String sDcprice = req.getParameter("dcprice");
			int dcprice =Integer.parseInt(sDcprice);
			String color = req.getParameter("color");
			String sSize = req.getParameter("size");
			int size =Integer.parseInt(sSize);
			String pic = req.getParameter("pic");
			String sStock = req.getParameter("stock");
			int stock =Integer.parseInt(sStock);
					
			
			//User user = (User)req.getSession().getAttribute("Auth");
			
			Kvproduct kvproduct = new Kvproduct();
			
			kvproduct.setPcode(pcode);
			kvproduct.setPname(pname);
			kvproduct.setPcontent(pcontent);
			kvproduct.setPrice(price);
			kvproduct.setDcprice(dcprice);
			kvproduct.setColor(color);
			kvproduct.setSize(size);
			kvproduct.setPic(pic);
			kvproduct.setStock(stock);
			
			
						
			SqlSession sqlSession = null;
			
			try {
				sqlSession = MySqlSessionFactory.openSession();
				
				kvproductDao dao = sqlSession.getMapper(kvproductDao.class);
				dao.insertkvproduct(kvproduct);				
				
				System.out.println(kvproduct);
				
				sqlSession.commit();
				
				res.sendRedirect(req.getContextPath()+ "/list.do");
				return null;//forward막힘
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			
		}
		return null;
	}

}
