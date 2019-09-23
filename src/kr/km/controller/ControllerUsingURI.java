package kr.km.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerUsingURI extends HttpServlet {

	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");// /WEB-INF/commandHandler.properties
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		
		try(FileReader fis = new FileReader(configFilePath)){
			prop.load(fis);
		}catch (Exception e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		// /simple.do=mvc.simple.SimpleHandler
		while(keyIter.hasNext()) {
			String command = (String) keyIter.next(); // keyÎ•? Ï∂îÏ∂ú /simple.do
			String handlerClassName = prop.getProperty(command); //key?óê ?ï¥?ãπ?ïò?äî Í∞? : mvc.simple.SimpleHandler
			Class<?> handlerClass;
			try {				
				handlerClass = Class.forName(handlerClassName); //string?êò?ñ¥?ûà?äî ?Å¥?ûò?ä§Î•? class?ôî ?ãú?Ç¥
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance(); //new :Î©îÎ™®Î¶¨Ïóê ?ò¨Î¶?				
				commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}	
	
	private void process(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		String command = req.getRequestURI();// Ï£ºÏÜåÍ∞? ?Ñò?ò§?ò¥ : /MVCProject/simple.do
		if(command.indexOf(req.getContextPath()) == 0) { // /MVCProject
			command = command.substring(req.getContextPath().length()); // /simple.do
		}
		
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null) {
			handler = new NullHandler();
		}
		
		String viewPage = null;		
		try {
			viewPage = handler.process(req, res); //simpleForm.jsp
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}		
	}
	
}












