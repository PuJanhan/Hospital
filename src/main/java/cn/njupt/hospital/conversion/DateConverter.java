package cn.njupt.hospital.conversion;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Timestamp>{

	@Override
	public Timestamp convert(String source) {
		if(null!=source){
			//2018-11-01 00:00:00.0
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			format.setLenient(false);
			try {
				Timestamp stamp = new Timestamp(format.parse(source).getTime());
				return stamp;
			} catch (ParseException e) {
			
			}
		}
		return null;
	}

	

}
