/**
 * 
 */
package com.tianmg.dubbot.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author TianMingGang 2016年3月8日
 */
public class UserBean implements Serializable {
	private static final long serialVersionUID = -7240530269505053856L;

	private String userName;
	private String password;
	private int age;

	// private String serverNo; //dubbo server编号,标记改条数据来自于哪个serever

	/**
	 * @auth TianMingGang
	 */
	public UserBean() {
		super();
	}

	public UserBean(String userName, String password, int age) {
		super();
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
