package HumanFactory;

public  class Woman extends Human {
    public Woman(String name, String pnr) {
      super(name, pnr);
    }
    @Override
    public String toString() {
        return "Jag är kvinna och heter " + name;
    }
}
