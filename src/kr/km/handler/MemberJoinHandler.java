package kr.km.handler;


import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.km.controller.CommandHandler;
import kr.km.dao.MemberDao;
import kr.km.model.Member;
import kr.km.util.MySqlSessionFactory;





public class MemberJoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/joinForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			System.out.println("login");
			
			req.setCharacterEncoding("utf-8");
						
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			SqlSession sqlSession = null;	
			
			try {
				sqlSession = MySqlSessionFactory.openSession();
				MemberDao dao = sqlSession.getMapper(MemberDao.class);
				
				Member member = new Member();
				member.setMemberid(id);
				member.setName(name);
				member.setPassword(password);
				member.setTel(tel);
				member.setEmail(email);
				member.setRegdate( new Date() );
				
				Member dbMember = dao.selectById(id);
				if(dbMember != null) { //id�? ?��?��?��?�� user�? ?��?��
				System.out.println("duplicated");
					req.setAttribute("duplicatedId", true);
					return "/WEB-INF/view/joinForm.jsp";
				}
					
				
				dao.insert(member);
				System.out.println(member);
			
				sqlSession.commit();
				
				return "/WEB-INF/view/inTopmenu.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
				
			}			
			
		}
		return null;
	
	}

}