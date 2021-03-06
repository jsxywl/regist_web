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
 * 发送邮件的方法
 * @param to:给谁发邮件
 * @param code:邮件的激活码
 * 
 * @author Administrator
 *
 */
public class MailUtils {
	public static void sendMail(String to,String code) throws Exception{
		//创建链接对象，链接到邮箱服务器
		Properties props=new Properties();
		Session session =Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@store.com","123");
			}
			
		});
		//创建邮件对象
		Message message=new MimeMessage(session);
		//设置发件人
		message.setFrom(new InternetAddress("service@store.com"));
		//设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//设置邮件的主题
		message.setSubject("来自XX网站的激活邮件");
		//设置邮件的正文
		message.setContent("<h1>来自XX网站的激活邮件;激活请点击链接：</h1><h3><a href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		//发送邮件
		Transport.send(message);
	}
}
