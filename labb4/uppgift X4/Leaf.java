//line 156 "Suitcase.nw"
public class Leaf extends Component {
  
//line 166 "Suitcase.nw"
  public Leaf(String name, double weight) {
    super(name, weight);
  }
//line 158 "Suitcase.nw"
  
//line 175 "Suitcase.nw"
  @Override
  public double getWeight() {
    return this.weight;
  }

  @Override
  public String toString() {
    return this.name + " (" + this.weight + " kg)";
  }
//line 159 "Suitcase.nw"
}
