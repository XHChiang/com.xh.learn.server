package com.xh.learn.sdk.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigNumberUtil {
	/**
	 * 私有构造方法，禁止实例化
	 */
	private BigNumberUtil() {
		super();
	}

	// 默认除法运算精度,即保留小数点多少位
	private static final int DEFAULT_DIV_SCALE = 10;

	/**
	 * 两个数精确相加
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double add(double v1, double v2) {
		return new BigDecimal(Double.toString(v1)).add(new BigDecimal(Double.toString(v2))).doubleValue();
	}

	/**
	 * 多个数字精确相加，返回double
	 * 
	 * @param ds
	 * @return 多个参数的和
	 */
	public static double adds(double... vs) {
		return addsBigDecimal(vs).doubleValue();
	}

	/**
	 * 多个数精确相加，返回BigDecimal
	 * 
	 * @param vs
	 * @return
	 */
	private static BigDecimal addsBigDecimal(double... vs) {
		if (vs.length == 0) {
			return new BigDecimal(0);
		}
		BigDecimal result = new BigDecimal(Double.toString(vs[0]));
		for (int i = 1; i < vs.length; i++) {
			result = result.add(new BigDecimal(Double.toString(vs[i])));
		}
		return result;
	}

	/**
	 * 一个数减去多个数
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数(一个或多个)
	 * @return 一个数减去多个数
	 */
	public static double sub(double v1, double... vs) {
		return new BigDecimal(Double.toString(v1)).subtract(addsBigDecimal(vs)).doubleValue();
	}

	/**
	 * 两个数字精确相乘，直接返回
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double mul(double v1, double v2) {
		return (new BigDecimal(Double.toString(v1)).multiply(new BigDecimal(Double.toString(v2)))).doubleValue();
	}

	/**
	 * 两个数精确相乘，保留指定小数位，四舍五入
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return
	 */
	public static double mul(double v1, double v2, int scale) {
		return mul(v1, v2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 两个数精确相乘，保留指定小数，指定舍入模式
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 *            保留小数位
	 * @param roundingMode
	 *            舍入模式
	 * @return
	 */
	public static double mul(double v1, double v2, int scale, int roundingMode) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.multiply(b2).setScale(scale, roundingMode)).doubleValue();
	}

	/**
	 * 多个数字精确相乘，直接返回
	 * 
	 * @param vs
	 * @return
	 */
	public static double muls(double... vs) {
		return mulsBigDecimal(vs).doubleValue();
	}

	/**
	 * 多个数相乘，返回BigDecimal
	 * 
	 * @param vs
	 * @return
	 */
	private static BigDecimal mulsBigDecimal(double... vs) {
		if (vs.length == 0) {
			return new BigDecimal(0);
		}
		BigDecimal result = new BigDecimal(Double.toString(vs[0]));
		for (int i = 1; i < vs.length; i++) {
			result = result.multiply(new BigDecimal(Double.toString(vs[i])));
		}
		return result;
	}

	/**
	 * 一个数乘以多个数，保留指定小数位，四舍五入
	 * 
	 * @param v1
	 * @param vs
	 * @param scale
	 *            保留小数位
	 * @return
	 */
	public static double muls(double v1, double[] vs, int scale) {
		return muls(v1, vs, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 一个数乘以多个数，保留指定小数位，指定舍入模式
	 * 
	 * @param v1
	 * @param vs
	 * @param scale
	 *            保留小数位
	 * @param roundingMode
	 *            舍入模式
	 * @return
	 */
	public static double muls(double v1, double[] vs, int scale, int roundingMode) {
		BigDecimal result = new BigDecimal(Double.toString(v1));
		for (int i = 0; i < vs.length; i++) {
			result = result.multiply(new BigDecimal(Double.toString(vs[i])));
		}
		return (result.setScale(scale, roundingMode)).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，默认四舍五入保留十位小数。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEFAULT_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		return div(v1, v2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，指定摄入模式。
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @param roundingMode
	 * @return
	 */
	public static double div(double v1, double v2, int scale, int roundingMode) {
		if (scale < 0) {
			System.err.println("除法精度必须大于0!");
			return 0;
		}
		return (new BigDecimal(Double.toString(v1)).divide(new BigDecimal(Double.toString(v2)), scale, roundingMode)).doubleValue();
	}

	/**
	 * 多个数精确相除，当发生除不尽的情况时，默认四舍五入保留十位小数
	 * 
	 * @param v1
	 * @param vs
	 * @return
	 */
	public static double divs(double v1, double[] vs) {
		return div(v1, muls(vs), DEFAULT_DIV_SCALE);
	}

	/**
	 * 一个数除以多个数，当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param scale
	 * @param v1
	 * @param vs
	 * @return
	 */
	public static double divs(double v1, double[] vs, int scale) {
		return div(v1, muls(vs), scale);
	}

	/**
	 * 一个数除以多个数，当发生除不尽的情况时，由scale参数指 定精度，指定舍入模式。
	 * 
	 * @param v1
	 * @param vs
	 * @param scale
	 * @param roundingMode
	 * @return
	 */
	public static double divs(double v1, double[] vs, int scale, int roundingMode) {
		return div(v1, muls(vs), scale, roundingMode);
	}

	/**
	 * 四舍五入保留指定小数位
	 * 
	 * @param v1
	 * 
	 * @param scale
	 *            保留几位小数
	 * 
	 * @return n!的值
	 */
	public static double scale(double v1, int scale) {
		BigDecimal decimal = new BigDecimal(Double.toString(v1));
		decimal = decimal.setScale(scale, RoundingMode.HALF_UP);

		return decimal.doubleValue();
	}

	/**
	 * 计算Factorial阶乘！
	 * 
	 * @param n
	 *            任意大于等于0的int
	 * @return n!的值
	 */
	public static BigInteger getFactorial(int n) {
		if (n < 0) {
			System.err.println("n必须大于等于0！");
			return new BigInteger("-1");
		} else if (n == 0) {
			return new BigInteger("0");
		}
		// 将数组换成字符串后构造BigInteger
		BigInteger result = new BigInteger("1");
		for (; n > 0; n--) {
			// 将数字n转换成字符串后，再构造一个BigInteger对象，与现有结果做乘法
			result = result.multiply(new BigInteger(new Integer(n).toString()));
		}
		return result;
	}

	public static void main(String[] args) {

		double[] vs = { 2, 3 };
		System.out.println(divs(2, vs, 4));
		// System.out.println(divs(2, vs));
		// System.out.println(div(1, 3, 4));
		//
		// System.out.println(div(1, 3));

		// System.out.println(muls(2, 3, 5, 6, 7));
		// System.out.println(adds(2, 3, 5, 6, 7));
		//
		// System.out.println(sub(2, 1));
		//
		// System.out.println(mul(2, 4));
	}
}
