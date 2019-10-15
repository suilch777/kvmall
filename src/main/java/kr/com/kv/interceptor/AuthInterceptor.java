package kr.com.kv.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		/*//======================================================
		
		
		        boolean result = false;
		         
		        String webRoot = request.getContextPath();
		         
		        try {
		            logger.info("======= call /sessionIntercepter start =======");     
		             
		            //이동하는 url이 예외url 일경우          
		           if(excludeUrl(request)){
		                logger.info("======= call /sessionIntercepter url is no session check =======");       
		                result =  true;
		            }else{
		                //세션값이 널일경우
		                if(request.getAttribute("Auther") == null ){
		                     
		                    //Ajax 콜인지 아닌지 판단
		                    if(isAjaxRequest(request)){
		                        logger.info("======= call /sessionIntercepter session is null =======");
		                        response.sendError(400);
		                        return false;
		                    }else{ // Ajax 콜이 아닐경우 login페이지로 이동.
		                         
		                        response.sendRedirect(webRoot + "Auth/login");  
		                        result =  false;
		                    }
		                     
		                }else{
		                    logger.info("======= call /sessionIntercepter session is not null =======");   
		                    result =  true;
		                }
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		            System.out.println(e.getMessage());
	           
		            return false;
		        }
		        //널이 아니면 정상적으로 컨트롤러 호출
		        logger.info("======= call /sessionIntercepter session is not null =======");   
		        return result;
		    }
		     
		    
		    
		     
		    private boolean isAjaxRequest(HttpServletRequest req) {
		        String ajaxHeader = "AJAX";
		        logger.info("======= call /sessionIntercepter req.getHeader(ajaxHeader) : " + req.getHeader(ajaxHeader) + "=======");
		        String header = req.getHeader("AJAX");
		        if ("true".equals(header)){
		         return true;
		        }else{
		         return false;
		        }

		    }
		
		}
		 


		
		
		
		//=================================================================
		*/
		
		
		logger.info("AuthInterceptor  preHandler ...........");
		HttpSession session = request.getSession();
			
		if(session.getAttribute("Auther") == null) {//로그인 안된 상태
			logger.info("cuurent user is not login.........");
			saveDest(request);// 원래의 목적지와 매개변수를 저장함	
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return false;//controller 진입을 막음
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	private void saveDest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		
		if(query == null || query.equals("null")) {
			query ="";
		}else {
			query = "?" + query;
		}
		
		if(request.getMethod().equalsIgnoreCase("get")) {
			logger.info("dest : " + uri+query);
			request.getSession().setAttribute("dest", uri+query);
		}
	}
}
	











