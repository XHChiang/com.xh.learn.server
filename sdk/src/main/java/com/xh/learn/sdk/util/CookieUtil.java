package com.xh.learn.sdk.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CookieUtil {
	public static final Pattern PATTERN = Pattern.compile("(\\w+\\.)*([\\w]+)\\.");

	/**
	 * 设置Cookie的值，并使其在指定时间内生效
	 * 
	 * @param key
	 * @param value
	 * @param cookieMaxAge
	 */
	public static void setCookie(String key, String value, int cookieMaxAge) {
		ServletRequestAttributes servlet = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = servlet.getRequest();
		HttpServletResponse response = servlet.getResponse();

		if (request == null) {
			return;
		}
		if (value == null) {
			value = "";
		}
		String domain = null;

		String host = request.getHeader("Host");

		Matcher matcher = PATTERN.matcher(host);
		if (matcher.find()) {
			domain = "." + matcher.group(2) + ".com";
		}

		Cookie cookie = new Cookie(key, value);

		if (cookieMaxAge > 0) {
			cookie.setMaxAge(cookieMaxAge);
		}
		cookie.setPath("/");

		if (domain != null) {
			cookie.setDomain(domain);
		}
		response.addCookie(cookie);
	}

	/**
	 * 删除Cookie
	 * 
	 * @param key
	 */
	public static void removeCookie(String key) {

		ServletRequestAttributes servlet = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = servlet.getRequest();
		HttpServletResponse response = servlet.getResponse();
		if (request == null) {
			return;
		}

		String domain = null;
		String host = request.getHeader("Host");

		Matcher matcher = PATTERN.matcher(host);
		if (matcher.find()) {
			domain = "." + matcher.group(2) + ".com";
		}

		Cookie cookie = new Cookie(key, "");
		cookie.setMaxAge(-1);
		cookie.setPath("/");

		if (domain != null) {
			cookie.setDomain(domain);
		}

		response.addCookie(cookie);
	}

	/**
	 * 获取Cookie的值
	 * 
	 * @param key
	 * @param request
	 * @return
	 */
	public static String getCookie(String key, HttpServletRequest request) {
		if (null == request || key == null) {
			return "";
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				if (name.equals(key)) {
					return c.getValue();
				}
			}
		}
		return "";
	}

}
