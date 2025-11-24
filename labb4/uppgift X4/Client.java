//line 413 "Suitcase.nw"
public class Client {
  public static void main(String[] args) {
    
//line 427 "Suitcase.nw"
    // Roten: själva resväskan
    Composite suitcase = new Composite("Resväska", 2.3);

    // Necessär (behållare) med egen vikt 0.12 kg och innehåll
    Composite necessar = new Composite("Necessär", 0.12);
    necessar.add(new Leaf("Tvål",        0.09));
    necessar.add(new Leaf("Schampo",     0.22));
    necessar.add(new Leaf("Tandborste",  0.03));
    necessar.add(new Leaf("Tandkräm",    0.11));

    // Påse i necessären (tredje nivån)
    Composite pase = new Composite("Påse", 0.01);
    pase.add(new Leaf("Hårspännen (10 st)", 0.02));
    necessar.add(pase);

    // Mindre väska (nivå två)
    Composite techbag = new Composite("Tech-väska", 0.20);
    techbag.add(new Leaf("Laddare", 0.15));

    // Packa allt i resväskan
    suitcase.add(new Leaf("T-shirt vit",   0.18));
    suitcase.add(new Leaf("T-shirt svart", 0.19));
    suitcase.add(new Leaf("Jeans",         0.75));
    suitcase.add(new Leaf("Chinos",        0.55));
    suitcase.add(new Leaf("Pocketbok",     0.28));
    suitcase.add(necessar);
    suitcase.add(techbag);
//line 416 "Suitcase.nw"
    
//line 458 "Suitcase.nw"
    System.out.printf("Totalvikt före borttagning: %.2f kg%n", suitcase.getWeight());
    System.out.println("Innehåll före borttagning:");
    System.out.println(suitcase.toString());
//line 417 "Suitcase.nw"
    
//line 468 "Suitcase.nw"
    System.out.println("Bredden-först (for-each, default iterator):");
    for (Component c : suitcase) {
      System.out.print(c.getName() + " ");
    }
    System.out.println();
//line 418 "Suitcase.nw"
    
//line 476 "Suitcase.nw"
    System.out.println("Preorder (djupet-först, explicit iterator):");
    java.util.Iterator<Component> it = new PreorderIterator(suitcase);
    while (it.hasNext()) {
      System.out.print(it.next().getName() + " ");
    }
    System.out.println();
//line 419 "Suitcase.nw"
  }
}
