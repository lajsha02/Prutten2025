//line 145 "Suitcase.nw"
public class Leaf extends Component {
  
//line 155 "Suitcase.nw"
  public Leaf(String name, double weight) {
    super(name, weight);
  }
//line 147 "Suitcase.nw"
  
//line 164 "Suitcase.nw"
  @Override
  public double getWeight() {
    return this.weight;
  }

  @Override
  public String toString() {
    return this.name + " (" + this.weight + " kg)";
  }
//line 148 "Suitcase.nw"
}
