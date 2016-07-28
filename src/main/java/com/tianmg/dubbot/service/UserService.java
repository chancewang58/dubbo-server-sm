/**
 * 
 */
package com.tianmg.dubbot.service;

import com.tianmg.dubbot.bean.UserBean;

/**
 *
 * @author TianMingGang
 * 2016年3月8日
 */
public interface UserService {
	/**
	 * 新增用户
	 * @author TianMingGang
	 * 2016年3月8日
	 * @param userBean
	 * @return
	 */
	int addUser(String userName,String password,int age);
}
