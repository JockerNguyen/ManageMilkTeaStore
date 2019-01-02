package app.service.impl;

import java.io.Serializable;

import app.bean.UserInfo;
import app.service.UserService;
import app.util.ConvertModelToBean;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public UserInfo findById(Serializable key, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo saveOrUpdate(UserInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UserInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo findUserInfoByUsername(String userName) {
		try {
			return ConvertModelToBean.mapUserToUserInfo(userDAO.loadUserByUserName(userName));
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public boolean checkLogin(UserInfo userInfo) {
		try {
			return false;
		}catch (Exception e){
			return false;
		}

	}

	@Override
	public boolean createUser(UserInfo userInfo) {
		return false;
	}

}
