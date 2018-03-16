package com.yan.access.service.impl;

import java.net.URI;

import org.apache.http.client.utils.URIBuilder;

import com.yan.access.schema.SsoServerConfig;
import com.yan.access.service.facade.UserAccessService;
import com.yan.access.util.HttpJsonUtil;
import com.yan.access.vo.ResponseVo;

public class UserAccessServiceImpl implements UserAccessService{

	private SsoServerConfig ssoServerConfig;
	
	@Override
	public ResponseVo getSession(String ticket) throws Exception{
		URI uri = new URIBuilder()
                .setScheme(ssoServerConfig.getProtocol())
                .setHost(ssoServerConfig.getIp())
                .setPort(ssoServerConfig.getPort())
                .setPath("/ssoweb/UserAccessIntfServlet")
                .setParameter("intfCode", "getSession")
                .setParameter("ticket", ticket)
                .build();
		ResponseVo responseVo = HttpJsonUtil.sendGetRequest(uri);
		return responseVo;
	}

	@Override
	public ResponseVo checkUserAuth(String userCode, String pwdhash, String ticket) throws Exception {
		URI uri = new URIBuilder()
				.setScheme(ssoServerConfig.getProtocol())
                .setHost(ssoServerConfig.getIp())
                .setPort(ssoServerConfig.getPort())
                .setPath("/ssoweb/UserAccessIntfServlet")
                .setParameter("intfCode", "checkUserAuth")
                .setParameter("userCode", userCode)
                .setParameter("pwdhash", pwdhash)
                .setParameter("ticket", ticket)
                .build();
		ResponseVo responseVo = HttpJsonUtil.sendGetRequest(uri);
		return responseVo;
	}

	@Override
	public ResponseVo invalidateSession(String ticket) throws Exception{
		URI uri = new URIBuilder()
				.setScheme(ssoServerConfig.getProtocol())
                .setHost(ssoServerConfig.getIp())
                .setPort(ssoServerConfig.getPort())
                .setPath("/ssoweb/UserAccessIntfServlet")
                .setParameter("intfCode", "invalidateSession")
                .setParameter("userCode", "")
                .setParameter("ticket", ticket)
                .build();
		ResponseVo responseVo = HttpJsonUtil.sendGetRequest(uri);
		return responseVo;
	}

	public SsoServerConfig getSsoServerConfig() {
		return ssoServerConfig;
	}

	public void setSsoServerConfig(SsoServerConfig ssoServerConfig) {
		this.ssoServerConfig = ssoServerConfig;
	}

}
