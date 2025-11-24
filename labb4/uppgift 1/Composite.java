//line 183 "Suitcase.nw"
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite extends Component {
  
//line 198 "Suitcase.nw"
  private final List<Component> children = new ArrayList<>();
//line 189 "Suitcase.nw"
  
//line 205 "Suitcase.nw"
  public Composite(String name, double ownWeight) {
    super(name, ownWeight);
  }
//line 190 "Suitcase.nw"
  
//line 215 "Suitcase.nw"
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
//line 233 "Suitcase.nw"
  @Override
  public double getWeight() {
    double sum = this.weight;
    for (Component c : children) {
      sum += c.getWeight();
    }
    return sum;
  }
//line 247 "Suitcase.nw"
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
//line 191 "Suitcase.nw"
}
