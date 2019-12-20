package com.xh.learn.sdk.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
	public static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 解析JSON字符串为实体类
	 * 
	 * @param object
	 * @param cls
	 * @return
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static <T> T readValue(String json, Class<T> cls) throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(json, cls);
	}

	/**
	 * 解析JSON字符串为JSON对象
	 * 
	 * @param json
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode readTree(String json) throws JsonProcessingException, IOException {
		return objectMapper.readTree(json);
	}

	/**
	 * 解析Java对象为JSON字符串
	 * 
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String writeValueAsString(Object object) throws JsonProcessingException {
		return objectMapper.writeValueAsString(object);
	}
}
