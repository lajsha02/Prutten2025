//line 184 "Suitcase.nw"
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite extends Component {
  
//line 201 "Suitcase.nw"
  private final List<Component> children = new ArrayList<>();
//line 190 "Suitcase.nw"
  
//line 208 "Suitcase.nw"
  public Composite(String name, double ownWeight) {
    super(name, ownWeight);
  }
//line 191 "Suitcase.nw"
  
//line 217 "Suitcase.nw"
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
//line 192 "Suitcase.nw"
  
//line 235 "Suitcase.nw"
  @Override
  public double getWeight() {
    double sum = this.weight;
    for (Component c : children) {
      sum += c.getWeight();
    }
    return sum;
  }
//line 193 "Suitcase.nw"
  
//line 249 "Suitcase.nw"
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
//line 194 "Suitcase.nw"
}
