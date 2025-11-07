//line 146 "Suitcase.nw"
public class Leaf extends Component {
  
//line 156 "Suitcase.nw"
  public Leaf(String name, double weight) {
    super(name, weight);
  }
//line 148 "Suitcase.nw"
  
//line 165 "Suitcase.nw"
  @Override
  public double getWeight() {
    return this.weight;
  }

  @Override
  public String toString() {
    return this.name + " (" + this.weight + " kg)";
  }
//line 149 "Suitcase.nw"
}
