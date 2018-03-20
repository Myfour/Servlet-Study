package servlet.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo2
 */
@WebServlet("/requestdemo2")
public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//下面两句输出中文时必须
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
	        Enumeration<String> reqHeadInfos = request.getHeaderNames();//获取所有的请求头
	        out.write("获取到的客户端所有的请求头信息如下：");
	        out.write("<hr/>");
	        while (reqHeadInfos.hasMoreElements()) {
	            String headName = (String) reqHeadInfos.nextElement();
	            String headValue = request.getHeader(headName);//根据请求头的名字获取对应的请求头的值
	            out.write(headName+":"+headValue);
	            out.write("<br/>");
	        }
	        out.write("<br/>");
	        out.write("获取到的客户端Accept-Encoding请求头的值：");
	        out.write("<hr/>");
	        String value = request.getHeader("Accept-Encoding");//获取Accept-Encoding请求头对应的值
	        out.write(value);
	        
	        Enumeration<String> e = request.getHeaders("Accept-Encoding");
	        while (e.hasMoreElements()) {
	            String string = (String) e.nextElement();
	            System.out.println(string);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
