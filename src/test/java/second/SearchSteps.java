package second;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import first.Houses;
import first.MainClass;
import first.MockEmailHolder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	List <Houses> myH= new ArrayList <Houses>();
	List <Houses> Result= new ArrayList <Houses>();
	MainClass mySearch=new MainClass();
	int []myParameters= new int[9]; 
    String am;
    String filter;
    String filterp;
    String filtert;
    String filterm;
    String filter2;
    String tokens;
    Map<String,String> Homes;
    
    
//-----------------------------------------------------------

private MockEmailHolder mockWebHolder;  
    public SearchSteps(MainClass finder , MockEmailHolder mockWebholderIn) {
	 this.mySearch = finder;
	 mockWebHolder=new MockEmailHolder(mySearch);
 }
//-----------------------------------------------------------

@Given("these homes are contained in the system")
public void theseHouseAreContainedInTheSystem(Map<String,String> myHomes ) {
    Homes=myHomes;
    myH= mySearch.setHomes(Homes);
    mySearch.setRepository(myH);
    setValues();
  }

@When("I search about home by {string}")
public void iSearchAboutHomeBy(String string) {
	filter=string;
	if (string.equalsIgnoreCase("city")|| string.equalsIgnoreCase("village")) {
		filterp=string;
	}
	else if (string.equalsIgnoreCase("wood")|| string.equalsIgnoreCase("stone")||string.equalsIgnoreCase("brick"))
		 filterm=string;
	
	else if (string.equalsIgnoreCase("apartment")|| string.equalsIgnoreCase("house"))
		 filtert=string;
	
}

@Then("A list of homes that matches the placement specification should be returned and printed on the console")
public void aListOfHomesThatMatchesThePlacementSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	if (filter.equalsIgnoreCase("City")){
	      Result = mySearch.searchForCity();
	      assertEquals(myH.get(1), Result.get(0));
	      System.out.println("Homes at the City are:");
	      mySearch.printResult(Result);
	      System.out.println("************************************************");
	} 
	
	else if (filter.equalsIgnoreCase("Village")) {
	     Result = mySearch.searchForVillage();
	     assertEquals(myH.get(0), Result.get(0));
	     System.out.println("Homes at the Village are:");
		 mySearch.printResult(Result);
	     System.out.println("************************************************");

	}
	
	else if (filter.equalsIgnoreCase("House")) {
		 Result = mySearch.searchForHouse();
		 assertEquals(myH.get(0), Result.get(0));
		 System.out.println("Houses are:");
		 
	     mySearch.printResult(Result);
	     System.out.println("************************************************");

		
	}
	else if (filter.equalsIgnoreCase("Apartment")) {
		 Result = mySearch.searchForApartment();
		  assertEquals(myH.get(1), Result.get(0));
		 System.out.println("Apartments are:");
		 mySearch.printResult(Result);
	     System.out.println("************************************************");
 
		
	}
	else if (filter.equalsIgnoreCase("Wood")) {
		 Result = mySearch.searchForWood();
		 assertEquals(myH.get(0), Result.get(0));
		 System.out.println("Homes made of Wood are:");
		 mySearch.printResult(Result);
	     System.out.println("************************************************");

		
	}
	else if (filter.equalsIgnoreCase("Brick")) {
		 Result = mySearch.searchForBrick();
         assertEquals(myH.get(1), Result.get(0));
		 System.out.println("Homes made of Brick are:");
		 mySearch.printResult(Result);
	      System.out.println("************************************************");

		
	}
	else if (filter.equalsIgnoreCase("Stone")) {
		 Result = mySearch.searchForStone();
		 assertEquals(0,Result.size());
		 System.out.println("Homes made of Stone are:");
		 mySearch.printResult(Result);
	      System.out.println("************************************************");

		
	}
}

