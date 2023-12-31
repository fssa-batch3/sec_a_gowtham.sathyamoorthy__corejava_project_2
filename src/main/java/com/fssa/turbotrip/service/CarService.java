package com.fssa.turbotrip.service;

import java.sql.SQLException; 
import java.util.List;

import com.fssa.turbotrip.dao.CarDAO;
import com.fssa.turbotrip.dao.UserDAO;
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.utils.Logger;
import com.fssa.turbotrip.validation.CarValidator;
import com.fssa.turbotrip.validation.exception.InvalidCarException;

// This code is checking all the validation or matched to the given input or not !
public class CarService { 
	static Logger log = new Logger();

	public boolean createCar(Car car) throws ServiceException {
		CarDAO carDAO = new CarDAO();
		try {
			CarValidator.validateCar(car);
			if (carDAO.createCar(car)) {
				log.debug(car.getCarNo() + " Successfully Your Car registered!");
				return true;
			} else {
				log.debug("not successfully added");
				return false;
			}

		} catch (DAOException | InvalidCarException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	// this code is checking the list cars to read cars

	public String listCar(Car car) throws DAOException {
		CarDAO CarDAO = new CarDAO();
		return CarDAO.readCar(car);
	}

	// this code is checking the update cars from the CarList

	public boolean updateCar(Car car, String Carno) throws ServiceException, InvalidCarException, DAOException {
		CarDAO carDAO = new CarDAO();
		try {
			CarValidator.validateupdateCar(car);
				if (carDAO.updateCar(car, Carno)) {
					log.debug(Carno + " Successfully Your Car updated!");
					return true;
				} else { 
					return false;
				}

		} catch (DAOException | InvalidCarException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	// this code is checking the delete cars from the CarList
	public boolean deleteCar(String Carno, int isDeleted) throws ServiceException, DAOException {
		CarDAO carDAO = new CarDAO();
		try {
			if (carDAO.sameNumberExist(Carno)) {
				if (carDAO.deleteCar(Carno, isDeleted)) {

					log.debug("Car " + Carno + " Successfully Deleted!");
					return true;
				} else {
					return false;
				}
			} else {
				log.debug("this car doesn't here!");
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	public List<Car> getAllCarlists(int id) throws ServiceException {
		try {
			CarDAO carDAO = new CarDAO();
			return carDAO.getAllCars(id);
		} catch (DAOException e) {
			throw new ServiceException(e);

		}

	}

	public int findIdByEmail(String email) throws ServiceException {
		int user;
		try {
			user = UserDAO.findIdByEmail(email);
			return user;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
