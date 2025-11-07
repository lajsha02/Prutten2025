//line 261 "HumanFactory.nw"
import human.Human;

public class TestHuman {
	
//line 272 "HumanFactory.nw"
	public static void main(String[] args) {
		Human billie = Human.create("Billie", "xxxxxx-560x"); // näst sista = 0 -> NonBinary
		Human anna   = Human.create("Anna",   "xxxxxx-642x"); // näst sista = 2 -> Woman
		Human magnus = Human.create("Magnus", "xxxxxx-011x"); // näst sista = 1 -> Man

		System.out.println(billie);
		System.out.println(anna);
		System.out.println(magnus);

		// Följande rader ska INTE kompilera (demonstreras separat, inte i detta program):
		// NonBinary nb = new NonBinary("X", "000000-5600");    // ej synlig utanför paketet
		// Human h = new Human("X", "000000-5600") {};          // Human() ej synlig + abstrakt
	}
//line 265 "HumanFactory.nw"
}
