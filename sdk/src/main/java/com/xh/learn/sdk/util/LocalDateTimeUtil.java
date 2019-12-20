package com.xh.learn.sdk.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {
	public static LocalDateTime now(ZoneId... zoneIds) {
		ZoneId zoneId = ZoneId.systemDefault();
		if (zoneIds.length > 0) {
			zoneId = zoneIds[0];
		}

		Instant instant = Instant.now();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
		return localDateTime;
	}

	public static LocalDateTime parse(CharSequence text, String... patterns) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		if (patterns.length > 0) {
			pattern = patterns[0];
		}
		LocalDateTime localDateTime = LocalDateTime.parse(text, DateTimeFormatter.ofPattern(pattern));
		return localDateTime;
	}

	public static String format(LocalDateTime localDateTime, String... patterns) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		if (patterns.length > 0) {
			pattern = patterns[0];
		}
		String format = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
		return format;
	}

	public static long toEpochSecond(LocalDateTime localDateTime, ZoneOffset... zoneOffsets) {
		ZoneOffset offset = ZoneOffset.UTC;
		if (zoneOffsets.length > 0) {
			offset = zoneOffsets[0];
		}
		long epochSecond = localDateTime.toEpochSecond(offset);
		return epochSecond;
	}
}
