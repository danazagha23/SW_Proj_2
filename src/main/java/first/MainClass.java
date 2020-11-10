  
  
package first;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


 

public class MainClass {
  
    private List<Houses> h; 
    //-------------------------------------------------------------------------------
    private List<Houses> myList;
    private WebEmailService emailservice;
    private String s= "Hayamikkawi833@gmail.com";
    public void setEmailService(WebEmailService emailservice) {
    	this.emailservice = emailservice;
    }
    //-------------------------------------------------------------------------------

    public void setRepository (List<Houses> rep) {
    	h=rep;
    }
    
    
	public List<Houses> searchForCity () throws Exception{
		String s1= "City";
		GeneralSpec f= new FilterByPlacement(s1);
		myList=bySpec(f);
		emailservice.sendEmail(s, myList);
    	return myList;
    	
    }
	public List <Houses> searchForVillage() throws Exception{
    	String s1="Village";
    	GeneralSpec f= new FilterByPlacement(s1);
    	myList=bySpec(f);
    	emailservice.sendEmail(s, myList);
        return myList;
    	
    }
    public List <Houses> searchForHouse() throws Exception{
    	String s1="House";
    	GeneralSpec f= new FilterByType(s1);
    	myList=bySpec(f);
    	emailservice.sendEmail(s, myList);
        return myList;
    }

//had hu///////////////////////////////////////////
	private List<Houses> bySpec(GeneralSpec f) {
		ArrayList<Houses> selectedHouses;
		selectedHouses= new ArrayList<Houses>();
    	for (Houses h1:h) {
    		if (f.isSpecMatched(h1))
    			selectedHouses.add(h1);
    		
    	}
		return selectedHouses;
	}
///////////////////////////////////////////////	
	
	public List <Houses> searchForApartment() throws Exception{
    	
    	String s1="Apartment";
    	GeneralSpec f= new FilterByType(s1);
    	myList=bySpec(f);
    	emailservice.sendEmail(s, myList);
        return myList;
    	
    }
    public List <Houses> searchForWood() throws Exception{
    	
    	String s1="Wood";
    	GeneralSpec f= new FilterByMaterial(s1);
    	myList=bySpec(f);
    	emailservice.sendEmail(s, myList);
        return myList;
    }
    
    public List <Houses> searchForStone() throws Exception{
    	String s1="Stone";
    	GeneralSpec f= new FilterByMaterial(s1);
    	myList=bySpec(f);
    	emailservice.sendEmail(s, myList);
        return myList;
    	
    }
    public List <Houses> searchForBrick() throws Exception{
    	String s1="Brick";
    	GeneralSpec f= new FilterByMaterial(s1);
    	myList=bySpec(f);
    	emailservice.sendEmail(s, myList);
        return myList;
   }
    
    public List <Houses> searchLessThanPrice( int price) throws Exception{
    	GeneralSpec f= new FilterByPrice(price);
        //-------------------------------------------------------------------------------
    	emailservice.sendEmail(s, bySpec(f));
        //-------------------------------------------------------------------------------

    	return bySpec(f);
    }

    public List <Houses> searchInPriceRange( int price0, int price1) throws Exception{
    	GeneralSpec f= new FilterByPriceRange(price0, price1);
    	myList=bySpec(f);
    	emailservice.sendEmail(s, myList);
        return myList;
    	
    }
    
    public List <Houses> searchLessThanArea( int area) throws Exception{
        GeneralSpec f= new FilterByArea(area);
    	emailservice.sendEmail(s, bySpec(f));
        return bySpec(f);
    	
    }
    public List <Houses> searchInAreaRange( int area0, int area1) throws Exception{
    	 GeneralSpec f= new FilterByAreaRange(area0,area1);
    	 emailservice.sendEmail(s, bySpec(f));
         return bySpec(f);
    	
    }
    
    public List <Houses> searchByBedrooms (int x) throws Exception{
    	GeneralSpec f= new FilterByBedrooms(x);
    	myList=bySpec(f);
    	emailservice.sendEmail(s, myList);
        return myList;
   
    }
    public List <Houses> searchByBathrooms (int x) throws Exception{
    	GeneralSpec f=new FilterByBathrooms(x);
    	myList=bySpec(f);
    	emailservice.sendEmail(s, myList);
        return myList;
    }

public List <Houses> searchHomeWithPets () throws Exception{
	
	GeneralSpec f=new FilterByPets("yes");
	myList=bySpec(f);
	emailservice.sendEmail(s, myList);
    return myList;
	
}
public List <Houses> searchHomeWithoutPets () throws Exception{
	GeneralSpec f=new FilterByPets("No");
	myList=bySpec(f);
	emailservice.sendEmail(s, myList);
    return myList;
	
	
}
public List <Houses> searchForShortTermLeaseLength () throws Exception{
	GeneralSpec f= new FilterByLease(6);
	myList=bySpec(f);
	emailservice.sendEmail(s, myList);
    return myList;
	
}
public List <Houses> searchForLongTermLeaseLength () throws Exception{
	GeneralSpec f= new FilterByLease(12);
	myList=bySpec(f);
	emailservice.sendEmail(s, myList);
    return myList;
	
}

public List <Houses> searchForAmenties (String am) throws Exception{
	String[] amtokens=am.split(",");
	GeneralSpec f= new FilterByAm(amtokens);
	myList=bySpec(f);
	emailservice.sendEmail(s, myList);
    return myList;           
}

public List<Houses> searchByMany(String filterp, String filterm, String filtert, int[] myParameters,
String filter2, String am) throws Exception {
	GeneralSpec f= new FilterByMany(filterp,filterm, filtert,myParameters, filter2, am);
	myList=bySpec(f);
	emailservice.sendEmail(s, myList);
    return myList;
}


public void printResult(List<Houses> r) {
	for (int i=0; i<r.size();i++) {
		Houses h1= r.get(i);
		System.out.println(h1.getType()+"\t" + h1.getMaterial()+"\t"+ h1.getPlacement()+"\t"+h1.getPets()+"\t"+h1.getTemp()+"\t"+h1.getPrice()+"\t"+h1.getArea()+"\t"+h1.getBathrooms()+"\t"+h1.getBedrooms()+"\t"+h1.getLease());
	}
}

public List<Houses> setHomes(Map<String, String> homes) {
	List<Houses> l1 = new ArrayList<Houses>();
    java.util.Iterator<String> iterator = homes.keySet().iterator();//to divide the keys(string part) by objects
    java.util.Iterator<String> iterator1 = homes.values().iterator();//to divide the values(integer part) by objects
    Houses h1;
    for (int a=0; a<homes.size(); a++)
    { 
    	String s1= iterator.next();
       String s2=iterator1.next();
       h1=new Houses(s1, s2);
       l1.add(h1);
    }
	return l1;
}




}