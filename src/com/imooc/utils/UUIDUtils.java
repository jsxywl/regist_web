package com.imooc.utils;

import java.util.UUID;

/**
 * Ëæ»úÉú³É×Ö·û´®
 * @author Administrator
 *
 */
public class UUIDUtils {
	public static String getUUID(){
		String randomUUID =UUID.randomUUID().toString().replace("-","");
		return randomUUID;
	}
}