//less than a price or area
@When("I search about home with {string} less than {int}")
public void iSearchAboutHomeWithPriceLessThan(String s,Integer int1) {
   if (s.equalsIgnoreCase("price"))
   {myParameters[0]=int1;
   }
   else if (s.equalsIgnoreCase("area"))
	   {myParameters[5]=int1;
	   }
}

@Then("A list of homes that matches the price specification should be returned and printed on the console")
public void aListOfHomesThatMatchesThePriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
	  Result= mySearch.searchLessThanPrice(myParameters[0]);
		  assertEquals(myH.get(0),Result.get(0));
		  assertEquals(myH.get(1),Result.get(1));
	   System.out.println("Homes with price less than "+myParameters[0]+" are:");
	   mySearch.printResult(Result);
	      System.out.println("************************************************");

}
@Then("A list of homes that matches the area specification should be returned and printed on the console")
public void aListOfHomesThatMatchesTheAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
	  Result= mySearch.searchLessThanArea(myParameters[5]);
		  assertEquals(myH.get(1), Result.get(0));
	   System.out.println("Homes with area less than "+myParameters[5]+" are:");
	   mySearch.printResult(Result);
	      System.out.println("************************************************");

}

// price or area range 
@When("I search about home with {string} between {int} and {int}")
public void iSearchAboutHomeWithPriceBetweenAnd(String s,Integer int1, Integer int2) {
 if (s.equalsIgnoreCase("price")){
	 myParameters[2]=int1; 
	 myParameters[1]=int2;

 }
 else if (s.equalsIgnoreCase("area")) {
	 myParameters[3]=int1; 
	 myParameters[4]=int2;

 }
 
}
@Then("A list of homes that matches the price range specification should be returned and printed on the console")
public void aListOfHomesThatMatchesThePriceRangeSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
	  Result= mySearch.searchInPriceRange(myParameters[2], myParameters[1]);
	  for (int i=0; i<Result.size();i++)
		  assertTrue(Result.get(i).getPrice()>=myParameters[2] && Result.get(i).getPrice()<=myParameters[1]);
	   System.out.println("Homes with price between "+myParameters[2]+" and "+ myParameters[1]+" are:");
	   mySearch.printResult(Result);
	      System.out.println("************************************************");

}
@Then("A list of homes that matches the area range specification should be returned and printed on the console")
public void aListOfHomesThatMatchesTheAreaRangeSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
	  Result= mySearch.searchInAreaRange( myParameters[3],  myParameters[4]);
	  for (int i=0; i<Result.size();i++)
		  assertTrue(Result.get(i).getArea()>= myParameters[3] && Result.get(i).getArea()<=myParameters[4]);
	   System.out.println("Homes with areas between "+ myParameters[3]+" and "+ myParameters[4]+" are:");
	   mySearch.printResult(Result);
	      System.out.println("************************************************");

}

//Bedrooms
@When("I search about home by {int} Bedrooms")
public void iSearchAboutHomeByBedrooms(Integer int1) {
	myParameters[6]=int1;
}


@Then("A list of homes that matches the Bedrooms specification should be returned and printed on the console")
public void aListOfHomesThatMatchesTheBedroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
	
	Result=mySearch.searchByBedrooms(myParameters[6]);
	  for (int i=0; i<Result.size();i++)
		  assertEquals(myParameters[6],Result.get(i).getBedrooms());
	System.out.println("Homes with "+myParameters[6]+" bedroom are:");
	mySearch.printResult(Result);
    System.out.println("************************************************");


}
//Bathrooms
@When("I search about home by {int} Bathrooms")
public void iSearchAboutHomeByBathrooms(Integer int1) {
	myParameters[7]=int1;
}

@Then("A list of homes that matches the Bathrooms specification should be returned and printed on the console")
public void aListOfHomesThatMatchesTheBathroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
	Result=mySearch.searchByBathrooms(myParameters[7]);
	  for (int i=0; i<Result.size();i++)
		  assertEquals(myParameters[7],Result.get(i).getBathrooms());
	System.out.println("Homes with "+myParameters[7]+" bathroom are:");
	mySearch.printResult(Result);
    System.out.println("************************************************");

	
}

