package com.rias.sharing.life.common.util;


import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
	
	private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
	
	public static boolean isMobile(String src) {
		if(StringUtils.isEmpty(src)) {
			return false;
		}
		Matcher m = mobile_pattern.matcher(src);
		return m.matches();
	}

	public static boolean isDate(String src) {
		if(StringUtils.isEmpty(src)) {
			return false;
		}

		try {
            LocalDate date = LocalDate.parse(src);
        } catch (DateTimeParseException e) {
		    return false;
        }

		return true;
	}
}
