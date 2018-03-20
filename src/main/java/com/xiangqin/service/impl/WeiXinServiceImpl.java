package com.xiangqin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangqin.service.WeiXinService;
import com.xiangqin.utils.RedisUtil;
import com.xiangqin.utils.WeixinUtil;

@Service
public class WeiXinServiceImpl implements WeiXinService {

	@Autowired
	private RedisUtil redisUtil;

	@Override
	public String getSignature() {
		String accestoken = null;
		String jsticket = null;
		Object accestokenvalue = redisUtil.get(WeixinUtil.ACCESS_TOKEN_CACHE_KEY);
		if (accestokenvalue == null) {
			accestoken = WeixinUtil.getAccessToken(WeixinUtil.APP_ID, WeixinUtil.APP_SECRET);
			redisUtil.set(WeixinUtil.ACCESS_TOKEN_CACHE_KEY, accestoken, 7200L);
		}
		Object ticket = redisUtil.get(WeixinUtil.TICKET_CACHE_KEY);
		if (ticket == null) {
			jsticket = WeixinUtil.getTicket(accestoken);
			redisUtil.set(WeixinUtil.TICKET_CACHE_KEY, jsticket, 7200L);
		}

		// Object accestokenvalue = redisUtil.get(WeixinUtil.ACCESS_TOKEN_CACHE_KEY);
		// String jsticket = WeixinUtil.getTicket(accestoken);

		return null;
	}

}
