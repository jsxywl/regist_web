package com.imooc.utils;

import java.util.UUID;

/**
 * ��������ַ���
 * @author Administrator
 *
 */
public class UUIDUtils {
	public static String getUUID(){
		String randomUUID =UUID.randomUUID().toString().replace("-","");
		return randomUUID;
	}
}
