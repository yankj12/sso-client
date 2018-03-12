package com.yan.access.service.facade;

import com.yan.access.vo.ResponseVo;

public interface UserAccessService {

	ResponseVo getSession(String ticket) throws Exception;
	
	ResponseVo checkUserAuth(String userCode, String pwdhash, String ticket) throws Exception;
	
	ResponseVo invalidateSession(String ticket) throws Exception;
}
