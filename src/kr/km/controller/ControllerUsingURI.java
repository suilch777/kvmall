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
			String command = (String) keyIter.next(); // key�? 추출 /simple.do
			String handlerClassName = prop.getProperty(command); //key?�� ?��?��?��?�� �? : mvc.simple.SimpleHandler
			Class<?> handlerClass;
			try {				
				handlerClass = Class.forName(handlerClassName); //string?��?��?��?�� ?��?��?���? class?�� ?��?��
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance(); //new :메모리에 ?���?				
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
		String command = req.getRequestURI();// 주소�? ?��?��?�� : /MVCProject/simple.do
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












