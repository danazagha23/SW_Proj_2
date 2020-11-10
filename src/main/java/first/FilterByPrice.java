package first;

public class FilterByPrice implements GeneralSpec {

	private int price;

	public FilterByPrice(int price) {
		this.price = price;
		
	}
	

	public int getPrice() {
		return price;
	}


	public boolean isSpecMatched(Houses h1) {
	
		
		return h1.getPrice()<=getPrice();
	}

}
