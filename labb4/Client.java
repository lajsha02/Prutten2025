//line 268 "Suitcase.nw"
public class Client {
  public static void main(String[] args) {
    
//line 282 "Suitcase.nw"
    // Roten: själva resväskan (egen vikt 2.3 kg)
    Composite suitcase = new Composite("Resväska", 2.3);

    // Större plagg (löven)
    Leaf tshirt1 = new Leaf("T-shirt vit", 0.18);
    Leaf tshirt2 = new Leaf("T-shirt svart", 0.19);
    Leaf jeans   = new Leaf("Jeans", 0.75);
    Leaf chinos  = new Leaf("Chinos", 0.55);
    Leaf bok     = new Leaf("Pocketbok", 0.28);

    // Necessär (behållare) med egen vikt 0.12 kg och innehåll
    Composite necessar = new Composite("Necessär", 0.12);
    Leaf tvål     = new Leaf("Tvål", 0.09);
    Leaf schampo  = new Leaf("Schampo", 0.22);
    Leaf borste   = new Leaf("Tandborste", 0.03);
    Leaf tandkräm = new Leaf("Tandkräm", 0.11);
    necessar.add(tvål);
    necessar.add(schampo);
    necessar.add(borste);
    necessar.add(tandkräm);

    // Påse i necessären (tredje nivån)
    Composite påse = new Composite("Påse", 0.01);
    Leaf hårspännen = new Leaf("Hårspännen (10 st)", 0.02);
    påse.add(hårspännen);
    necessar.add(påse);

    // Mindre väska för elektronik (behållare) — nivå två
    Composite techbag = new Composite("Tech-väska", 0.20);
    Leaf laddare  = new Leaf("Laddare", 0.15);
    Leaf hörlurar = new Leaf("Hörlurar", 0.08);
    Leaf powerbank = new Leaf("Powerbank", 0.18);
    techbag.add(laddare);
    techbag.add(hörlurar);
    techbag.add(powerbank);

    // Packa allt i resväskan
    suitcase.add(tshirt1);
    suitcase.add(tshirt2);
    suitcase.add(jeans);
    suitcase.add(chinos);
    suitcase.add(bok);
    suitcase.add(necessar);
    suitcase.add(techbag);
//line 271 "Suitcase.nw"
    
//line 330 "Suitcase.nw"
    System.out.printf("Totalvikt före borttagning: %.2f kg%n", suitcase.getWeight());
    System.out.println("Innehåll före borttagning:");
    System.out.println(suitcase.toString());
//line 272 "Suitcase.nw"
    
//line 339 "Suitcase.nw"
    techbag.remove(powerbank);      // ta bort en pryl i behållare
    suitcase.remove(techbag);       // ta bort hela behållaren
    necessar.remove(påse);          // ta bort tredje nivåns behållare
//line 273 "Suitcase.nw"
    
//line 346 "Suitcase.nw"
    System.out.printf("Totalvikt efter borttagning: %.2f kg%n", suitcase.getWeight());
    System.out.println("Innehåll efter borttagning:");
    System.out.println(suitcase.toString());
//line 274 "Suitcase.nw"
  }
}
