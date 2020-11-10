package first;

public class FilterByBedrooms implements GeneralSpec {

	private int x;

	public FilterByBedrooms(int x) {
		this.x = x;
	
	}

	public int getX() {
		return x;
	}

	public boolean isSpecMatched(Houses h1) {

		return h1.getBedrooms()==getX();
	}

}
