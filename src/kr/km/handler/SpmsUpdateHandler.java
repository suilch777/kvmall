package kr.km.handler;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.SpmsDao;
import kr.yi.spms.model.Spms;
import kr.yi.spms.util.MySqlSessionFactory;

public class SpmsUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String sNo = req.getParameter("no");
		int no = Integer.parseInt(sNo);
		SqlSession sqlSession = null;

		if (req.getMethod().equalsIgnoreCase("get")) {

			sqlSession = MySqlSessionFactory.openSession();
			SpmsDao dao = sqlSession.getMapper(SpmsDao.class);

			Spms spms = dao.selectBySpmsNo(no);
			req.setAttribute("spms", spms);

			return "/WEB-INF/view/spmsUpdate.jsp";
		}

		else if (req.getMethod().equalsIgnoreCase("post")) {

			System.out.println("spms값확인");
			
			String sName = req.getParameter("rsp_name");
			String sContent = req.getParameter("rcontent");
			String sDate = req.getParameter("startdate");
			String sDate2 = req.getParameter("enddate");
			String sStatus = req.getParameter("status");

			

			Spms spms = new Spms();
			
			spms.setSp_no(no);
			spms.setSp_name(sName);
			spms.setContent(sContent);

			
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			spms.setStartdate(date.parse(sDate));

			SimpleDateFormat date2 = new SimpleDateFormat("yyyy-MM-dd");
			spms.setEnddate(date2.parse(sDate2));

			spms.setStatus(sStatus);

			SqlSession sqlSession2 = null;
			System.out.println(spms);  

			try {
				sqlSession2 = MySqlSessionFactory.openSession();

				SpmsDao dao = sqlSession2.getMapper(SpmsDao.class);
				dao.updateSpms(spms);
				
				sqlSession2.commit();

				res.sendRedirect(req.getContextPath() + "/list.do");
				return null;// forward막힘
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession2.close();
			}

		}
		return null;
	}
}