//line 203 "Suitcase.nw"
import java.util.*;

public class Composite extends Component implements Iterable<Component> {
  
//line 217 "Suitcase.nw"
  private final List<Component> children = new ArrayList<>();
//line 207 "Suitcase.nw"
  
//line 224 "Suitcase.nw"
  public Composite(String name, double weight) {
    super(name, weight);
  }
//line 208 "Suitcase.nw"
  
//line 234 "Suitcase.nw"
  public void add(Component component) {
    children.add(component);
  }

  public void remove(Component component) {
    children.remove(component);
  }

  public Component getChild(int index) {
    return children.get(index);
  }

  public List<Component> getChildren() {
    return Collections.unmodifiableList(children);
  }
//line 257 "Suitcase.nw"
  @Override
  public double getWeight() {
    double totalWeight = getOwnWeight();
    for (Component child : children) {
      totalWeight += child.getWeight();
    }
    return totalWeight;
  }
//line 273 "Suitcase.nw"
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getName()).append(" (").append(getOwnWeight()).append(") [");
    for (int i = 0; i < children.size(); i++) {
      sb.append(children.get(i).toString());
      if (i < children.size() - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");

    return sb.toString();
  }
//line 209 "Suitcase.nw"
  
//line 294 "Suitcase.nw"
  @Override
  public Iterator<Component> iterator() {
    // default: bredden-först
    return new BreadthFirstIterator(this);
  }

  public Iterator<Component> breadthFirstIterator() {
    return new BreadthFirstIterator(this);
  }

  public Iterator<Component> preorderIterator() {
    return new PreorderIterator(this);
  }
//line 210 "Suitcase.nw"
}
