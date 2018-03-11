package com.yan.access.service.impl;

import java.net.URI;

import org.apache.http.client.utils.URIBuilder;

import com.yan.access.service.facade.UserAccessService;
import com.yan.access.util.HttpJsonUtil;
import com.yan.access.vo.ResponseVo;

public class UserAccessServiceImpl implements UserAccessService{

	@Override
	public ResponseVo getSession(String sessID) throws Exception{
		URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("localhost")
                .setPort(8080)
                .setPath("/ssoweb/UserAccessIntfServlet")
                .setParameter("intfCode", "getSession")
                .setParameter("sessID", sessID)
                .build();
		ResponseVo responseVo = HttpJsonUtil.sendGetRequest(uri);
		return responseVo;
	}

	@Override
	public ResponseVo checkUserAuth(String userCode, String pwdhash, String sessID) throws Exception {
		URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("localhost")
                .setPort(8080)
                .setPath("/ssoweb/UserAccessIntfServlet")
                .setParameter("intfCode", "checkUserAuth")
                .setParameter("userCode", userCode)
                .setParameter("pwdhash", pwdhash)
                .setParameter("sessID", sessID)
                .build();
		ResponseVo responseVo = HttpJsonUtil.sendGetRequest(uri);
		return responseVo;
	}

	@Override
	public ResponseVo invalidateSession(String sessID) throws Exception{
		URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("localhost")
                .setPort(8080)
                .setPath("/ssoweb/UserAccessIntfServlet")
                .setParameter("intfCode", "invalidateSession")
                .setParameter("userCode", "")
                .setParameter("sessID", sessID)
                .build();
		ResponseVo responseVo = HttpJsonUtil.sendGetRequest(uri);
		return responseVo;
	}

}
