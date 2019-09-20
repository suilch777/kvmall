package kr.km.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;



import kr.km.controller.CommandHandler;
import kr.km.dao.MemberDao;
import kr.km.model.Member;
import kr.km.util.MySqlSessionFactory;


public class MemberPwdHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String id = req.getParameter("${Auth.id");
		System.out.println(id);
		SqlSession sqlSession = null;

		if (req.getMethod().equalsIgnoreCase("get")) {

			sqlSession = MySqlSessionFactory.openSession();
			MemberDao dao = sqlSession.getMapper(MemberDao.class);

			Member member = dao.selectById(id);
			req.setAttribute("member", member);

			return "/WEB-INF/view/spmsUpdate.jsp";
		}

		else if (req.getMethod().equalsIgnoreCase("post")) {

			System.out.println("spmsÍ∞íÌôï?ù∏");
		}
		return null;
	}

}

			
