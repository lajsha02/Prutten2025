public class Leaf extends Component {
  public Leaf(String name, double weight) {
    super(name, weight);
  }

  @Override
  public double getWeight() {
    return super.weight;
  }

  @Override
  public String toString() {
    return super.name + " (" + super.weight + ")";
  }
}