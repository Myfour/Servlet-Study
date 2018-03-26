package servlet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println(arg0.getSession()+"被创建了!!!!!");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("Session已经销毁了");
	}
}
