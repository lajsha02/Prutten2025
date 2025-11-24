//line 266 "Suitcase.nw"
public class Client {
  public static void main(String[] args) {
    
//line 280 "Suitcase.nw"
    // Roten: själva resväskan
    Composite suitcase = new Composite("Resväska", 2.3);

    // Större plagg
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

    // Mindre väska (nivå två)
    Composite techbag = new Composite("Tech-väska", 0.20);
    Leaf laddare  = new Leaf("Laddare", 0.15);
    techbag.add(laddare);
    
    // Packa allt i resväskan
    suitcase.add(tshirt1);
    suitcase.add(tshirt2);
    suitcase.add(jeans);
    suitcase.add(chinos);
    suitcase.add(bok);
    suitcase.add(necessar);
    suitcase.add(techbag);
//line 269 "Suitcase.nw"
    
//line 324 "Suitcase.nw"
    System.out.printf("Totalvikt före borttagning: %.2f kg%n", suitcase.getWeight());
    System.out.println("Innehåll före borttagning:");
    System.out.println(suitcase.toString());
//line 270 "Suitcase.nw"
    
//line 333 "Suitcase.nw"
    suitcase.remove(techbag);       
    necessar.remove(påse);
//line 271 "Suitcase.nw"
    
//line 339 "Suitcase.nw"
    System.out.printf("Totalvikt efter borttagning: %.2f kg%n", suitcase.getWeight());
    System.out.println("Innehåll efter borttagning:");
    System.out.println(suitcase.toString());
//line 272 "Suitcase.nw"
  }
}
