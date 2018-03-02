package housepetlist;

import housepet.HousePet;
import housepet.PetType;

public interface HousePetList {
	public static final int MAX_SIZE = 15; // max # allowed in the list

	//pre: none
	//post: returns number of HousePets currently in the list
	//  Example use
	//  HousePetList list = new HousePetListImpl();  // create empty list
	//   assertTrue(list.getSize() == 0);   // size should be 0
	//  boolean result = list.add(new HousePet("Diamond the Cat", 2014, Gender.FEMALE, PetType.CAT));
	//  assertTrue(list.getSize() == 1);
	public int getSize();

	// pre: none
	// post: returns true if received housepet matches any housepet, assumes equals is overloaded in HousePet
	//        in this list, returns false if not
	public boolean contains(HousePet housepet);

	//pre: none
	//post: housepet is added to this list if not already there
	//      (house pets must be unique for each name, pet type, and year)
	//      returns true if housepet was added, false if no room in the list or duplicate
	//      housepet is found in the list
	//      a housepet is a duplicate if it has the same name and same pet type and the same year born
	//      Example use:
	//        HousePetList list = new HousePetListImpl();
	//        boolean result = list.add(new HousePet("Rocky Road", 2016, Gender.MALE, PetType.GERBIL));
	//        assertTrue(result == true);
	public boolean add(HousePet housepet);

	//receives: position - index (zero-based) of position in list to return house pet from
	// returns: the housepet in the list at given position.
	//       uses zero-based positions, so 0 is the position of the first house pet in the list
	//       returns null if received position is out of range, range of list is 0 to 1 less than size of the list
	//  Example use:
	//        HousePetList list = new HousePetListImpl();
	//        HousePet pet2 = new HousePet("Sport", 2010, Gender.MALE, PetType.DOG);
	//        boolean result = list.add(pet2);
	// 		  HousePet pet1 = list.get(0);  // should be at position 0
	//        assertTrue(pet1.equals(pet2));
	public HousePet get(int position);

	//receives: housepet - a populated HousePet to locate in this list
	//returns:  the position of received housepet in the list, if found, -1 if not found
	//       (uses name, year, pet type when matching)
	//       returns -1 if received housepet is not found in current list at any position
	//        HousePetList list = new HousePetListImpl();
	//        HousePet pet2 = new HousePet("Zorro the Wizard", 2015, Gender.MALE, PetType.BIRD);
	//        boolean result = list.add(pet2);
	//		  int position = list2.find(pet2);
	//	      assertTrue(position == 0);
	public int find(HousePet housepet);


	//receives: petType, the type of pet to put in the returned String, 
	//post: returns a String containing a list (1 house pet per line) of house pets
	//      that are all of the received pet type
	//      returns an EMPTY String if NO house pets are of the received pet type
	//	    Example use:
	//	    HousePetList list = new HousePetListImpl();
	//        HousePet pet2 = new HousePet("Yellow Smoke", 2010, Gender.FEMALE, PetType.DOG);
	//        boolean result = list.add(pet2);
	//        assertTrue(result == true);
	// 		String list1 = list.getHousePetsDeficient();
	//      assertTrue(list1.equals(""));
	public String getHousePetsWithPetType(PetType petType);


	//receives: aName - the name we are using to match with any other pets of same name
	//post: returns a String containing a list (1 house pet per line) of house pets
	//      with name matching  received  String
	//      if no matches exist, returns empty string
	//  Example use:
	//	HousePetList list = new HousePetListImpl();
	//      HousePet pet2 = new HousePet("Tweety Bird", 2011, Gender.MALE, PetType.BIRD);
	//      String matches = list.getHousePetsWithMatchingName("TWEETY BIRD");
	public String getHousePetsWithMatchingName(String aName);

	//pre: none
	//post: this HousePetList is sorted by pet name from lowest to highest (alphabetically)
	//  Example use (give 2 more):
	//	HousePetList list = new HousePetListImpl();
	//      .....
	// 	list.sort();
	//      System.out.println("here is the sorted list:\n" + list);  // should be in alphabetical order by pet name
	//                 
	public void sort();

	// receives: housepet - a populated pet to remove from this list
	//post: if a HousePet instance  in this list is found that MATCHES the
	//      received housepet (assume equals is overloaded for HousePet)
	//      the HousePet instance in the list that matched received housepet is removed
	//       from this list AND RETURNED.
	//       If no HousePet instance is found that has matches received housepet
	//       then null is RETURNED
	//    Example use:
	//      HousePetList list = new HousePetListImpl();
	//       .....  // do some things to list
	//      HousePet remPet = list.remove(pet2);
	//      assertTrue(remPet.equals(pet2));
	//      assertFalse(list.contains(pet2));
	//     Example use #2:
	//        remPet = list.remove(pet2);
	//        assertTrue(remPet == null);
	public HousePet remove(HousePet housepet);

	// pre: none
	//post: this HousePetList instance has a size of 0.
	// removes all house pets from this instance
	public void clear();
}// end of interface

