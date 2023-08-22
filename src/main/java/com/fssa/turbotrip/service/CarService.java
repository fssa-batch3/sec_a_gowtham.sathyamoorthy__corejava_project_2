package com.fssa.turbotrip.service;

import java.sql.SQLException;

import com.fssa.turbotrip.dao.CarDAO;
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.validation.CarValidator;
import com.fssa.turbotrip.validation.exception.InvalidUserException;

public class CarService {
	public boolean createCar(Car car) throws ServiceException {
		CarDAO carDAO = new CarDAO();
		try {
			CarValidator.validateCar(car);
			if (carDAO.createCar(car)) {
				System.out.println(car.getCarNo() + " Successfully Your Car registered!");
				return true;
			} else {
				System.out.println("not successfully added");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// list cars

	public String listCar(Car car) throws ServiceException, InvalidUserException, DAOException {
		CarDAO CarDAO = new CarDAO();
		return CarDAO.readCar(car);
	}
 
	//update cars
	
	
	public boolean updateCar(Car car , String Carno) throws ServiceException, InvalidUserException, DAOException {
		CarDAO carDAO = new CarDAO();
		try {
			if(CarValidator.validateupdateCar(car)) {
			if (CarDAO.updateCar(car,Carno)) {
				System.out.println(Carno + " Successfully Your Car updated!");
				return true;
			} else {
				System.out.println("not successfully updated");
				return false;
			}
			} else {
				System.out.println("not successfully updated");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	
	}
	
	// delete course
		public static boolean deleteCar(String Carno, int isDeleted) throws ServiceException, DAOException {
			CarDAO carDAO = new CarDAO();
			try {
				if (carDAO.sameNumberExist(Carno) ) {
					if (carDAO.deleteCar(Carno, isDeleted)) {
						System.out.println("Car " + Carno + " Successfully Deleted!");
						return true;
					} else {
						return false;
					}
				} else {
					System.out.println("this car doesn't here!");
					return false;
				}
			} catch (SQLException e) {
				throw new ServiceException(e);
			}
		}
} 
	