//Pets no change 
@When("I search about home by {string} Pets")
public void iSearchAboutHomePets(String string) {

	filter2=string;
}

@Then("A list of homes that matches the Pets specification should be returned and printed on the console")
public void aListOfHomesThatMatchesThePetsSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	
	 if (filter2.equalsIgnoreCase("yes")) {
	     Result = mySearch.searchHomeWithPets();
	     assertEquals(0, Result.size());

	     System.out.println("Homes with pets are:");
		 mySearch.printResult(Result);
	      System.out.println("************************************************");

	}
	else if (filter2.equalsIgnoreCase("no")) {
	     Result = mySearch.searchHomeWithoutPets();
	     for (int i=0; i<Result.size();i++)
		      assertTrue(Result.get(i).getPets().equalsIgnoreCase("no"));
		 
	     System.out.println("Homes without pets are:");
		 mySearch.printResult(Result);
	      System.out.println("************************************************");

	}
}


//Lease Length changed
@When("I search about home by {int} months LeaseLength")
public void iSearchAboutHomeBy(Integer int1) {
    
	myParameters[8]= int1;
}

@Then("A list of homes that matches the LeaseLength specification should be returned and printed on the console")
public void aListOfHomesThatMatchesTheLeaseLengthSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
   
	
	 if (myParameters[8]==6) 
	 {
	     Result = mySearch.searchForShortTermLeaseLength();
	     for (int i=0; i<Result.size();i++)
		      assertEquals(6,Result.get(i).getLease());
	     System.out.println("Homes with short term lease length:");
		 mySearch.printResult(Result);
	      System.out.println("************************************************");

     }
	
	else if (myParameters[8]==12) 
	 {
	     Result = mySearch.searchForLongTermLeaseLength();
	     for (int i=0; i<Result.size();i++)
		      assertEquals(12,Result.get(i).getLease());
	     System.out.println("Homes with long term lease length:");
		 mySearch.printResult(Result);
	      System.out.println("************************************************");
    }
		
}

//Amenities
@When("I search about home with {string}")
public void iSearchAboutHomeWith(String s) {
	 am=s;
}

@Then("A list of homes that matches the Amenities specification should be returned and printed on the console")
public void aListOfHomesThatMatchesTheAmentiesSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws Exception {
     
 System.out.println("Homes that matches these Amenities are:");

 Result=mySearch.searchForAmenties(am);
 assertEquals(myH.get(0), Result.get(0));
 mySearch.printResult(Result);
 System.out.println("************************************************");

 
	}


@Then("A list of homes that match the many Specifications should be returned and printed on the console")
public void aListOfHomesThatMatchTheManySpecificationsShouldBeReturnedAndPrinted() throws Exception {
	Result= mySearch.searchByMany(filterp, filterm, filtert ,myParameters, filter2, am);

    System.out.println("Homes with all of these features are:");
    mySearch.printResult(Result);
    if (Result.size()==0)     System.out.println("No homes satisfies all of the mentioned features together");
    System.out.println("************************************************");

}

@Then("email with the result should be send to user {string}")
public void emailwiththeresultshouldbesendtouser(String string) throws Exception {
	verify(mockWebHolder.getEmailService(), times(1)).sendEmail(string, Result);
}
private void setValues() {

	 myParameters[0]=1000000; 
	 myParameters[2]=-1;
     myParameters[1]=1000000;
     myParameters[3]=-1;
     myParameters[4]=1000000;
     myParameters[5]=1000000;
     myParameters[6]=-1;
     myParameters[7]=-1;
     myParameters[8]=-1;
     am="";
     filter="";
     filterp="";
     filtert="";
     filterm="";
     filter2="";
     tokens="";
}
}
