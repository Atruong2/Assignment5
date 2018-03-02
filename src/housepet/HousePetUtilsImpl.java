package housepet;

import java.io.PrintWriter;

import java.util.Scanner;

public class HousePetUtilsImpl 
{
	// receives: inFile - precondition: inFile is open and ready to read data from
	// file format: pet name {newline} year born {newline} gender {newline} pet type {newline}
	// returns: a single populated HousePet instance with data from inFile if all data is there
	// returns null if no data found (end of input) for a house pet or if any mismatch of data or missing expected data occurs
	public static HousePet readFromScanner (Scanner inFile)
	{
		String aPetName = "";
		int aYearBorn = 0;
		String aGender = "";
		String aPetType = "";
		
		if (inFile.hasNext())
		{
			aPetName = inFile.nextLine();
		}
		else
		{
			return null;
		}
		
		if (inFile.hasNextInt())
		{
			aYearBorn = inFile.nextInt();
			inFile.nextLine();
		}
		else
		{
			return null;
		}
		
		if (inFile.hasNext())
		{
			aGender = inFile.nextLine().trim();
		}
		else 
		{
			return null;
		}
		
		if (inFile.hasNext())
		{
			aPetType = inFile.nextLine().trim();
		}
		else
		{
			return null;
		}
		HousePet housePet = new HousePet (aPetName, aYearBorn, Gender.valueOf(aGender), PetType.valueOf(aPetType));
		return housePet;
	}

	// receives: outFile - precondition: outFile is open and ready to receive output
	// returns: nothing
	// task: received housePet is written to outFile in program readable format
	public static void writeToFile (PrintWriter out, HousePet housePet)
	{
		out.println (housePet.getPetName() + "\n" + housePet.getYearBorn() + "\n" + housePet.getGender() + "\n" + housePet.getPetType());
	}
}
