package first;

public class FilterByMany implements GeneralSpec {
	private String filterp;
	private String filterm;
	private String filtert;
	private int price3;
	private int price0;
	private int price1;
	private int area3;
	private int area0;
	private int area1;
	private String filter2;
	private String am;
	private int bedr;
	private int bathr;
	private int ll;
	public FilterByMany(String filterp, String filterm, String filtert, int [] myParameters,String filter2, String am) {
		
		this.filterp=filterp;
		this.filterm=filterm; 
		this.filtert=filtert; 
		this.price3= myParameters[0];
		this.price0=myParameters[2];
		this.price1=myParameters[1];
		this.area3=myParameters[5];
		this.area0 = myParameters[3];
		this.area1 = myParameters[4];
		this.filter2 = filter2;
		this.am = am;
		this.bedr = myParameters[6];
		this.bathr = myParameters[7];
		this.ll = myParameters[8];
		
	}
	public boolean isSpecMatched(Houses h1) {
		
	    boolean filtered=true; 
	    if (filterp.length()!=0) {
	    	FilterByPlacement fp= new FilterByPlacement(filterp);
	    	filtered= fp.isSpecMatched(h1);
	   }
	   if (filtered && filterm.length()!=0)
	    	{FilterByMaterial fm= new FilterByMaterial(filterm);
	    	 filtered= fm.isSpecMatched(h1);
	    	
	    	}
	   if (filtered && filtert.length()!=0)
    	{FilterByType ft= new FilterByType(filtert);
    	 filtered= ft.isSpecMatched(h1);
    	}
	    if (filtered)
    	{FilterByPrice fpr= new FilterByPrice(price3);
    	 filtered= fpr.isSpecMatched(h1);
    	
    	}
	    if (filtered)
    	{FilterByPriceRange fbpr= new FilterByPriceRange(price0, price1);
    	 filtered= fbpr.isSpecMatched(h1);
    	}
	    if (filtered)
    	{FilterByArea fa= new FilterByArea(area3);
    	 filtered= fa.isSpecMatched(h1);
    	
    	}
	    if (filtered) {
	    	FilterByAreaRange fba= new FilterByAreaRange(area0, area1);
	    	filtered= fba.isSpecMatched(h1);
	    }
	    if (filtered && bedr>-1) {
	    	FilterByBedrooms fbed= new FilterByBedrooms(bedr);
	    	filtered=fbed.isSpecMatched(h1);
	    }
	    if (filtered && bathr>-1) {
	    	FilterByBathrooms fbath= new FilterByBathrooms(bathr);
	    	filtered= fbath.isSpecMatched(h1);
	    }
	    if (filtered && filter2.length()!=0) {
	    	FilterByPets fbp= new FilterByPets(filter2);
	    	filtered= fbp.isSpecMatched(h1);
	    }
	    if (filtered && ll>-1) {
	    	FilterByLease fl= new FilterByLease(ll);
	    	filtered=fl.isSpecMatched(h1);
	    }
	    if (filtered && am.length()!=0) {
	    	String[] amtokens=am.split(",");
	    	FilterByAm fam= new FilterByAm(amtokens);
	    	filtered= fam.isSpecMatched(h1);
	    }
	   
	    return filtered;
	    
		
	}

    
    
    
    
    
    
    
    
    




}
