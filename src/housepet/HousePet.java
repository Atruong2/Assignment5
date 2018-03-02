package housepet;

import utils.MyUtils;

public class HousePet 
{
	private String petName;
	private int yearBorn;
	private Gender gender;
	private PetType petType;
	
	// default constructor, creates a default HousePet instance
	// name: "$$$$", year born: 2018, gender: unknown, pet type: unknown
	public HousePet() 
	{
		this.setPetName ("$$$$");
		this.setYearBorn (2018);
		this.setGender (Gender.UNKNOWN);
		this.setPetType (PetType.UNKNOWN);
	}
	
	// creates HousePet instance with given data
	// if any invalid data received, puts default value into field
	// valid data: 1900 <= year born <= 2018
	// pet name: may not be an empty string nor all whitespace, if so, assign it "$$$$"
	public HousePet (String aPetName, int aYearBorn, Gender aGender, PetType aPetType)
	{
		this.setPetName (aPetName);
		this.setYearBorn (aYearBorn);
		this.setGender (aGender);
		this.setPetType (aPetType);
	}
	
	// returns a nicely formatted string of this HousePet on same line
	// age of pet is printed instead of year born
	public String toString()
	{
		String retValue = "";
		retValue += "Name: " + this.getPetName();
		retValue += " Age: " + (2018 - this.getYearBorn());
		retValue += " Gender: " + this.getGender();
		retValue += " Pet Type: " + this.getPetType();
		return retValue;
	}
	
	// returns the name of this HousePet
	public String getPetName()
	{
		return this.petName;
	}
	
	// returns the year born of this HousePet
	public int getYearBorn()
	{
		return this.yearBorn;
	}
	
	// returns the gender of this HousePet
	public Gender getGender()
	{
		return this.gender;
	}
	
	// returns the pet type of this HousePet
	public PetType getPetType()
	{
		return this.petType;
	}
	
	// sets this HousePet's name to theName after calling
	public void setPetName (String theName)
	{
		theName = MyUtils.properFormat(theName);
		if (theName.equals (""))
		{
			this.petName = "$$$$";
		}
		else
		{
			this.petName = theName;
		}
	}
	
	// sets this HousePet's year born to given value if in proper range or use default, 2018
	public void setYearBorn (int aYearBorn)
	{
		if (aYearBorn < 1900 || aYearBorn > 2018)
		{
			this.yearBorn = 2018;
		}
		else
		{
			this.yearBorn = aYearBorn;
		}
	}
	
	// sets this HousePet's gender to given gender
	public void setGender (Gender aGender)
	{
		this.gender = aGender;
	}
	
	// sets this HousePet's pet type to given pet type
	public void setPetType (PetType aPetType)
	{
		this.petType = aPetType;
	}	
	
	// override of inherited equals 
	// checks each attribute of a housepet
	// if all match, return true
	// if any attribute does not match received obj's attribute, return false
	public boolean equals (Object obj)
	{
		if(this == obj)
			return true;
		if(! (obj instanceof HousePet)) 
		{
			return false;
		}
		HousePet pet = (HousePet) obj; 

		if(!(this.getPetName().equals(pet.getPetName())))
			return false;
		if(!(this.getYearBorn() == pet.getYearBorn()))
			return false;
		if(!(this.getGender().equals(pet.getGender())))
			return false;
		if(!(this.getPetType().equals(pet.getPetType())))
			return false;

		return true; 
	}

	//override of inherited hashCode
	// hashes each attribute
	// returns int value based on attributes (a typical hashCode override with equals override)
	public int hashCode()
	{
		int mult = 31;
		int result = 133;
		result = result * mult + this.getPetName().hashCode();
		result = result * mult + this.getYearBorn();
		result = result * mult + this.getGender().hashCode();
		result = result * mult + this.getPetType().hashCode();
		return result; 
	}
}
