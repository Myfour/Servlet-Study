package servlet.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 实现简单的图片的下载，以及中文文件名的问题
 * @author myfour
 *
 */
public class ResponseDemo2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		downloadFileByOutputStream(resp);
	}
	
	private void downloadFileByOutputStream(HttpServletResponse response)throws FileNotFoundException,IOException {
//		String realPath=this.getServletContext().getRealPath("/home/myfour/图片/a.jpg");
		String realPath="/home/myfour/图片/a.jpg";
		String fileName="妹子.jpg";
		fileName=URLEncoder.encode(fileName, "UTF-8");
		System.out.println(fileName);
		//设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码，否则会出现文件名乱码,记得添加filename字段后面的*号，有了这个才能将UTF-8编码转换成中文显示
		response.setHeader("content-disposition","attachment;filename*="+fileName);
		InputStream inputStream=new FileInputStream(realPath);
		int len=0;
		byte[] buffer=new byte[1024];
		OutputStream outputStream=response.getOutputStream();
		while((len=inputStream.read(buffer))>0) {
			outputStream.write(buffer,0,len);
		}
		inputStream.close();
	}
}
