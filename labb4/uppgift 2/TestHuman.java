//line 225 "HumanFactory.nw"
import human.Human;

public class TestHuman {
  
//line 236 "HumanFactory.nw"
  public static void main(String[] args) {
    Human billie = Human.create("Billie", "xxxxxx-560x"); 
    Human anna   = Human.create("Anna",   "xxxxxx-642x"); 
    Human magnus = Human.create("Magnus", "xxxxxx-011x"); 

    System.out.println(billie);
    System.out.println(anna);
    System.out.println(magnus);

    // Följande rader ska INTE kompilera
    //NonBinary nb = new NonBinary("X", "000000-5600");    // ej synlig utanför paketet
    //Human h = new Human("X", "000000-5600") {};          // Human() ej synlig + abstrakt
  }
//line 229 "HumanFactory.nw"
}
