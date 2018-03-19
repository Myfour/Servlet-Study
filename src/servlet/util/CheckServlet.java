package servlet.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String checkcode=(String)req.getSession().getAttribute("checkcode");
    	resp.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html;charset=utf-8");
    	String[] code=req.getParameterValues("validateCode");
    	if(checkcode.equals(code[0])) {
    		resp.getWriter().write("验证正确");
    	}else {
			resp.getWriter().write("验证失败");
		}
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }
}
