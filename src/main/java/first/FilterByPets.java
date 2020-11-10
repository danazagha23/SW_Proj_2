package first;

public class FilterByPets implements GeneralSpec {

	private String string;

	public FilterByPets(String string) {
		this.string = string;
		
		
	}

	public String getString() {
		return string;
	}

	public boolean isSpecMatched(Houses h1) {
	
		return h1.getPets().equalsIgnoreCase(getString());
	}

}
