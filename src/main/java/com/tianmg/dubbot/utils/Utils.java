package com.tianmg.dubbot.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Utils {
	public static Properties conf;
	
	public static String getProperty(String key){
		if(conf==null){
			conf = new Properties();
			InputStream in = null;
			try {
				in = Utils.class.getResourceAsStream("/conf.properties");
				conf.load(in);
				
			} catch (IOException e) {			
				e.printStackTrace();
				conf = new Properties();
			}
			finally{
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return conf.getProperty(key);
	}
	
}
