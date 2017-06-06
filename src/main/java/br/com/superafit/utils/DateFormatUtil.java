package br.com.superafit.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

	public static final SimpleDateFormat DIA_MES_ANO = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat HORA_MINUTO = new SimpleDateFormat("HH:mm");;
	
	public static String toString(Date date, SimpleDateFormat formato) {
		return formato.format(date);
	}
	
}
