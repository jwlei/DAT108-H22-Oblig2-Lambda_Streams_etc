package ex2.task4.object;

public class King {
	
	public static final King DEFAULT = new King("[Missing data]", 0, 0, 0);
	
	private static final String STD_IMG = "https://upload.wikimedia.org"
				+ "/wikipedia/commons/thumb/d/d1/Heraldic_crown_of_Norway.svg/" 
				+ "250px-Heraldic_crown_of_Norway.svg.png";
	
	private String name, img;
	private int bYear, reignStart, reignEnd;

	
	public King(String name, int bYear, int reignStart, int reignEnd) {
		this(name, bYear, reignStart, reignEnd, STD_IMG);
	}

	public King(String name, int bYear, int reignStart, int reignEnd,
				String img) {
		this.name = name;
		this.bYear = bYear;
		this.reignStart = reignStart;
		this.reignEnd = reignEnd;
		this.img = img;
	}
	
	@Override
	public String toString() {
		return name + ", born " + bYear + ", and was king from " + reignStart
				+ " to " + reignEnd + ".";
	}

	public String getName() {
		return name;
	}

	public int getbYear() {
		return bYear;
	}

	public int getReignStart() {
		return reignStart;
	}

	public int getReignEnd() {
		return reignEnd;
	}
	
	public String getImg() {
		return img;
	}	
}
