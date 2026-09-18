/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;
import java.util.Scanner;
/**
 *
 * @author Lerato
 */

public class Login {

     //Creating a method to check the username meets the requirements
     //username must contain underscore and must be 5 or less characters
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    //Create a method to check the password meets the requirements
    //password must contain symbol,captal letter and length 
    public boolean checkPasswordComplexity(String password) {
        String capital = ".*[A-Z].*";
        String small = ".*[a-z].*";
        String special = ".*[!@#$%^&*(),.?\":{}|<>].*";
        String digit = ".*\\d.*";
        return password.length() >= 8 && password.matches(capital) && password.matches(small) && password.matches(special) && password.matches(digit);
    }

       //Create a method to check cellphone number with country code
    public boolean checkCellPhoneNumber(String phone) {
        if (phone.length() <= 12 && phone.startsWith("+27")) {
            int fourthDigit = Character.getNumericValue(phone.charAt(3));
            return fourthDigit >= 6 && fourthDigit <= 8;
        }
        return false;
    }

   
    public String registerUser(String username, String password, String phone) {

        if (checkUserName(username)&& checkPasswordComplexity(password) && checkCellPhoneNumber(phone)) {

            return "User is successfully registered";
        }
        return "User registration failed";
    }


    public boolean loginUser( String storedUsername, String storedPassword,String enteredUsername, String enteredPassword) {
        return storedUsername.equals(enteredUsername)&& storedPassword.equals(enteredPassword);
    }

 
    public String returnLoginStatus( boolean loginStatus, String firstName,String lastName) {

        if (loginStatus) {

            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }
}