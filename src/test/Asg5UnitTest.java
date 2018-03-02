package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

import housepet.Gender;
import housepet.HousePet;
import housepet.HousePetUtilsImpl;
import housepet.PetType;
import housepetlist.HousePetList;
import housepetlist.HousePetListImpl;
import housepetlist.HousePetListUtilsImpl;
import utils.MyUtils;

public class Asg5UnitTest {

	private String sName;
	@Test
	public void test() {
		sName=utils.MyUtils.getNameFromStudent();
		housePetTest();
		housePetListTestSizeContainsAdd();
		housePetListTestGetFind();
		housePetListTestFindByNameFindByPetType();
		housePetListTestSortRemoveClear();
		housePetListUtilsTest();
	}
	public void housePetListTestGetFind()
	{

		utils.MyUtils.printTimeStamp(sName + " BEGINS HousePetListTestGetFind Test");

		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet("sporty sport", 2016, Gender.MALE, PetType.DOG);
		HousePet pet3 = new HousePet("Shirley   ann MARIE ", 2011, Gender.FEMALE, PetType.BIRD);
		HousePet pet4 = new HousePet("Joe mark jr.", 2014, Gender.MALE, PetType.POTBELLY_PIG);
		HousePetList list1 = new HousePetListImpl();
		System.out.println(sName + " ** Testing find() and get() **");
		assertTrue(list1.get(0) == null);
		assertTrue(list1.get(-55) == null);
		assertTrue(list1.get(600) == null);
		assertTrue(list1.find(pet1) == -1);
		assertTrue(list1.find(pet2) == -1);
		assertTrue(list1.find(pet3) == -1);
		list1.add(pet2);
		assertTrue(list1.find(pet2) == 0);
		assertTrue(list1.get(0).equals(pet2));
		assertFalse(list1.get(0).equals(pet3));
		list1.add(pet4);
		assertTrue(list1.find(pet4) == 1);
		assertTrue(list1.get(1).equals(pet4));
		list1.add(pet3);
		assertTrue(list1.find(pet3) == 2);
		assertTrue(list1.get(2).equals(pet3));
		assertTrue(pet1.equals(pet1));
		assertFalse(pet2.equals(pet3));
		assertTrue(pet2.equals(pet2));
		pet1.setPetName("joe mark jr.  ");
		assertFalse(pet1.equals(pet4));
		pet1.setYearBorn(2014);
		assertFalse(pet1.equals(pet4));
		pet1.setPetType(PetType.POTBELLY_PIG);
		assertTrue(pet1.equals(pet4));
		pet1.setGender(Gender.MALE);
		assertTrue(pet1.equals(pet4));
		
		utils.MyUtils.printTimeStamp(sName + " END HousePetListTestGetFind Test");
	}
	public void housePetListTestSizeContainsAdd()
	{
		utils.MyUtils.printTimeStamp(sName + " BEGINS HousePetListTestSizeContainsAdd Test");
		HousePet pet1 = new HousePet();
		HousePet pet3 = new HousePet("Shirley   ann MARIE ", 2011, Gender.FEMALE, PetType.BIRD);
		HousePet pet4 = new HousePet("Joe mark jr.", 2014, Gender.MALE, PetType.POTBELLY_PIG);
		HousePetList list1 = new HousePetListImpl();
		System.out.println(sName + " ** Testing getSize(), contains(), add() **");
		assertTrue(list1.getSize() == 0);
		assertFalse(list1.contains(pet1));
		assertFalse(list1.contains(pet3));
		assertTrue(list1.add(pet1));
		assertTrue(list1.getSize() == 1);
		assertTrue(list1.add(pet3));
		assertTrue(list1.getSize() == 2);
		assertTrue(list1.contains(pet1));
		assertTrue(list1.contains(pet3));
		assertFalse(list1.contains(pet4));
		assertTrue(list1.add(pet4));
		assertTrue(list1.getSize() ==3);
		assertTrue(list1.contains(pet4));

		utils.MyUtils.printTimeStamp(sName + " ENDS HousePetListTestSizeContainsAdd Test");


	}

