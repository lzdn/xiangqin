package com.xiangqin.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class WeixinUtil {

	public static final String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

	public static final int DEFAULT_NONCESTR_LENGTH = 16;

	public static final String URL = "http://mp.weixin.qq.com?params=value";
	public static final String JS_ACCESS_TOKEN_API = "https://api.weixin.qq.com/cgi-bin/token";
	public static final String JS_WX_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	public static final String APP_ID = "wx2a44e25c42aad6df";
	public static final String APP_SECRET = "35e6f757f9e949e2d8a117fbcbf2b0d8";

	// 生成随机字符串
	public static String generateNonceStr(Random random, String characters, int length) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);
	}

	public static String defaultNonceStr() {
		return generateNonceStr(new Random(), SOURCES, DEFAULT_NONCESTR_LENGTH);
	}

	public static String signature(String jsapi_ticket) {
		String timestamp = Long.toString(System.currentTimeMillis() / 1000);
		String noncestr = defaultNonceStr();
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="
				+ URL;
		return SHA1(str);
	}

	public static String SHA1(String str) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1"); // 如果是SHA加密只需要将"SHA-1"改成"SHA"即可
			digest.update(str.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexStr = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexStr.append(0);
				}
				hexStr.append(shaHex);
			}
			return hexStr.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAccessToken(String appId, String appSecret) {
		if (StringUtils.isEmpty(appId))
			appId = APP_ID;
		if (StringUtils.isEmpty(appSecret))
			appSecret = APP_SECRET;
		return HttpUtil.sendGet(JS_ACCESS_TOKEN_API,
				"grant_type=client_credential&appid=" + appId + "&secret=" + appSecret);
	}

	public String getTicket(String access_token) {
		//?access_token=ACCESS_TOKEN&type=jsapi
		return  HttpUtil.sendGet(JS_ACCESS_TOKEN_API, "access_token="+access_token+"&type=jsapi");
	}

	public static void main(String[] args) {
		String str = generateNonceStr(new Random(), SOURCES, DEFAULT_NONCESTR_LENGTH);
		System.out.println(str);
	}
}
