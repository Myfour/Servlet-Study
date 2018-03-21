package servlet.study;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo3
 */
@WebServlet("/requestdemo3")
public class RequestDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8"); //客户端是以UTF-8编码提交表单数据的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码,这样可以解决以post方式提交中文数据乱码的问题
		String userid=request.getParameter("userid");
		String username=request.getParameter("username");
		String userpass = request.getParameter("userpass");//获取填写的密码
		String sex = request.getParameter("sex");//获取选中的性别
		String dept = request.getParameter("dept");//获取选中的部门
		String[] inst=request.getParameterValues("inst");
		String note = request.getParameter("note");//获取填写的说明信息
		String hiddenField = request.getParameter("hiddenField");//获取隐藏域的内容
		String instStr="";
		for(int i=0;inst!=null&&i<inst.length;i++) {
			if(i==inst.length-1) {
				instStr+=inst[i];
			}else {
				instStr+=inst[i]+",";
			}
			
		}
		String htmlStr = "<table>" +
				"<tr><td>填写的编号：</td><td>{0}</td></tr>" +
				"<tr><td>填写的用户名：</td><td>{1}</td></tr>" +
				"<tr><td>填写的密码：</td><td>{2}</td></tr>" +
				"<tr><td>选中的性别：</td><td>{3}</td></tr>" +
				"<tr><td>选中的部门：</td><td>{4}</td></tr>" +
				"<tr><td>选中的兴趣：</td><td>{5}</td></tr>" +
				"<tr><td>填写的说明：</td><td>{6}</td></tr>" +
				"<tr><td>隐藏域的内容：</td><td>{7}</td></tr>" +
				"</table>";
				htmlStr = MessageFormat.format(htmlStr, userid,username,userpass,sex,dept,instStr,note,hiddenField);
				
				response.setCharacterEncoding("UTF-8");//设置服务器端以UTF-8编码输出数据到客户端
				response.setContentType("text/html;charset=UTF-8");//设置客户端浏览器以UTF-8编码解析数据
				response.getWriter().write(htmlStr);//输出htmlStr里面的内容到客户端浏览器显示
				
				Enumeration<String> paramNames= request.getParameterNames();
				while(paramNames.hasMoreElements()) {
					String name;
					System.out.println(name=paramNames.nextElement());
					String value;
					System.out.println(value=request.getParameter(name));
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
