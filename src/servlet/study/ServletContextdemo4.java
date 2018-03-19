package servlet.study;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 读取配置文件
 */
@WebServlet("/servletcontextdemo4")
public class ServletContextdemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextdemo4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		readProperties(response);
		 response.getWriter().println("<hr/>");
		readProperties2(response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void readProperties(HttpServletResponse response) throws IOException {
		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/servlet/study/db2.properties");
		Properties prop=new Properties();
		prop.load(in);
		String driver=prop.getProperty("driver");
		String url=prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		 response.getWriter().println("读取src目录下servlet.study包中的properties配置文件：");
		 response.getWriter().println(MessageFormat.format("driver={0},url={1},username={2},password={3}", driver,url, username, password));
		
	}
	private void readProperties2(HttpServletResponse response) throws IOException {
		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/servlet/config/db3.properties");
		Properties prop=new Properties();
		prop.load(in);
		String driver=prop.getProperty("driver");
		String url=prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		 response.getWriter().println("读取src目录下的properties配置文件：");
		 response.getWriter().println(MessageFormat.format("driver={0},url={1},username={2},password={3}", driver,url, username, password));
		
	}
	
	

}
