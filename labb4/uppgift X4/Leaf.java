//line 154 "Suitcase.nw"
public class Leaf extends Component {
  
//line 164 "Suitcase.nw"
  public Leaf(String name, double weight) {
    super(name, weight);
  }
//line 156 "Suitcase.nw"
  
//line 173 "Suitcase.nw"
  @Override
  public double getWeight() {
    return this.weight;
  }

  @Override
  public String toString() {
    return this.name + " (" + this.weight + " kg)";
  }
//line 157 "Suitcase.nw"
}
