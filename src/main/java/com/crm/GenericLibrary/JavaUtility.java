package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods wrt to Java
 * @Swathi G S
 */

public class JavaUtility {

	/**
	 * This method will generate random number and return it to user
	 * @return 
	 */
	public int getRandomnumber()
	{
		Random ran=new Random();
		int rand = ran.nextInt();
		return rand;
	}
	
	/**
	 * This method will generate current system date and return it to user
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date = d.toString();
		return date;	
	}
	
	/**
	 * This method will generate current system date in format and return it to user
	 * @return
	 */
	
	
	 /*update java utility*/
	  public String getSystemDateInFormat()
		{
			Date d = new Date();
			String d1 = d.toString();
			String[] date = d1.split(" ");
			
		    String mon = date[1];
		    String day = date[2];
		    String time = date[3].replace(":", "-");
		    String year = date[5];
		    
		    String DateFormat = day+"-"+mon+"-"+year+"-"+time;
		    return DateFormat;
		    
			
		}
}
