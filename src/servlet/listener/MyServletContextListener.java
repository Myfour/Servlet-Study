package servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("监听到ServletContext对象创建");
    }
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("监听到ServletContext对象的销毁");	
    }
}
