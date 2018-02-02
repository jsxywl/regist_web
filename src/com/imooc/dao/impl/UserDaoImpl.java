package com.imooc.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.imooc.dao.UserDao;
import com.imooc.domain.User;
import com.imooc.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	//DAO中保存用户的方法
	public void regist(User user) throws Exception {
		QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
		String sql="insert into user values(?,?,?,?,?,?,?)";
		Object[] prams={user.getUid(),user.getUsername(),user.getPassword(),
				user.getNickname(),user.getEmail(),user.getState(),user.getCode()};
		queryRunner.update(sql,prams);
	}

	@Override
	public User findByCode(String code) throws Exception {
		QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user where code=?";
		User user=queryRunner.query(sql, new BeanHandler<User>(User.class),code);
		
		return user;
	}

	@Override
	public void update(User user) throws Exception {
		QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
		String sql="update user set username=?,password=?,nickname=?,email=?,state=?,code=? where uid=?";
		Object[] prams={user.getUsername(),user.getPassword(),user.getNickname(),
				user.getEmail(),user.getState(),user.getCode(),user.getUid()};
		queryRunner.update(sql, prams);
	}

}
