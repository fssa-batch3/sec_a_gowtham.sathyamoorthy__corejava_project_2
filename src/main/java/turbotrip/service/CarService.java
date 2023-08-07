package turbotrip.service;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import turbotrip.dao.CarDAO;
import turbotrip.dao.exception.DAOException;
import turbotrip.model.Car;
import turbotrip.service.exception.ServiceException;
import turbotrip.validation.CarValidator;
import turbotrip.validation.exception.InvalidUserException;

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
//	    Car car1 = new Car(car.getCarNo());
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
	} 
	
