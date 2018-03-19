package servlet.study;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 利用ServletConfig对象读取servlet的初始化参数
 * @author myfour
 *
 */
public class ServletConfigDemo1 extends HttpServlet{

	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramVal=this.config.getInitParameter("name");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(paramVal);
		resp.getWriter().print("<hr/>");
		
		Enumeration<String> e=config.getInitParameterNames();
		while(e.hasMoreElements()) {
			String name=e.nextElement();
			String value=config.getInitParameter(name);
			
			resp.getWriter().print(name+"="+value+"<br/>");
			
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
