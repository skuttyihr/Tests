package com.iheart.appium.iosAutomation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Essentially a container for a StringBuilder, ensures the new line character is placed at the end of each new error
 * Puts a new line after each error (and before the first one for easier output)
 * Keeps track of number of failures
 * @author daniellegolinsky
 *
 */
public class Errors {
	private StringBuilder err;
	private int numberOfErrors = 0;
	
	public Errors(){
		numberOfErrors = 0;
		err = new StringBuilder();
	}
	public Errors(String s){
		numberOfErrors = 0;
		err = new StringBuilder(s);
	}
	
	/**
	 * Output errors as a list
	 * @return
	 */
	public List<String> getErrorList(){
		List<String> errorList = null;
		
		if(numberOfErrors > 0){
			try{
				errorList = new LinkedList<String>(Arrays.asList(err.toString().split("\n")));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			if(errorList != null && errorList.size() > 1){
				errorList.remove(0); // First index is a blank string due to the string starting with the newline character
			}
			
			if (numberOfErrors != errorList.size()){
				System.out.println("Inconsistency between number of errors and length of list of errors!");
			}
		}
		
		return errorList;
	}
	
	/**
	 * Output the error list as a string
	 * @return
	 */
	public String getErrors(){
		if(numberOfErrors > 0){
			if(err != null)
				return err.toString();
			else
				return "";
		}
		else
			return "";
	}
	// Makes conversion from StringBuilder a little easier.
	public String toString(){
		return getErrors();
	}
	
	/**
	 * Returns the number of errors stored in this instance
	 */
	public int howMany(){
		return numberOfErrors;
	}
	
	public boolean contains(String s){
		return err != null && err.toString().contains(s);
	}
	
	/**
	 * Adds an error to the list of issues
	 * @param s
	 */
	public void add(String s){
		if(s != null && s.length() > 0){
			if(numberOfErrors == 0){
				err.append("\n"); // Make sure the string will start on a new line, for assert output
			}
			numberOfErrors++;
			if(s.endsWith("\n"))
				err.append(s);
			else
				err.append(s + "\n");
		}
	}
	
	// Added to make converting from StringBuilder easier, but the add is likely preferred (less typing)
	public void append(String s){
		add(s);
	}
	
	public void remove(String s){
		remove(s, true);
	}
	/**
	 * Removes a string from the error list, optionally allows it to reduce the number of errors by 1
	 * @param s
	 * @param removeError
	 */
	public void remove(String s, boolean removeError){
		if (err.toString().contains(s)){
			int sIndex = err.toString().indexOf(s);
			int eIndex = sIndex + s.length();
			eIndex += 1; // To account for the newline character added to each error
			err.replace(sIndex, eIndex, "");
			if(removeError){
				numberOfErrors--;
			}
		}
	}
}
