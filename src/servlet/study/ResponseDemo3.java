package servlet.study;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成随机数字验证码图片
 */
@WebServlet("/responsedemo3")
public class ResponseDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("refresh", "5");//设置refresh响应头控制浏览器每隔5秒钟刷新一次
		BufferedImage image=new BufferedImage(50, 20, BufferedImage.TYPE_INT_RGB);//1.在内存中创建一张图片
		Graphics2D g=(Graphics2D)image.getGraphics();
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, 50, 20);
		g.setColor(Color.RED);
		g.setFont(new Font(null, Font.BOLD, 20));
		g.drawString(makenum(), 0, 20);
//		response.setContentType("image/jpeg");
		 //5.设置响应头控制浏览器不缓存图片数据
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//6.将图片写给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
	private String makenum() {
		Random random=new Random();
		String num=random.nextInt(999)+"";
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<4-num.length();i++) {
			stringBuffer.append("0");
		}
		num=stringBuffer.toString()+num;
		return num;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
