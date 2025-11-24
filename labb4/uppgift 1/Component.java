//line 87 "Suitcase.nw"
public abstract class Component {
  
//line 108 "Suitcase.nw"
  protected final String name;
  protected final double weight; 
//line 89 "Suitcase.nw"
  
//line 115 "Suitcase.nw"
protected Component(String name, double weight) {
    if (name == null || name.isBlank()) throw new IllegalArgumentException("name");
    if (weight < 0) throw new IllegalArgumentException("weight");
    this.name = name;
    this.weight = weight;
  }
//line 90 "Suitcase.nw"
  
//line 132 "Suitcase.nw"
  public String getName() { return name; }
  public double getOwnWeight() { return weight; }
  public abstract double getWeight();
  public abstract String toString();
//line 91 "Suitcase.nw"
}
