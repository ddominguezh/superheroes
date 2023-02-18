package com.ddominguezh.superhero.shared.domain;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;

public final class Utils {
	
	public static String dateToString(LocalDateTime dateTime) {
		String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
		return dateTime.format(DateTimeFormatter.ofPattern(dateTimePattern));
	}

	public static String dateToString(Timestamp timestamp) {
        return dateToString(timestamp.toLocalDateTime());
    }
	
	public static LocalDateTime stringToDate(String value) {
		String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
		return LocalDateTime.parse(value, DateTimeFormatter.ofPattern(dateTimePattern));
	}
	
	public static String jsonEncode(HashMap<String, Serializable> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static HashMap<String, Serializable> jsonDecode(String body) {
        try {
            return new ObjectMapper().readValue(body, HashMap.class);
        } catch (IOException e) {
            return null;
        }
    }

    public static String toSnake(String text) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, text);
    }
}
