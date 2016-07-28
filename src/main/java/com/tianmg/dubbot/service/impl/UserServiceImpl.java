/**
 * 
 */
package com.tianmg.dubbot.service.impl;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.tianmg.dubbot.bean.UserBean;
import com.tianmg.dubbot.dao.UserDao;
import com.tianmg.dubbot.service.UserService;
import com.tianmg.dubbot.utils.Utils;

/**
 *
 * @author TianMingGang
 * 2016年3月8日
 */
@Service
public class UserServiceImpl implements UserService{


	@Override
	public int addUser(String userName, String password, int age) {
		UserBean ub = new UserBean(userName, password, age);
		int rtn = 0;
		try {
			rtn =  new UserDao().saveUser(ub);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rtn;
	}

}
