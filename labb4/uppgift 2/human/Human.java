//line 94 "HumanFactory.nw"
package human;

public abstract class Human {
	
//line 108 "HumanFactory.nw"
	protected final String name;
	protected final String pnr;
//line 98 "HumanFactory.nw"
	
//line 117 "HumanFactory.nw"
	Human(String name, String pnr) {
		if (name == null || name.isBlank()) throw new IllegalArgumentException("name");
		if (pnr == null || pnr.length() < 2) throw new IllegalArgumentException("pnr");
		this.name = name;
		this.pnr = pnr;
	}
//line 99 "HumanFactory.nw"
	
//line 136 "HumanFactory.nw"
	public static Human create(String name, String pnr) {
		if (pnr == null || pnr.length() < 2) throw new IllegalArgumentException("pnr");
		char c = pnr.charAt(pnr.length() - 2); // näst sista tecknet
		if (c == '0') {
			return new NonBinary(name, pnr);
		}
		if (!Character.isDigit(c)) {
			throw new IllegalArgumentException("pnr: näst sista tecknet måste vara siffra eller '0'");
		}
		int d = c - '0';
		if ((d % 2) == 1) {
			return new Man(name, pnr);
		} else {
			return new Woman(name, pnr);
		}
	}
//line 100 "HumanFactory.nw"
	
//line 158 "HumanFactory.nw"
	public String getName() { return name; }
	public String getPnr() { return pnr; }
	@Override public abstract String toString();
//line 101 "HumanFactory.nw"
}
