//line 202 "HumanFactory.nw"
package human;

final class Woman extends Human {
	
//line 212 "HumanFactory.nw"
	Woman(String name, String pnr) {
		super(name, pnr);
	}
//line 206 "HumanFactory.nw"
	
//line 219 "HumanFactory.nw"
	@Override
	public String toString() {
		return "Jag är kvinna och heter " + name;
	}
//line 207 "HumanFactory.nw"
}
