package com.imooc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;

/**
 *激活
 */
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//接收激活码
			String code=request.getParameter("code");
			//根据激活码查询用户
			UserService userService=new UserServiceImpl();
			User user=userService.findByCode(code);
			//若查询到则修改用户的状态
			if(user!=null){
				user.setState(1);//表示已经激活
				user.setCode(null);
				userService.update(user);
				request.setAttribute("msg","您已激活成功，请登陆！");
			}else{
				request.setAttribute("msg", "您的激活码有误，请重新激活！");
			}
			//页面跳转
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
