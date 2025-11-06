import java.util.*;

public class Composite extends Component {
  private List<Component> children = new ArrayList<>();

  public Composite(String name, double weight) {
    super(name, weight);
  }


  public void add(Component component) {
    children.add(component);
  }

  public void remove(Component component) {
    children.remove(component);
  }

  public Component getChild(int index) {
    return children.get(index);
  }

  @Override
  public double getWeight() {
    double totalWeight = 0;
    for (Component child : children) {
      totalWeight += child.getWeight();
      
    }
    return totalWeight;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.name).append(" (").append(") [");
    for (Component child : children) {
      sb.append(child.toString()).append(", ");
    }
    sb.append("]");
    
    return sb.toString();
  }
}