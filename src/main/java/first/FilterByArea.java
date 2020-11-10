package first;

public class FilterByArea implements GeneralSpec {

	private int area;

	public FilterByArea(int area) {
		this.area = area;
	}
	

	public int getArea() {
		return area;
	}


	public boolean isSpecMatched(Houses h1) {

		return h1.getArea()<=getArea();
	}

}
