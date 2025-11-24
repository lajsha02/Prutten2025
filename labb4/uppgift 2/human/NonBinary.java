//line 163 "HumanFactory.nw"
package human;

final class NonBinary extends Human {
  NonBinary(String name, String pnr) {
    super(name, pnr);
  }
  @Override
  public String toString() {
    return "Jag är icke-binär och heter " + getName();
  }
}
