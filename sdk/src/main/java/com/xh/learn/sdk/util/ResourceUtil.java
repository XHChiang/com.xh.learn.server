package com.xh.learn.sdk.util;

import java.io.IOException;

import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ClassUtils;

public class ResourceUtil {

	/**
	 * 获取资源文件
	 * 
	 * @param basePackage
	 * @param pattern
	 * @return
	 * @throws IOException
	 */
	public static Resource[] getResource(String basePackage, String pattern) throws IOException {
		StandardEnvironment environment = new StandardEnvironment();
		String resolveRequiredPlaceholders = environment.resolveRequiredPlaceholders(basePackage);
		String packagePath = ClassUtils.convertClassNameToResourcePath(resolveRequiredPlaceholders);
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + packagePath + "/" + pattern;

		Resource[] resources = new PathMatchingResourcePatternResolver().getResources(packageSearchPath);
		return resources;
	}
}
