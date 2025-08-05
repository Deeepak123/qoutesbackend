package com.backend.proservice.qoutes.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericService {
	
	private static final String ZONE = "America/New_York";
	
	public static List<Object> mapToList(Map<String, Object> map) {
		if(map != null && !map.isEmpty()) {
			return map.values().stream()
					.collect(Collectors.toList());
		}
		return null;
	}
	
	public static boolean isNumber(String number) {
		if(number != null && !number.isEmpty()) {
			return number.chars().allMatch(Character :: isDigit);
		}
		return false;
	}
	
	public static long objToLong(Object number) {
		if(number != null && !"".equals(number) && !"NaN".equals(number) && !"null".equals(number) ) {
			try {
				BigDecimal bd = new BigDecimal(String.valueOf(number).replaceAll(",", "").replaceAll("\"", ""));
				return bd.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
			} catch (Exception e) {
				System.out.println(number);
				e.printStackTrace();
			}
		}
		return 0l;
	}
	
	public static double objToDouble(Object number) {
		if(number != null && !"".equals(number) && !"NaN".equals(number) && !"undefined".equals(number)) {
			try {
				BigDecimal bd = new BigDecimal(String.valueOf(number).replaceAll(",", "").replaceAll("\"", ""));
				return bd.doubleValue();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0d;
	}
	
	public static boolean objToBoolean(Object obj) {
		if(obj != null && !"".equals(obj)) {
			try {
				return Boolean.valueOf(String.valueOf(obj));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static String objToString(Object obj) {
		if(obj != null && !"".equals(obj)) {
			try {
				return String.valueOf(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
	
	public static String timeStampToDate(Object obj) {
		String date = "";
		long timeStamp = objToLong(obj);
		try {
			date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (timeStamp));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static int objToInteger(Object obj) {
		if(obj != null && !"".equals(obj) && !"null".equals(obj)) {
			try {
				return Integer.parseInt(String.valueOf(obj));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public static int getMonth(Date date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal.get(Calendar.MONTH);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String getCurrentWeek() {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String dateStr = sdf.format(date);
			LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.of(ZONE));
			LocalDate ld = zonedDateTime.toLocalDate(); 
			LocalDate weekStart = ld.with(WeekFields.of(Locale.US).dayOfWeek(), 1);
			String startWeek = weekStart.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
			return startWeek;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
