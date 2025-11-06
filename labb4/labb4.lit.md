# Labb 4 – Litterär programmering

Vi vill skapa en fabrik `Human.create(name, pnr)` som tolkar näst sista siffran:
- 0 → NonBinary
- jämn (ej 0) → Woman
- udda → Man

## Human.java
```java file=src/HumanFactory/Human.java
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
```

## Woman.java
```java file=src/HumanFactory/Woman.java
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
```

## Man.java
```java file=src/HumanFactory/Man.java
package HumanFactory;

public class Man extends Human {
  public Man(String name, String pnr) {
    super(name, pnr);
  }
  @Override
    public String toString() {
        return "Jag är man och heter " + name;
    }
}
```

## NonBinary.java
```java file=src/HumanFactory/NonBinary.java
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
```

## TestHuman.java
```java file=src/TestHuman.java
import HumanFactory.Human;

public class TestHuman {
    public static void main (String[] args) {
    Human lisa = Human.create("lisa", "030405-4567");
    Human Mossi = Human.create("Mossi", "123456-9876");
    Human Danya = Human.create("MOSTAFA SHIHADEH","987876-5400");
    System.out.println(lisa);
    System.out.println(Mossi);
    System.out.println(Danya);
    }
}
```
//rm -rf out && mkdir -p out
// find src -name "*.java" -print0 | xargs -0 javac -d out
//java -cp out TestHuman