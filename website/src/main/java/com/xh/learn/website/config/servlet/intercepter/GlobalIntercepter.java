package com.xh.learn.website.config.servlet.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class GlobalIntercepter extends HandlerInterceptorAdapter {
	@Value("${static.url}")
	private String staticUrl;// 静态资源路径

	@Value("${static.version}")
	private String staticVersion; // 静态资源版本号

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(true);

		Object staticurl = session.getAttribute("static_url");
		if (staticurl == null) {
			session.setAttribute("static_url", staticUrl);
		}

		Object staticversion = session.getAttribute("static_version");
		if (staticversion == null) {
			session.setAttribute("static_version", staticVersion);
		}

		return true;
	}

}
