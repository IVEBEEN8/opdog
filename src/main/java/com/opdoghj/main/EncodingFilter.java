package com.opdoghj.main;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 초기화 로직 (필요하다면)
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		// 다음 필터 또는 서블릿으로 전송
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// 필터가 소멸될 때의 로직 (필요하다면)
	}
}