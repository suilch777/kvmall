package kr.km.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.km.controller.CommandHandler;
import kr.km.dao.MemberDao;
import kr.km.model.Member;
import kr.km.util.MySqlSessionFactory;


public class MemberIdChkHandlerold implements CommandHandler {

	private String id;

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/joinForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {

			//req.setCharacterEncoding("utf-8");
			String id = req.getParameter("userid");

			System.out.println(id);

			SqlSession sqlSession = null;

			try {
				sqlSession = MySqlSessionFactory.openSession();
				MemberDao dao = sqlSession.getMapper(MemberDao.class);

				Member dbMember = dao.selectById(id);
				if (dbMember != null) { // idÎ•? ?Ç¨?ö©?ïò?äî userÍ∞? ?ûà?ùå
					System.out.println("duplicated");
					req.setAttribute("duplicatedId", true);
					return "/WEB-INF/view/changePwdForm.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
		}
		return null;

	}
}
