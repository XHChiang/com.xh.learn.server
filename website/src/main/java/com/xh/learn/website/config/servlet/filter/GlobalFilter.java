package com.xh.learn.website.config.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xh.learn.sdk.util.ExceptionUtil;

@WebFilter(urlPatterns = "*")
public class GlobalFilter implements Filter {
	private static Logger logger = LoggerFactory.getLogger(GlobalFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		HttpServletRequest hRequest = (HttpServletRequest) request;

		String method = hRequest.getMethod();
		String protocol = request.getProtocol();
		String requestURI = hRequest.getRequestURI();
		String contentType = request.getContentType();
		String queryString = hRequest.getQueryString();

		logger.info(protocol + " | " + method + " | " + requestURI + " | " + queryString + " | " + contentType);

		try {
			chain.doFilter(request, response);
		} catch (IOException | ServletException e) {
			logger.error(ExceptionUtil.eToString(e));
		}
	}

	@Override
	public void destroy() {

	}

}
