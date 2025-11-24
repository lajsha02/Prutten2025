//line 101 "Suitcase.nw"
public abstract class Component {
  
//line 119 "Suitcase.nw"
  private final String name;
  private final double weight;
//line 103 "Suitcase.nw"
  
//line 127 "Suitcase.nw"
  Component(String name, double weight) {
    this.name = name;
    this.weight = weight;
  }
//line 104 "Suitcase.nw"
  
//line 145 "Suitcase.nw"
  public String getName() {
    return name;
  }

  public double getOwnWeight() {
    return weight;
  }

  public abstract double getWeight();
  public abstract String toString();
//line 105 "Suitcase.nw"
}
