package servlet.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 利用ServletContext对象获取context域中的数据，以及获取Web应用的初始化参数
 * @author myfour
 *
 */
public class ServletContextDemo2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object data=this.getServletContext().getAttribute("data");
		resp.getWriter().println("data="+data);
		resp.getWriter().println("WEB init param:"+this.getServletContext().getInitParameter("driver"));
	
	}
}
