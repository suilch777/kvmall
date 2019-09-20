package kr.km.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.km.controller.CommandHandler;
import kr.km.dao.MemberDao;
import kr.km.model.Member;
import kr.km.model.User;
import kr.km.util.MySqlSessionFactory;





public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/loginForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			System.out.println("login");
			String id = req.getParameter("id");
			String pass = req.getParameter("password");
			
			
			SqlSession sqlSession =null;
			
			try {
				
				sqlSession = MySqlSessionFactory.openSession();
				MemberDao dao = sqlSession.getMapper(MemberDao.class);
				Member member = dao.selectById(id);
				
				//id?�� ?��?��?��?�� ?��?��?�� ?��?���? ?��?��
				if(member == null) { //?��?�� ?��?��
					req.setAttribute("notJoin", true);
					return "/WEB-INF/view/loginForm.jsp";
				}
				//비�?번호�? ?��치하?���? ?
				if(member.getPassword().equals(pass) == false) { //비�?번호 ?��치하�? ?��?��
					req.setAttribute("notMatchPassword", true);
					return "/WEB-INF/view/loginForm.jsp";
				}
				
				//로그?��처리
				HttpSession session = req.getSession();
				User user = new User(id, member.getName());
				session.setAttribute("Auth", user);
				req.setAttribute("login", true);
				
				return "/WEB-INF/view/kvTopmenu.jsp";//?��?���?
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}			
			
		}
		return null;
	}

}
