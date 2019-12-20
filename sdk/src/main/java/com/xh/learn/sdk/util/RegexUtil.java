package com.xh.learn.sdk.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class RegexUtil {

	/**
	 * 过滤HTML、script标签
	 * 
	 * @param htmlStr 含html标签的字符串
	 * @return
	 */
	public static String filterHtml(String htmlStr) {
		try {
			if (htmlStr != null && !"".equals(htmlStr)) {
				Pattern p_script = Pattern.compile("<script[^>]*?>[\\s\\S]*?<\\/script>", Pattern.CASE_INSENSITIVE);
				Matcher m_script = p_script.matcher(htmlStr);
				htmlStr = m_script.replaceAll(""); // 过滤script标签

				Pattern p_style = Pattern.compile("<style[^>]*?>[\\s\\S]*?<\\/style>", Pattern.CASE_INSENSITIVE);
				Matcher m_style = p_style.matcher(htmlStr);
				htmlStr = m_style.replaceAll(""); // 过滤style标签

				Pattern p_html = Pattern.compile("<[^>]+>", Pattern.CASE_INSENSITIVE);
				Matcher m_html = p_html.matcher(htmlStr);
				htmlStr = m_html.replaceAll(""); // 过滤html标签

				Pattern p_space = Pattern.compile("\t|\r|\n", Pattern.CASE_INSENSITIVE);
				Matcher m_space = p_space.matcher(htmlStr);
				htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return htmlStr.trim(); // 返回文本字符串
	}

	/**
	 * 过滤中英文特殊字符，除英文"-_"字符外
	 * 
	 * @param text
	 * @return
	 */
	public static String filterStr(String text) {
		String regExpr = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regExpr);
		Matcher m = p.matcher(text);
		return m.replaceAll("").trim();
	}

	/**
	 * 匹配汉字
	 * 
	 * @param text
	 * @return
	 */
	public final static boolean isChinese(String text) {
		return match(text, "^[\u4e00-\u9fa5]+$");
	}

	/**
	 * 判断中文字符(包括汉字和符号)
	 * 
	 * @param text
	 * @return
	 */
	public final static boolean isChineseChar(String text) {
		return match(text, "^[\u0391-\uFFE5]+$");
	}

	/**
	 * 是否包含中英文特殊字符，除英文"-_"字符外
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isContainsSpecialChar(String text) {
		if (StringUtils.isBlank(text))
			return false;
		String[] chars = { "[", "`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "=", "|", "{", "}",
				"'", ":", ";", "'", ",", "[", "]", ".", "<", ">", "/", "?", "~", "！", "@", "#", "￥", "%", "…", "&", "*",
				"（", "）", "—", "+", "|", "{", "}", "【", "】", "‘", "；", "：", "”", "“", "’", "。", "，", "、", "？", "]" };
		for (String ch : chars) {
			if (text.contains(ch))
				return true;
		}
		return false;
	}

	/**
	 * 只能输入数字
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isDigits(String str) {
		return match(str, "^[0-9]+$");
	}

	/**
	 * 匹配Email地址
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isEmail(String email) {
		return match(email, "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
	}

	/**
	 * 判断英文字符(a-zA-Z)
	 * 
	 * @param text
	 * @return
	 */
	public final static boolean isEnglish(String text) {
		return match(text, "^[A-Za-z]+$");
	}

	/**
	 * 匹配正浮点数
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isFloat(String str) {
		return match(str, "^[-\\+]?\\d+(\\.\\d+)?$");
	}

	/**
	 * 判断浮点数num是否等于0
	 * 
	 * @param num 浮点数
	 * @return
	 */
	public final static boolean isFloatEqZero(float num) {
		return num == 0f;
	}

	/**
	 * 判断浮点数num是否大于或等于0
	 * 
	 * @param num 浮点数
	 * @return
	 */
	public final static boolean isFloatGteZero(float num) {
		return num >= 0f;
	}

	/**
	 * 判断浮点数num是否大于0
	 * 
	 * @param num 浮点数
	 * @return
	 */
	public final static boolean isFloatGtZero(float num) {
		return num > 0f;
	}

	/**
	 * 身份证号码验证
	 * 
	 * @param text
	 * @return
	 */
	public final static boolean isIdCardNo(String text) {
		return match(text, "^(\\d{6})()?(\\d{4})(\\d{2})(\\d{2})(\\d{3})(\\w)$");
	}

	/**
	 * 匹配非负整数（正整数+0）
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isInteger(String str) {
		return match(str, "^[+]?\\d+$");
	}

	/**
	 * 判断整数num是否等于0
	 * 
	 * @param num
	 * @return
	 */
	public final static boolean isIntEqZero(int num) {
		return num == 0;
	}

	/**
	 * 判断整数num是否大于或等于0
	 * 
	 * @param num
	 * @return
	 */
	public final static boolean isIntGteZero(int num) {
		return num >= 0;
	}

	/**
	 * 判断整数num是否大于0
	 * 
	 * @param num
	 * @return
	 */
	public final static boolean isIntGtZero(int num) {
		return num > 0;
	}

	/**
	 * 手机号码验证
	 * 
	 * @param text
	 * @return
	 */
	public final static boolean isMobile(String text) {
		if (text.length() != 11)
			return false;
		return match(text, "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
	}

	public final static boolean isNotNull(Collection<?> collection) {
		return !isNull(collection);
	}

	public final static boolean isNotNull(Integer integer) {
		return !isNull(integer);
	}

	public final static boolean isNotNull(Long longs) {
		return !isNull(longs);
	}

	public final static boolean isNotNull(Map<?, ?> map) {
		return !isNull(map);
	}

	public final static boolean isNotNull(Object[] objs) {
		return !isNull(objs);
	}

	public final static boolean isNotNull(String str) {
		return !isNull(str);
	}

	public final static boolean isNull(Collection<?> collection) {
		if (collection == null || collection.size() == 0)
			return true;
		return false;
	}

	public final static boolean isNull(Integer integer) {
		if (integer == null || integer == 0)
			return true;
		return false;
	}

	public final static boolean isNull(Long longs) {
		if (longs == null || longs == 0)
			return true;
		return false;
	}

	public final static boolean isNull(Map<?, ?> map) {
		if (map == null || map.size() == 0)
			return true;
		return false;
	}

	public final static boolean isNull(Object[] objs) {
		if (objs == null || objs.length == 0)
			return true;
		return false;
	}

	public final static boolean isNull(String str) {
		return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase());
	}

	/**
	 * 判断数值类型，包括整数和浮点数
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isNumeric(String str) {
		if (isFloat(str) || isInteger(str))
			return true;
		return false;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param text
	 * @return
	 */
	public final static boolean isPhone(String text) {
		return match(text, "^(\\d{3,4}-?)?\\d{7,9}$");
	}

	/**
	 * 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isPwd(String str) {
		return match(str, "^[a-zA-Z]\\w{6,12}$");
	}

	/**
	 * 判断是否为合法字符(a-zA-Z0-9-_)
	 * 
	 * @param text
	 * @return
	 */
	public final static boolean isRightfulString(String text) {
		return match(text, "^[A-Za-z0-9_-]+$");
	}

	/**
	 * 验证字符，只能包含中文、英文、数字、下划线等字符。
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isString(String str) {
		return match(str, "^[a-zA-Z0-9\u4e00-\u9fa5-_]+$");
	}

	/**
	 * 联系电话(手机/电话皆可)验证
	 * 
	 * @param text
	 * @return
	 */
	public final static boolean isTel(String text) {
		if (isMobile(text) || isPhone(text))
			return true;
		return false;
	}

	/**
	 * 匹配URL地址
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isUrl(String str) {
		return match(str, "^(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]$");
	}

	/**
	 * 匹配URL地址
	 * 
	 * @param str
	 * @return
	 */
	public final static boolean isUrlV2(String str) {
		return match(str, "/^http[s]{0,1}:\\/\\/.+$/");
	}

	/**
	 * 邮政编码验证
	 * 
	 * @param text
	 * @return
	 */
	public final static boolean isZipCode(String text) {
		return match(text, "^[0-9]{6}$");
	}

	public static void main(String[] args) {
//		String html = "<html lang=\"en\" data-host=\"//gatewayapi.tomtop.com\">";
//		html = html.replaceAll("<html.+data-host *= *\"//\\w*\\.tomtop\\.com\".*>", "<html lang=\"en\" data-host=\"//marketing.api.tomtop.com\">");
//		System.out.println(html);

//		String htmlA = "<html lang=\"en\" data-host=\"//openapi.tomtop.com\">";
//		htmlA = htmlA.replaceAll("<html +lang *= *\"en\" +data-host *= *\"//openapi\\.tomtop\\.com\" *>", "<html lang=\"en\" data-host=\"//marketing.api.tomtop.com\">");
//		System.out.println(htmlA);

//		String htmlB = "<html lang=\"en\" data-host=\"//openapi.tomtop.com\">";
//		htmlB = htmlB.replaceAll("(?<=<html lang=\"en\" data-host=\"//)openapi(?=\\.tomtop\\.com\">)", "marketing.api");
//		System.out.println(htmlB);

//		String html1 = "Windows2000";
//		html1 = html1.replaceAll("Windows(95|98|NT|2000)", "X");
//		System.out.println(html1);

//		String html2 = "Windows2000";
//		html2 = html2.replaceAll("Windows(?:95|98|NT|2000)", "X");
//		System.out.println(html2);

//		String html3 = "Windows95-Windows98";
//		html3 = html3.replaceAll("Windows(?=95|98|NT|2000)", "X");// 正向肯定
//		System.out.println(html3);
//
//		String html4 = "Windows-Windows3.1-Windows6.1";
//		html4 = html4.replaceAll("Windows(?!95|98|NT|2000)", "X");// 正向否定
//		System.out.println(html4);
//
//		String html5 = "95Windows-98Windows";
//		html5 = html5.replaceAll("(?<=95|98|NT|2000)Windows", "X");// 反向肯定
//		System.out.println(html5);
//
//		String html6 = "Windows-3.1Windows-6.1Windows";
//		html6 = html6.replaceAll("(?<!95|98|NT|2000)Windows", "X");// 反向否定
//		System.out.println(html6);

		String head = "<header class=\"component st_header\">\r\n" + "	<div class=\"w1200 hd-50\">\r\n"
				+ "		<div class=\"logo\">\r\n"
				+ "			<a href=\"#\" target=\"_blank\"> <img src=\"//static.tomtop.com/tomtop/icon/logo.png?v=3\" alt=\"TOMTOP\" title=\"TOMTOP\"></a>\r\n"
				+ "		</div>\r\n" + "		<div class=\"HDri\">\r\n"
				+ "			<a href=\"#\" style=\"color: #000;\"> Home</a> <span></span> Ulefone Power 3 4G LTE Mobile Phone with $80 Off, Get Free Gifts | Tomtop\r\n"
				+ "		</div>\r\n" + "	</div>\r\n" + "</header>";
		String replaceAll = head.replaceAll(
				"(<div class=\"HDri\">\r\n)(\\s+<a.*</a>)(\\s+<span></span>\\s+)(.*\r\n)(\\s+</div>)",
				"$1" + "$2" + "$3" + "44444\r\n" + "$5");
		System.out.println(replaceAll);
	}

	/**
	 * 正则表达式匹配
	 * 
	 * @param text 待匹配的文本
	 * @param reg  正则表达式
	 * @return
	 */
	private final static boolean match(String text, String reg) {
		if (StringUtils.isBlank(text) || StringUtils.isBlank(reg))
			return false;
		return Pattern.compile(reg).matcher(text).matches();
	}

	/**
	 * 替换除数字字母以外的字符为“-”
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceStr(String str) {
		if (str != null) {
			str = str.replaceAll("[\\pP\\p{Punct}.°. ]", " ").trim().replaceAll("[ ]+", "-");
		}
		return str;
	}
}
