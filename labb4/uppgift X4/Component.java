//line 105 "Suitcase.nw"
public abstract class Component {
  
//line 121 "Suitcase.nw"
  protected final String name;
  protected final double weight;
//line 107 "Suitcase.nw"
  
//line 129 "Suitcase.nw"
  protected Component(String name, double weight) {
    if (name == null || name.isBlank()) throw new IllegalArgumentException("name");
    if (weight < 0) throw new IllegalArgumentException("weight");
    this.name = name;
    this.weight = weight;
  }
//line 108 "Suitcase.nw"
  
//line 142 "Suitcase.nw"
  public String getName() { return name; }
  public double getOwnWeight() { return weight; }
  public abstract double getWeight();
  @Override public abstract String toString();
//line 109 "Suitcase.nw"
}
