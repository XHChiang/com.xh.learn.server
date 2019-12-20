package com.xh.learn.website.testModule.main;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main4 {
	public static void main(String[] args) {
		String src = "http://www.runoob.com/java/java8-base64.html";
		String encodeToString = Base64.getEncoder().encodeToString(src.getBytes());

		System.out.println(encodeToString);

		byte[] decode = Base64.getDecoder().decode(encodeToString);
		String dst = new String(decode);

		System.out.println(dst);

		// --------------------------------------------------------------------------------
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

		String name = "Runoob";
		Integer result = null;

		try {
			nashorn.eval("print('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");

			String s = (String) nashorn.eval("1.2455.toFixed(2)");
			System.out.println(s);
		} catch (ScriptException e) {
			System.out.println("执行脚本错误: " + e.getMessage());
		}

		System.out.println(result.toString());
		// --------------------------------------------------------------------------------
		Integer a = null;
		Optional<Integer> optionalA = Optional.ofNullable(a);

		Integer b = new Integer(11);
		Optional<Integer> optionalB = Optional.ofNullable(b);

		System.out.println(optionalA.orElse(0) + optionalB.get());
		// --------------------------------------------------------------------------------
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数
		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println(squaresList.toString());

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		// 获取空字符串的数量
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		strings.stream().filter(x -> !x.isEmpty()).collect(Collectors.toSet());

		// 打印出 10 条数据
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);

		System.out.println(String.format("dd %d", 1));
	}
}
