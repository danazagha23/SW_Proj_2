package first;

public class FilterByMaterial implements GeneralSpec {

	private String s1;

	public FilterByMaterial(String s1) {
		this.s1 = s1;
		
	}
	

	public String getS1() {
		return s1;
	}


	public boolean isSpecMatched(Houses h1) {
		return h1.getMaterial().equalsIgnoreCase(getS1());
	}

}
