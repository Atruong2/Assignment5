package housepetlist;

import java.io.PrintWriter;
import java.util.Scanner;

import housepet.HousePetUtilsImpl;
import housepetlist.HousePetListImpl;
import housepet.Gender;
import housepet.HousePet;
import housepet.PetType;

public class HousePetListUtilsImpl 
{
	// pre: inFile is open and ready to read data from
	// post: populates aList with any house pets found on scanner
	//   invalid data on scanner stops reading 
	//   stops reading when end of input or when aList reaches MAX_SIZE
	//   or when attempting to read an account and bad data is found
	// Example use: Scanner infile = new Scanner(new File("test.txt"));
	//              HousePetList myList = new HousePetList();
	//              readFromScanner(infile, myList);  
	public static void readFromScanner(Scanner scanner, HousePetList aList)
	{
		while (scanner.hasNext() && aList.getSize() < HousePetList.MAX_SIZE)
		{
			HousePet pet = HousePetListUtilsImpl.readFromScanner(scanner);
			
			if (pet != null)
				aList.add(pet);
		}
	}

	//receives: out, a PrintWriter that is open and ready to write to,
	//  aList, a HousePetList instance to write out to the given PrintWriter
	// pre: out is open and ready to write to
	// post: out contains current house pet list in program readable format
	public static void writeToFile (PrintWriter out, HousePetList aList)
	{
		for (int i = 0; i < aList.getSize(); i++)
		{
			out.println (String.valueOf(aList));
			// out.println (((HousePet) aList).getPetName() + "\n" + ((HousePet) aList).getYearBorn() + "\n" + ((HousePet) aList).getGender() + "\n" + ((HousePet) aList).getPetType());
		}
	}
}
