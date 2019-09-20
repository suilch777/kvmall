package kr.km.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.km.controller.CommandHandler;
import kr.km.dao.MemberDao;
import kr.km.model.Member;
import kr.km.util.MySqlSessionFactory;




public class MemberChangePwdHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String userId = req.getParameter("userid");
		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		

		System.out.println("?òÑ?û¨?Ç¨?ö©?ûê" + userId);
		System.out.println("?òÑ?û¨?ïî?ò∏" + curPwd);

		SqlSession sqlSession = null;
		if (req.getMethod().equalsIgnoreCase("get")) {

			// TODO Auto-generated method stub
			return "/WEB-INF/view/changePwdForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {

			sqlSession = MySqlSessionFactory.openSession();
			MemberDao dao = sqlSession.getMapper(MemberDao.class);

			Member member = dao.selectById(userId);
			req.setAttribute("member", member);

			System.out.println(member.getPassword());
			if (curPwd.equals(member.getPassword())) {
				member.setPassword(newPwd);

				dao.update(member);

				sqlSession.commit();
				return "/WEB-INF/view/changePwdSuccess.jsp";
			} else {

				System.out.println("notmath");
				req.setAttribute("badCurPwd", true);
				return "/WEB-INF/view/changePwdForm.jsp";
			}

		}
		return null;
	}
}