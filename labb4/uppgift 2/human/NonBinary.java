//line 171 "HumanFactory.nw"
package human;

final class NonBinary extends Human {
	
//line 183 "HumanFactory.nw"
	NonBinary(String name, String pnr) {
		super(name, pnr);
	}
//line 175 "HumanFactory.nw"
	
//line 190 "HumanFactory.nw"
	@Override
	public String toString() {
		return "Jag är icke-binär och heter " + name;
	}
//line 176 "HumanFactory.nw"
}
