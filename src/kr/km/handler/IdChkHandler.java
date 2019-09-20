package kr.km.handler;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;

import kr.km.controller.CommandHandler;
import kr.km.dao.MemberDao;
import kr.km.model.Member;
import kr.km.util.MySqlSessionFactory;

public class IdChkHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/joinForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {

			String id = req.getParameter("userid");
			System.out.println(id);

			SqlSession sqlSession = null;

			try {
				sqlSession = MySqlSessionFactory.openSession();
				MemberDao dao = sqlSession.getMapper(MemberDao.class);

				Member member = new Member();
				member.setMemberid(id);

				Member dbMember = dao.selectById(id);
				if (dbMember != null) { // idë¥? ?‚¬?š©?•˜?Š” userê°? ?ˆ?Œ
					System.out.println("duplicated");
					Map<String, Object> map = new HashMap<>();
					map.put("key1", "inuse");
					

					ObjectMapper om = new ObjectMapper();
					// {key1:test,key2:3}
					// [{article_no:111, writer_name:?‘?„±?,}]
					String json = om.writeValueAsString(map);// map?— ?“¤?—ˆ?Š” ê°’ì„ json String?œ¼ë¡? ë³??™˜?•´ì¤?
					// html - text/html; charset=UTF-8
					// xml - text/xml; charset=UTF-8
					// json - application/json;charset=utf-8
					res.setContentType("application/json;charset=utf-8");
					PrintWriter out = res.getWriter();
					out.print(json);
					out.flush();// ë¸Œë¼?š°??ë¡? ?‚˜ê°?
				}else {
					Map<String, Object> map = new HashMap<>();
					map.put("key1", "usable");
					

					ObjectMapper om = new ObjectMapper();
					// {key1:test,key2:3}
					// [{article_no:111, writer_name:?‘?„±?,}]
					String json = om.writeValueAsString(map);// map?— ?“¤?—ˆ?Š” ê°’ì„ json String?œ¼ë¡? ë³??™˜?•´ì¤?
					// html - text/html; charset=UTF-8
					// xml - text/xml; charset=UTF-8
					// json - application/json;charset=utf-8
					res.setContentType("application/json;charset=utf-8");
					PrintWriter out = res.getWriter();
					out.print(json);
					out.flush();// ë¸Œë¼?š°??ë¡? ?‚˜ê°?
					
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
