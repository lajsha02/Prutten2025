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

// javac -d out HumanFactory/*.java
// javac -cp out -d out TestHuman.java
// java TestHuman