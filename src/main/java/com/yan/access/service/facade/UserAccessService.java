package com.yan.access.service.facade;

import com.yan.access.vo.ResponseVo;

public interface UserAccessService {

	ResponseVo getSession(String sessID) throws Exception;
	
	ResponseVo checkUserAuth(String userCode, String pwdhash) throws Exception;
	
	ResponseVo invalidateSession(String userCode) throws Exception;
}
