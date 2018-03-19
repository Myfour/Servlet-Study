package servlet.study;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 输出中文方法
 * @author myfour
 *
 */
public class ResponseDemo1 extends HttpServlet{
	/**
	 * 使用outputSteam输出中文
	 * 
	 */
	public void outputChineseByOutputStream(HttpServletResponse response)throws IOException{
		String data="中国";
		OutputStream out=response.getOutputStream();
		response.setHeader("content-type", "text/html;charset=utf-8");//注意charset前面用分号
		byte[] dataByteArr=data.getBytes("UTF-8");
		for(byte x:dataByteArr) {
			System.out.println(x);
		}
		out.write(dataByteArr);
	}
	/**
	 * 使用PrintWriter输出中文
	 * 
	 */
	public void outputChineseByPrintWriter(HttpServletResponse response)throws IOException{
		String data="中国";
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		response.setHeader("content-type","text/html;charset=utf-8");
		out.write(data);
		if (this.getServletContext().getAttribute("somedata")!=null) {
			out.write((String)this.getServletContext().getAttribute("somedata"));	
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		outputChineseByOutputStream(resp);
		outputChineseByPrintWriter(resp);
	}
}
