//line 107 "Suitcase.nw"
public abstract class Component {
  
//line 123 "Suitcase.nw"
  protected final String name;
  protected final double weight;
//line 109 "Suitcase.nw"
  
//line 131 "Suitcase.nw"
  protected Component(String name, double weight) {
    if (name == null || name.isBlank()) throw new IllegalArgumentException("name");
    if (weight < 0) throw new IllegalArgumentException("weight");
    this.name = name;
    this.weight = weight;
  }
//line 110 "Suitcase.nw"
  
//line 144 "Suitcase.nw"
  public String getName() { return name; }
  public double getOwnWeight() { return weight; }
  public abstract double getWeight();
  @Override public abstract String toString();
//line 111 "Suitcase.nw"
}
