package com.tianmg.dubbot.utils;

public class HttpParam {
		private String  name;
		private Object  value;
		
		public HttpParam(String name , Integer value){
				this.name  = name;
				this.value = value;
		}
		
		public HttpParam(String name , String value){
			this.name  = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
		
		
		
}
