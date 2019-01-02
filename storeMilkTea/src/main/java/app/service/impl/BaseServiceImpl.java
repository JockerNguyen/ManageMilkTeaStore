package app.service.impl;

import app.dao.UserDAO;

public class BaseServiceImpl {
	public UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	

}
