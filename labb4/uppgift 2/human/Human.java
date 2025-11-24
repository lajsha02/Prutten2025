//line 93 "HumanFactory.nw"
package human;

public abstract class Human {
  
//line 107 "HumanFactory.nw"
  private final String name;
  private final String pnr;
//line 97 "HumanFactory.nw"
  
//line 116 "HumanFactory.nw"
  Human(String name, String pnr) {
    this.name = name;
    this.pnr = pnr;
  }
//line 98 "HumanFactory.nw"
  
//line 132 "HumanFactory.nw"
  public static Human create (String name, String pnr) {
    if (pnr.charAt(pnr.length() - 2) == '0') {
    return new NonBinary(name, pnr);
    }
    else if (pnr.charAt(pnr.length() - 2) % 2 == 0) {
    return new Woman(name, pnr);
    }
    else {
    return new Man(name, pnr);
    }
  }

//line 99 "HumanFactory.nw"
  
//line 150 "HumanFactory.nw"
  public String getName() { return name; }
  public String getPnr() { return pnr; }
  @Override public abstract String toString();
//line 100 "HumanFactory.nw"
}
