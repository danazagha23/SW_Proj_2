package first;

public class FilterByBathrooms implements GeneralSpec {

	private int x;

	public FilterByBathrooms(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public boolean isSpecMatched(Houses h1) {
		return h1.getBathrooms()==getX();
	}

}
