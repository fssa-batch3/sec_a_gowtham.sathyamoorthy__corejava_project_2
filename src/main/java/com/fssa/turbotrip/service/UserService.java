 package com.fssa.turbotrip.service;
import com.fssa.turbotrip.dao.UserDAO;
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.validation.UserValidator;
import com.fssa.turbotrip.validation.exception.InvalidUserException;
public class UserService {
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			if (userDAO.createUser(user)) {
				System.out.println(user.getEmail() + "Successfully registered!");
				return true;
			} else {
				System.out.println("not successfully added");
				return false;
			}

		} catch (DAOException | InvalidUserException e) { 
			throw new ServiceException(e);
		}
		
		}
		public boolean loginUser(User user) throws ServiceException {

			try {
				UserValidator.validateEmail(user.getEmail());
				UserValidator.validatePassword(user.getPassword());

				UserDAO userDAO = new UserDAO();
				if (userDAO.login(user)) {
					System.out.println(user.getEmail() + " Successfully logged in");
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				throw new ServiceException(e.getLocalizedMessage());
			}

		

	}

	
	
}