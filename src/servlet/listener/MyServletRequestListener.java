package servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println(arg0.getServletRequest()+"创建了！！！！！！");	
	}
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println(arg0.getServletRequest()+"销毁了！！！！！！！！！");	
	}
}
