
public class Treasures {
	// TODO Auto-generated constructor stub

	int value;
	String treasuretype;

	public Treasures(String treasuretype) {
		// TODO Auto-generated constructor stub
		if (treasuretype.equals("Loose coins")) {
			this.treasuretype = treasuretype;
			this.value = 2;
		} else if (treasuretype.equals("Small bag of coins")) {
			this.treasuretype = treasuretype;
			this.value = 6;
		} else if (treasuretype.equals("Gold jewellry")) {
			this.treasuretype = treasuretype;
			this.value = 10;
		} else if (treasuretype.equals("Precious stone")) {
			this.treasuretype = treasuretype;
			this.value = 14;
		} else if (treasuretype.equals("Small treasure chest")) {
			this.treasuretype = treasuretype;
			this.value = 20;
		}

	}// ENd Treasures

}
