package models;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Weather {
	double temp; // in F
	double windspeed; // in miles
	int code;
	String description;
	String icon;
	Date date;
	public Weather(Date date, double temp, double windspeed, int code, String description, String icon){
		this.date = date;
		this.temp = temp;
		this.windspeed = windspeed;
		this.code = code;
		this.description = description;
		this.icon = icon;
	}
	public Date getDate(){
		return this.date;
	}
	public double getTemp(){
		return this.temp;
	}
	public double getWindSpeed(){
		return this.windspeed;
	}
	public int getWeatherCode(){
		return this.code;
	}
	public String getWeatherDescription(){
		return this.description;
	}
	public String getWeatherIcon(){
		return this.icon;
	}
	public String toString(){
		return "Temp:" + String.valueOf(this.temp) + "F, windspeed: " + String.valueOf(this.windspeed) + "miles/hr, desc: " + this.description + ", icon: " + this.icon;
		
	}
	public static String toCSV(HashMap<Date, Weather> ws) throws IntrospectionException{
		Iterator<Date> it = ws.keySet().iterator();
		String output = "";
		output = "'date', 'tempF', 'windSpeed', 'weatherCode', 'weatherDescription', 'weatherIcon'\n";
		while(it.hasNext()){
			Date date = it.next();
			output += "'" + date.toString() + "', ";
			Weather w = ws.get(date);
			output += w.getTemp() + ", ";
			output += w.getWindSpeed() + ", ";
			output += "'" + w.getWeatherCode() + "', ";
			output += "'" + w.getWeatherDescription() + "', ";
			output += "'" + w.getWeatherIcon() + "',";
			output += "\n";
		}
		return output;
	}
	public String toCSV(){
		String output = "";
		
		output = "'date', 'tempF', 'windSpeed', 'weatherCode', 'weatherDescription', 'weatherIcon'\n";
		Date date = this.date;
		output += "'" + date.toString() + "', ";
		output += this.getTemp() + ", ";
		output += this.getWindSpeed() + ", ";
		output += "'" + this.getWeatherCode() + "', ";
		output += "'" + this.getWeatherDescription() + "', ";
		output += "'" + this.getWeatherIcon() + "',";
		output += "\n";
		return output;
	}

}
