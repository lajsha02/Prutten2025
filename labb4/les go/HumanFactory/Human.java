package HumanFactory;

public abstract class Human {
  public String pnr;
  public String name;
  Human(String name, String pnr) {
    this.name = name;
    this.pnr = pnr;
  }
  
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

  @Override
  public String toString() {
      // fallback om någon instansierar en anonym klass
      return "Jag är människa och heter " + name;
  }
}
  


   // Om näst sista tecknet är noll ('0') så returneras ett objekt av NonBinary, om det är en udda siffra så ska en instans av Man returneras, om den är jämn men inte noll så returneras ett objekt av Woman