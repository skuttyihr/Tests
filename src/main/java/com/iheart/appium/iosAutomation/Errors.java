package com.iheart.appium.iosAutomation;
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
		err = new StringBuilder("\n");
	}
	public Errors(String s){
		numberOfErrors = 0;
		err = new StringBuilder("\n" + s);
	}
	
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
	
	public void add(String s){
		numberOfErrors++;
		if(s.endsWith("\n"))
			err.append(s);
		else
			err.append(s + "\n");
	}
	// Added to make converting from StringBuilder easier, but the add is likely preferred (less typing)
	public void append(String s){
		add(s);
	}
}