	public void housePetListTestFindByNameFindByPetType()
	{
		utils.MyUtils.printTimeStamp(sName + " BEGINS Test housePetListTestFindByNameFindByPetType");

		HousePet pet1 = new HousePet("Tough GUY", 2018, Gender.MALE, PetType.CAT);
		HousePet pet2 = new HousePet("Sam", 2018, Gender.MALE, PetType.BIRD);
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, Gender.FEMALE, PetType.BIRD);
		HousePet pet4 = new HousePet("Joe mark jr.", 2014, Gender.MALE, PetType.POTBELLY_PIG);
		HousePetList list1 = new HousePetListImpl();
		list1.add(pet1);
		list1.add(pet2);
		list1.add(pet3);
		list1.add(pet4);
		String retString="";
		retString= list1.getHousePetsWithMatchingName("TOUGH   GUY");
		assertTrue(utils.MyUtils.numberLines(retString)==1);
		assertTrue(retString.contains("CAT"));
		retString= list1.getHousePetsWithMatchingName("  SAM ");
		assertTrue(utils.MyUtils.numberLines(retString)==1);
		assertTrue(retString.contains("BIRD"));
		retString= list1.getHousePetsWithMatchingName("a Silly NAme");
		assertTrue(utils.MyUtils.numberLines(retString)==0);
		assertTrue(retString.isEmpty());

		retString= list1.getHousePetsWithPetType(PetType.BIRD);
		assertTrue(utils.MyUtils.numberLines(retString)==2);
		assertTrue(retString.contains("BIRD"));
		retString= list1.getHousePetsWithPetType(PetType.CAT);
		assertTrue(utils.MyUtils.numberLines(retString)==1);
		assertTrue(retString.contains("CAT"));
		retString= list1.getHousePetsWithPetType(PetType.POTBELLY_PIG);
		assertTrue(utils.MyUtils.numberLines(retString)==1);
		assertTrue(retString.contains("POTBELLY"));
		retString= list1.getHousePetsWithPetType(PetType.LIZARD);
		assertTrue(utils.MyUtils.numberLines(retString)==0);
		assertTrue(retString.isEmpty());

