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
 *����
 */
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//���ռ�����
			String code=request.getParameter("code");
			//���ݼ������ѯ�û�
			UserService userService=new UserServiceImpl();
			User user=userService.findByCode(code);
			//����ѯ�����޸��û���״̬
			if(user!=null){
				user.setState(1);//��ʾ�Ѿ�����
				user.setCode(null);
				userService.update(user);
				request.setAttribute("msg","���Ѽ���ɹ������½��");
			}else{
				request.setAttribute("msg", "���ļ��������������¼��");
			}
			//ҳ����ת
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
