package HumanFactory;

public  class NonBinary extends Human {
  public NonBinary(String name, String pnr) {
    super(name, pnr);
  }

  @Override
  public String toString() {
      return "Jag är non-binary och heter " + name;
  }
}