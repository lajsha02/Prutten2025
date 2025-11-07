//line 231 "HumanFactory.nw"
package human;

final class Man extends Human {
	
//line 241 "HumanFactory.nw"
	Man(String name, String pnr) {
		super(name, pnr);
	}
//line 235 "HumanFactory.nw"
	
//line 248 "HumanFactory.nw"
	@Override
	public String toString() {
		return "Jag är man och heter " + name;
	}
//line 236 "HumanFactory.nw"
}
