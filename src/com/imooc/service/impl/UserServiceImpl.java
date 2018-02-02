package com.imooc.service.impl;

import java.sql.SQLException;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.utils.MailUtils;

public class UserServiceImpl implements UserService {

	@Override
	public void regist(User user) throws Exception {
		//将数据存储到数据库
		UserDao userDao=new UserDaoImpl();
		userDao.regist(user);
		//发送一封激活邮件
		MailUtils.sendMail(user.getEmail(), user.getCode());
	}

	@Override
	public User findByCode(String code) throws Exception {
		UserDao userDao=new UserDaoImpl();
		
		return userDao.findByCode(code);
	}

	@Override
	public void update(User user) throws Exception {
		UserDao userDao=new UserDaoImpl();
		userDao.update(user);
	}

}
