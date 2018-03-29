package servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {
	@Override // 加@Override的意思在于检查你的重写的方法是否重写无误
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// 对request和response进行一些预处理
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html;charset=utf-8");
		System.out.println("FilterDemo1执行前===");
		arg2.doFilter(arg0, arg1);// 放行，让目标资源执行
		System.out.println("FilterDemo1执行后===");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器初始化-------");

	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁----------");

	}
}
