package com.imooc.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * �����ʼ��ķ���
 * @param to:��˭���ʼ�
 * @param code:�ʼ��ļ�����
 * 
 * @author Administrator
 *
 */
public class MailUtils {
	public static void sendMail(String to,String code) throws Exception{
		//�������Ӷ������ӵ����������
		Properties props=new Properties();
		Session session =Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@store.com","123");
			}
			
		});
		//�����ʼ�����
		Message message=new MimeMessage(session);
		//���÷�����
		message.setFrom(new InternetAddress("service@store.com"));
		//�����ռ���
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//�����ʼ�������
		message.setSubject("����XX��վ�ļ����ʼ�");
		//�����ʼ�������
		message.setContent("<h1>����XX��վ�ļ����ʼ�;�����������ӣ�</h1><h3><a href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		//�����ʼ�
		Transport.send(message);
	}
}
