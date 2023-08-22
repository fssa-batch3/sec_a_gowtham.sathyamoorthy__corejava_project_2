package com.fssa.turbotrip.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.dao.CarDAO;
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.service.CarService;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.validation.exception.InvalidUserException;

public class TestReadCarList {
	
	public static void main(String[] args) throws ServiceException, InvalidUserException, DAOException {
		
		Car car1 = new Car("TN 08 CD 0099");
		CarDAO c = new CarDAO();
	CarService carService = new CarService();
		System.out.println(carService.listCar(car1));
	}
	
	@Test
	public void testUpdateSuccess() throws ServiceException, InvalidUserException, DAOException {
		CarService carService = new CarService();
		Car car1 = new Car("TN 07 CD 1234");
		String s = carService.listCar(car1);
		String[] split = s.split(",");
		String output = split[0].toLowerCase().trim();
		assertEquals("carnumber: tn 07 cd 1234",output);
	}
	
	
	
	@Test
	public void testUpdateFail() throws ServiceException, InvalidUserException, DAOException {
		CarService carService = new CarService();
		Car car1 = new Car("TN 08 CD 1234");
		String s = carService.listCar(car1);
		String[] split = s.split(",");
	String output = split[0].toLowerCase().trim();
	 assertNotEquals("carnumber: tn 08 cd 0099",output);
	}
	

}