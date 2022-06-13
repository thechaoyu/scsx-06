package com.itzheng.utils;

import java.util.UUID;

public class UploadUtils {
	/**
	 * 获取随机名称
	 * 
	 * @param realName 真实名称
	 * @return uuid
	 */
	public static String getUUIDName(String realName) {
		// realname 可能是 1.jpg 也可能是 1
		// 获取后缀名
		int index = realName.lastIndexOf(".");//获取到.所在的位置
		if (index == -1) {//判断获取到的.是否为-1,也就是文件是否是没有后缀的
			return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		} else {
			return UUIDUtils.getId()+ realName.substring(index);//通过位置获取到对应.后面的名称在加上前面生成的对应随机的名称
		}
	}

	/**
	 * 获取文件真实名称
	 * 
	 * @param name
	 * @return
	 */
	public static String getRealName(String name) {
		// c:/upload/1.jpg 1.jpg
		// 获取最后一个"/"
		int index = name.lastIndexOf("\\");
		return name.substring(index + 1);
	}

	/**
	 * 获取文件目录
	 * 
	 * @param name 文件名称
	 * @return 目录
	 */
	public static String getDir(String name) {
		//任意的一个对象都有一个hash码
		int i = name.hashCode();
		System.out.println(i);
		//将hash码转成16进制的字符串//-1351534400--->af7138c0
		String hex = Integer.toHexString(i);
		System.out.println(hex);
		int j = hex.length();
		for (int k = 0; k < 8 - j; k++) {
			hex = "0" + hex;
		}
		return "/" + hex.charAt(0) + "/" + hex.charAt(1) + "/" + hex.charAt(2) + "/" + hex.charAt(3) + "/"
				+ hex.charAt(4) + "/" + hex.charAt(5) + "/" + hex.charAt(6) + "/" + hex.charAt(7);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// String s="G:\\day17-基础加强\\resource\\1.jpg";
		//String s = "1.jgp";
		// realName = getRealName(s);
		// System.out.println(realName);

		//String uuidName = getUUIDName(realName);
		// System.out.println(uuidName);
		//调用该函数生成一个随机的目录结构
		String dir = getDir("AAAAAAAAAAAA");
		///a/f/7/1/3/8/c/0
		System.out.println(dir);

	}
}
