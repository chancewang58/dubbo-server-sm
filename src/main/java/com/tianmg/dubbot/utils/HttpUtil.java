package com.tianmg.dubbot.utils;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtil {
		
		public static String post(String url ,List<HttpParam> params){
			return http("get", url, params,null);
		}
		
		public static String post(String url ,String httpEntity){
				return http("post", url, null, httpEntity);
		}
		
		private static String http(String type , String url ,  List<HttpParam> params , String httpEntity){
			CloseableHttpClient httpclient = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(60000)
					.setConnectTimeout(60000).setSocketTimeout(60000).build();
			ResponseHandler<String> responseHandler = new BasicResponseHandler(); 
			try {
					
					if("post".equals(type)){
						HttpPost http = new HttpPost(url);	
						http.setConfig(requestConfig);
						if(params!=null&&params.size()>0){
							List <NameValuePair> nvps = new ArrayList <NameValuePair>();
							for(HttpParam p:params){
								nvps.add(new BasicNameValuePair(p.getName(),p.getValue().toString()));
							}
							http.setEntity(new UrlEncodedFormEntity(nvps));
						}
						if(httpEntity!=null&&httpEntity.length()>0){
							http.setEntity(new StringEntity(httpEntity,"UTF-8"));
						}
						String body = httpclient.execute(http,responseHandler);
						return body;
					}else{
						HttpGet http = new HttpGet(url);
						http.setConfig(requestConfig);
						String 	body = httpclient.execute(http,responseHandler);
						return body;	
					}
			} catch(Exception e){
				//e.printStackTrace();
			}
			
			return null;
		}
}
