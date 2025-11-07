//line 192 "Suitcase.nw"
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Composite extends Component implements Iterable<Component> {
  
//line 211 "Suitcase.nw"
  private final List<Component> children = new ArrayList<>();
//line 199 "Suitcase.nw"
  
//line 218 "Suitcase.nw"
  public Composite(String name, double ownWeight) {
    super(name, ownWeight);
  }
//line 200 "Suitcase.nw"
  
//line 227 "Suitcase.nw"
  public void add(Component c) {
    if (c == null) throw new IllegalArgumentException("child");
    children.add(c);
  }

  public void remove(Component c) {
    children.remove(c);
  }

  public List<Component> getChildren() {
    return Collections.unmodifiableList(children);
  }
//line 201 "Suitcase.nw"
  
//line 245 "Suitcase.nw"
  @Override
  public double getWeight() {
    double sum = this.weight;
    for (Component c : children) {
      sum += c.getWeight();
    }
    return sum;
  }
//line 202 "Suitcase.nw"
  
//line 259 "Suitcase.nw"
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.name).append(" (").append(this.weight).append(" kg) [");
    for (int i = 0; i < children.size(); i++) {
      sb.append(children.get(i).toString());
      if (i < children.size() - 1) sb.append(", ");
    }
    sb.append("]");
    return sb.toString();
  }
//line 203 "Suitcase.nw"
  
//line 277 "Suitcase.nw"
  @Override
  public Iterator<Component> iterator() {
    return new BreadthFirstIterator(this);
  }

  public Iterator<Component> breadthFirstIterator() {
    return new BreadthFirstIterator(this);
  }

  public Iterator<Component> preorderIterator() {
    return new PreorderIterator(this);
  }
//line 204 "Suitcase.nw"
}
