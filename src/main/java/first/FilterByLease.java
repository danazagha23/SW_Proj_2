package first;

public class FilterByLease implements GeneralSpec {

	private int i;

	public FilterByLease(int i) {
		this.i = i;

		
	}

	public boolean isSpecMatched(Houses h1) {

		return h1.getLease()==getI();
	}

	private int getI() {

		return i;
	}

}
