package servlet.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/cookiedemo1")
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF--8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer=response.getWriter();
		Cookie[] c1=request.getCookies();
		
		if(c1!=null) {
			for(Cookie i:c1) {
				System.out.println(i);
				if (i.getName().equals("lastaccess")) {
					writer.write("你上次登录的时间：");
					long lastaccess=Long.parseLong(i.getValue());
					Date date=new Date(lastaccess);
					writer.write(date.toString());
				}else {
					writer.write("你是第一次登录");
				}
			}
		}else {
			writer.write("你是第一次登录");
		}
		Cookie c2=new Cookie("lastaccess", System.currentTimeMillis()+"");
		c2.setMaxAge(60*5);
		response.addCookie(c2);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
