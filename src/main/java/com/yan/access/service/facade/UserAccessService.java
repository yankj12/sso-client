package com.yan.access.service.facade;

import com.yan.access.vo.ResponseVo;

public interface UserAccessService {

	ResponseVo getSession(String sessID) throws Exception;
	
	ResponseVo checkUserAuth(String userCode, String pwdhash, String sessID) throws Exception;
	
	ResponseVo invalidateSession(String sessID) throws Exception;
}
