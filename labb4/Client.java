
public class  Client {

  public static void main(String[] args){
    Composite resväska = new Composite("resväska", 10);
    resväska.add(new Leaf("pass", 1));
    resväska.add(new Leaf("Kokain", 2));
    resväska.add(new Leaf("Hash", 2.5));
    resväska.add(new Leaf("Atombomb", 500));

    resväska.add(new Leaf("plånbok", 0.2));
    Composite laptopväska = new Composite("laptopväska", 5);
    laptopväska.add(new Leaf("laptop", 2));

    System.out.println("Vikten av laptopväskan är: " + laptopväska.getWeight() + " kg");
    System.out.println("Vikten av resväskan är: " + resväska.getWeight() + " kg");

  }
}