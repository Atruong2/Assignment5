package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MyUtils {
	//pre: none
		//post: returns a String formatted with first letter of each word in uppercase
		//      all letters after first letter in word in lowercase
		//      all extra spaces removed before and after each word
		public static String properFormat(String theName)
		{
			String temp = "";
			boolean atSpace=true; // so that first letter gets capitalized...
			theName = theName.trim();
			for(int i=0; i< theName.length(); i++)
			{
				if(Character.isWhitespace(theName.charAt(i)) && !atSpace)
				{
					atSpace=true;
					temp += ' ';
				}
				else if (atSpace == true)
				{
					if(!Character.isWhitespace(theName.charAt(i)))
					{
						temp += Character.toUpperCase(theName.charAt(i));
						atSpace = false;
					}
				}
				else
				{
					temp += Character.toLowerCase(theName.charAt(i));
					atSpace = false;
				}
			}// end for
			return temp;
		}
	
		
		//pre: none
		//post:returns the number of newlines in the given String
		public static int numberLines(String data)
		{
			int count=0;
			for(int i=0; i<data.length(); i++)
			{
				if (data.charAt(i) =='\n')
					count++;
			}
			return count;
		}
		
		public static String dateToString(GregorianCalendar date)
		// receives: a date as a GregorianCalendar instance
		// returns: received date as a string in format mm/dd/yyyy
		{  
			String temp="";
			int month = date.get(Calendar.MONTH);
			month++; // add 1 due to zero-based months
			int day = date.get(Calendar.DAY_OF_MONTH);
			int year = date.get(Calendar.YEAR);
			temp = month + "/" + day + "/" + year;
			return temp;
		}
		public static GregorianCalendar stringToDate(String theDate)
		// receives: theDate as a String in format mm/dd/yyyy
		//  pre:  theDate is in format mm/dd/yyyy
		// returns: received date as a correct GregorianCalendar object
		{
			StringTokenizer tokenizer = new StringTokenizer(theDate, "/");
			String temp = tokenizer.nextToken();  // grabs up to "/"
			int month=0, day=1, year=2000;  // default date values
			try {
				month = Integer.parseInt(temp);
				month--;  // zero-based months
				temp = tokenizer.nextToken();
				day = Integer.parseInt(temp);
				temp = tokenizer.nextToken();
				year = Integer.parseInt(temp);
			}
			catch(NumberFormatException e) {
				System.out.println("error extracting date, using default date");
			}
			return new GregorianCalendar(year, month, day);
		}
		public static String stripSpaces(String theId) {
			// TODO Auto-generated method stub
			String temp="";
			int count=0;
			for(int i=0; i< theId.length(); i++)
			{
				if(!Character.isWhitespace(theId.charAt(i)))
						{
						temp += theId.charAt(i);
						count ++;
						if(count == 6)
							break;
						}
			}
			return temp;
		}
		public static boolean isValid(String aString)
		{
			for(int i=0; i< aString.length(); i++)
			{
				if(!Character.isLetterOrDigit(aString.charAt(i)))
						return false;
			}
			return true;
		}
		//pre: none
		//post: returns a String of the first maxLength alphanumeric characters in given theId
		//  returns empty string if theId is empty or contains no alphanumeric chars.
		public static String stripNonAlpha(String theId, int maxLength) {
			// TODO Auto-generated method stub
			String temp="";
			int count=0;
			for(int i=0; i< theId.length(); i++)
			{
				if(Character.isAlphabetic(theId.charAt(i)) ||
						Character.isDigit(theId.charAt(i)))
						{
						temp += theId.charAt(i);
						count ++;
						if(count == maxLength)
							break;
						}
			}
			return temp;
		}
       //pre: none
	   // post: prints timeStamp to std output with date(yyyy-mm-dd) and time (HH:mm:ss) and descriptor
	   //        descriptor is begins or ends or currently or some such indicator of what the time is describing
	   public static void printTimeStamp(String descriptor)
	   {
		   String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
			System.out.println("Execution " + descriptor + "  at: " + timeStamp);
	   }
	   //receives: nothing
	   // returns name of student entered from keyboard
	   // proper formats name and returns it
	   public static String getNameFromStudent()
	   {
	 	  Scanner in = new Scanner(System.in);
	 	  System.out.print("Enter your name: " );
	 	  String s1 = in.nextLine();
	 	  s1 = utils.MyUtils.properFormat(s1);
	 	  return s1;
	   }
}