		utils.MyUtils.printTimeStamp(sName + " ENDS Test housePetListTestFindByNameFindByPetType");

	}
	public void housePetListTestSortRemoveClear()
	{
		utils.MyUtils.printTimeStamp(sName + " BEGINS Test housePetListTestSortRemoveClear");
		HousePet pet1 = new HousePet("Tough GUY", 2018, Gender.MALE, PetType.CAT);
		HousePet pet2 = new HousePet("Sam", 2018, Gender.MALE, PetType.BIRD);
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, Gender.FEMALE, PetType.BIRD);
		HousePet pet4 = new HousePet("Joe mark jr.", 2014, Gender.MALE, PetType.POTBELLY_PIG);
		HousePet pet5 = new HousePet("Billy Hugh  jr.", 2016, Gender.MALE, PetType.GERBIL);
		HousePetList list1 = new HousePetListImpl();
		list1.sort();
		list1.add(pet1);
		list1.add(pet2);
		list1.sort();
		assertTrue(list1.find(pet2) == 0);
		list1.add(pet3);
		list1.sort();
		assertTrue(list1.find(pet3) == 1);
		assertTrue(list1.find(pet1) == 2);
		list1.add(pet4);
		list1.sort();
		assertTrue(list1.find(pet4) == 0);
		assertTrue(list1.find(pet2) == 1);
		assertTrue(list1.find(pet3) == 2);
		assertTrue(list1.find(pet1) == 3);
		list1.add(pet5);
		list1.sort();
		assertTrue(list1.find(pet5) == 0);
		assertTrue(list1.find(pet4) == 1);
		assertTrue(list1.find(pet2) == 2);
		assertTrue(list1.find(pet3) == 3);
		assertTrue(list1.find(pet1) == 4);

		System.out.println(sName + " Here is the list of 5 pets sorted: \n" + list1);

		HousePet remPet = list1.remove(pet1);
		assertTrue(remPet.equals(pet1));
		remPet = list1.remove(pet1);
		assertTrue(remPet==null);
		assertTrue(list1.getSize() == 4);
		remPet = list1.remove(pet5);
		assertTrue(remPet.equals(pet5));
		remPet = list1.remove(pet5);
		assertTrue(remPet==null);
		assertTrue(list1.getSize() == 3);
		remPet = list1.remove(pet2);
		assertTrue(remPet.equals(pet2));
		remPet = list1.remove(pet2);
		assertTrue(remPet==null);
		assertTrue(list1.getSize() == 2);
		list1.clear();
		assertTrue(list1.getSize()==0);
		assertTrue(list1.add(pet3));
		assertTrue(list1.getSize() == 1);
		assertTrue(list1.add(pet2));
		assertTrue(list1.add(pet4));
		list1.clear();
		assertTrue(list1.getSize() == 0);
		assertTrue(list1.remove(pet3) == null);

		utils.MyUtils.printTimeStamp(sName + " ENDS Test housePetListTestSortRemoveClear");
	}
	public void housePetListUtilsTest()
	{
		utils.MyUtils.printTimeStamp(sName + " BEGINS Test housePetListUtilsTest");
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		String filename = "";
		filename = "housepet6.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}

		HousePetList list = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inputFile, list);
		assertTrue(list.getSize() == 6);
		filename = "housepet6Out.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
		}catch (IOException e) {
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		HousePetListUtilsImpl.writeToFile(outputFile, list);
		outputFile.close();
		filename = "housepet6Out.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}

		list = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inputFile, list);
		assertTrue(list.getSize() == 6);

		filename = "housepetOne.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}

		list = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inputFile, list);
		assertTrue(list.getSize() == 1);


		filename = "housepetOneOut.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
		}catch (IOException e) {
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		HousePetListUtilsImpl.writeToFile(outputFile, list);
		outputFile.close();
		filename = "housepetOneOut.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}

		list = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inputFile, list);
		assertTrue(list.getSize() == 1);

		filename = "housepetEmpty.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}

		list = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inputFile, list);
		assertTrue(list.getSize() == 0);


		filename = "housepetEmptyOut.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
		}catch (IOException e) {
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		HousePetListUtilsImpl.writeToFile(outputFile, list);
		outputFile.close();
		filename = "housepetEmptyOut.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}

		list = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inputFile, list);
		assertTrue(list.getSize() == 0);
		utils.MyUtils.printTimeStamp(sName + " ENDS Test housePetListUtilsTest");


		filename = "housepetOneOut.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}

		list = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inputFile, list);
		assertTrue(list.getSize() == 1);

		filename = "housepetExtra.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}

		list = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inputFile, list);
		assertTrue(list.getSize() == HousePetList.MAX_SIZE);


		filename = "housepetExtraOut.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
		}catch (IOException e) {
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		HousePetListUtilsImpl.writeToFile(outputFile, list);
		outputFile.close();
		filename = "housepetExtraOut.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}

		list = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inputFile, list);
		assertTrue(list.getSize() == HousePetList.MAX_SIZE);
		utils.MyUtils.printTimeStamp(sName + " ENDS Test housePetListUtilsTest");

	}
	public void housePetTest()
	{
		utils.MyUtils.printTimeStamp(sName + " BEGINS HousePetTest");
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet();
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, Gender.FEMALE, PetType.BIRD);
		HousePet pet4 = new HousePet("Joe mark jr.", 2014, Gender.MALE, PetType.POTBELLY_PIG);
		System.out.println(sName + " ********Now testing set/get for pet name ");
		String expName = "$$$$";
		String retName = pet1.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		expName = "$$$$";
		retName = pet2.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		expName = "Shirley Ann Marie";
		retName = pet3.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		expName = "Joe Mark Jr.";
		retName = pet4.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet1.setPetName(" QUeEn   AnnE  MARGARET ");
		expName = "Queen Anne Margaret";
		retName = pet1.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}

		pet1.setPetName("");
		expName = "$$$$";
		retName = pet1.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet1.setPetName("k");
		expName = "K";
		retName = pet1.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet2.setPetName("Kevin daviD");
		expName = "Kevin David";
		retName = pet2.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		System.out.println(sName + " ********Now testing set/get for year born ");
		int expYear=2011;
		int retYear= pet3.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		expYear=2014;
		retYear= pet4.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		expYear=2018;
		retYear= pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		expYear=2018;
		retYear= pet2.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		pet1.setYearBorn(1900);
		expYear=1900;
		retYear= pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		pet1.setYearBorn(0);
		expYear=2018;
		retYear= pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}pet1.setYearBorn(2020);
		expYear=2018;
		retYear= pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		System.out.println(sName + " ********Now testing set/get for gender ");
		Gender expGender=Gender.MALE;
		Gender retGender=pet4.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		expGender=Gender.UNKNOWN;
		retGender=pet1.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}

		expGender=Gender.UNKNOWN;
		retGender=pet2.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		pet1.setGender(Gender.MALE);
		expGender=Gender.MALE;
		retGender=pet1.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		pet2.setGender(Gender.FEMALE);
		expGender=Gender.FEMALE;
		retGender=pet2.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		System.out.println(sName + " ********Now testing set/get for pet type ");
		PetType expType=PetType.UNKNOWN;
		PetType retType = pet1.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}
		expType=PetType.BIRD;
		retType = pet3.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}
		expType=PetType.POTBELLY_PIG;
		retType = pet4.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}
		pet1.setPetType(PetType.DOG);
		expType=PetType.DOG;
		retType = pet1.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}

		pet2.setPetType(PetType.GERBIL);
		expType=PetType.GERBIL;
		retType = pet2.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}
		System.out.println(sName + " ********Now testing that toString() produces no new line chars in returned String for HousePet");
		int expLines=0;
		int retLines = MyUtils.numberLines(pet1.toString());
		if(retLines == expLines)
			System.out.println("SUCCESS expected " + expLines + " new line chars.");
		else
			System.out.println("FAILURE expected: " + expLines + " line(s) instead got " + retLines + " new line chars.");
		expLines=0;
		retLines = MyUtils.numberLines(pet2.toString());
		if(retLines == expLines)
			System.out.println("SUCCESS expected " + expLines + " new line chars.");
		else
			System.out.println("FAILURE expected: " + expLines + " line(s) instead got " + retLines + " new line chars.");
		expLines=0;
		retLines = MyUtils.numberLines(pet3.toString());
		if(retLines == expLines)
			System.out.println("SUCCESS expected " + expLines + " new line chars.");
		else
			System.out.println("FAILURE expected: " + expLines + " line(s) instead got " + retLines + " new line chars.");
		expLines=0;
		retLines = MyUtils.numberLines(pet4.toString());
		if(retLines == expLines)
			System.out.println("SUCCESS expected " + expLines + " new line chars.");
		else
			System.out.println("FAILURE expected: " + expLines + " line(s) instead got " + retLines + " new line chars.");
		System.out.println("********Now testing that toString() has all data values in returned String for HousePet");
		String retString = pet2.toString();
		String expString = "Kevin David";
		int index = retString.indexOf(expString);
		if(index != -1)
			System.out.println("SUCCESS expected " + expString + " in toString() value and found it.");
		else
			System.out.println("FAILURE expected: " + expString + " in toString() value but did not find it");
		expString = "GERBIL";
		index = retString.indexOf(expString);
		if(index != -1)
			System.out.println("SUCCESS expected " + expString + " in toString() value and found it.");
		else
			System.out.println("FAILURE expected: " + expString + " in toString() value but did not find it");
		expString = "FEMALE";
		index = retString.indexOf(expString);
		if(index != -1)
			System.out.println("SUCCESS expected " + expString + " in toString() value and found it.");
		else
			System.out.println("FAILURE expected: " + expString + " in toString() value but did not find it");
		expString = "0";
		index = retString.indexOf(expString);
		if(index != -1)
			System.out.println("SUCCESS expected " + expString + " in toString() value and found it.");
		else
			System.out.println("FAILURE expected: " + expString + " in toString() value but did not find it");
		retString = pet3.toString();
		expString = "Shirley Ann Marie";
		index = retString.indexOf(expString);
		if(index != -1)
			System.out.println("SUCCESS expected " + expString + " in toString() value and found it.");
		else
			System.out.println("FAILURE expected: " + expString + " in toString() value but did not find it");
		expString = "BIRD";
		index = retString.indexOf(expString);
		if(index != -1)
			System.out.println("SUCCESS expected " + expString + " in toString() value and found it.");
		else
			System.out.println("FAILURE expected: " + expString + " in toString() value but did not find it");
		expString = "FEMALE";
		index = retString.indexOf(expString);
		if(index != -1)
			System.out.println("SUCCESS expected " + expString + " in toString() value and found it.");
		else
			System.out.println("FAILURE expected: " + expString + " in toString() value but did not find it");
		expString = "7";
		index = retString.indexOf(expString);
		if(index != -1)
			System.out.println("SUCCESS expected " + expString + " in toString() value and found it.");
		else
			System.out.println("FAILURE expected: " + expString + " in toString() value but did not find it");
		System.out.println(sName + " ********Now testing toString() on all 4 pets, each output line should be \nneat and easy to read with proper spacing.");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);
		System.out.println("********Now testing equals() and hashCode() methods*****");
		int hash1 = pet1.hashCode();
		int hash2 = pet2.hashCode();
		assertTrue(hash1 != hash2);
		assertFalse(pet1.equals(pet2));
		assertTrue(pet1.equals(pet1));
		HousePet hp1 = new HousePet("Sam", 2018, Gender.MALE, PetType.BIRD);
		HousePet hp2 = new HousePet("Sam", 2018, Gender.MALE, PetType.BIRD);
		assertTrue(hp1.equals(hp2));
		assertTrue(hp1.hashCode() == hp2.hashCode());
		assertFalse(hp1.equals(pet1));
		assertFalse(hp1.hashCode() == pet1.hashCode());
		hp1.setGender(Gender.FEMALE);
		assertTrue(hp1.equals(hp2));  // does not check gender on .equals
		assertTrue(hp1.hashCode() == hp2.hashCode());
		hp1.setGender(Gender.MALE);
		hp1.setPetType(PetType.CAT);
		assertFalse(hp1.equals(hp2));
		assertFalse(hp1.hashCode() == hp2.hashCode());
		hp1.setPetType(PetType.BIRD);
		hp1.setPetName("Sue");
		assertFalse(hp1.equals(hp2));
		assertFalse(hp1.hashCode() == hp2.hashCode());
		hp1.setPetName("Sam");
		hp1.setYearBorn(2017);
		assertFalse(hp1.equals(hp2));
		assertFalse(hp1.hashCode() == hp2.hashCode());
		hp1.setYearBorn(2018);
		assertTrue(hp1.equals(hp2));
		assertTrue(hp1.hashCode() == hp2.hashCode());
		System.out.println("********Now testing methods in HousePetUtilsImpl");

		String filename = "housepet6.txt";
		try {
			inputFile = new Scanner(new File(filename));

			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		int petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		if(petCount == 6)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + petCount + " pets from " + filename);

		System.out.println(sName + " ********Now Testing writeToFile...");
		filename = "housepetEmpty.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));

		}catch (IOException e) {

			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		outputFile.close();
		try {
			inputFile = new Scanner(new File(filename));

			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		if(petCount == 0)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + petCount + " pet(s) from " + filename);
		// now write 1 pet to file
		filename = "housepetOne.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));

		}catch (IOException e) {
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		HousePetUtilsImpl.writeToFile(outputFile, pet1);
		outputFile.close();
		try {
			inputFile = new Scanner(new File(filename));

			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		if(petCount == 1)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + petCount + " pet(s) from " + filename);


		// now write 4 pets to file
		filename = "housepetFourWrite.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
			System.out.println("SUCCESS opened file: " + filename + " for output");
		}catch (IOException e) {
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		HousePetUtilsImpl.writeToFile(outputFile, pet1);
		HousePetUtilsImpl.writeToFile(outputFile, pet2);
		HousePetUtilsImpl.writeToFile(outputFile, pet3);
		HousePetUtilsImpl.writeToFile(outputFile, pet4);
		outputFile.close();

		filename = "housepetFourWrite.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			if(pet1 != null)
				petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		int expCount = 4;
		if(petCount == expCount)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + expCount + " pet(s) from " + filename +
					" instead read: " + petCount + " pets.");
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		if(petCount == 4)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + petCount + " pet(s) from " + filename);
		utils.MyUtils.printTimeStamp(sName + " ENDS HousePetTest");

	}// end of house pet test (single house pets)

}
