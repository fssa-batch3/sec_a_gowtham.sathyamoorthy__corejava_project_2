package com.fssa.turbotrip.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.utils.Logger;
import com.fssa.turbotrip.validation.exception.InvalidUserException;

public class UserValidator {
    
    public static boolean validateUser(User user) throws InvalidUserException {
        if (user != null && validateName(user.getUsername()) && validatePassword(user.getPassword())
                && validateEmail(user.getEmail()) && validatePhone(user.getPhone())) {
            return true;
        } else {
            throw new InvalidUserException("User details not valid");
        } 
    }

    public static boolean validateName(String name) throws InvalidUserException {
        if (name == null)
            throw new InvalidUserException("Username is null");

        String regex = "^[A-Za-z]\\w{2,29}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);

        if (m.matches()) {
            return true;
        } else {
            throw new InvalidUserException("Invalid username format Ex: Gowtham");
        }
    }

    public static boolean validatePassword(String password) throws InvalidUserException {
        if (password == null)
            throw new InvalidUserException("Password is null");

        String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";

        if (Pattern.matches(pattern_string, password)) {
            return true;
        } else {
            throw new InvalidUserException("Invalid password format Ex: Password@123");
        }
    }

    public static boolean validateEmail(String email) throws InvalidUserException {
    	if (email == null)
    	    throw new InvalidUserException("Email is null");

    	String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";

    	if (Pattern.matches(regex, email)) {
    	    return true;
    	} else {
    	    throw new InvalidUserException("Invalid email format Ex: john@gmail.com");
    	}

    }

    public static boolean validatePhone(String phone) throws InvalidUserException {
        if (phone == null)
            throw new InvalidUserException("Phone number is null");

        String regex = "^[6789]\\d{9}$";

        if (Pattern.matches(regex, phone)) { 
            return true;
        } else {
            throw new InvalidUserException("Invalid phone number format Ex: 9551555231");
        }
    }
    public void validLoggedUser(User user) throws InvalidUserException {

		if (user == null)
			throw new InvalidUserException("Cannot get user's details");

	}
}
