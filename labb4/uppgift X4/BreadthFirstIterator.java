//line 299 "Suitcase.nw"
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BreadthFirstIterator implements Iterator<Component> {
  
//line 317 "Suitcase.nw"
  private final Deque<Component> queue = new ArrayDeque<>();
//line 306 "Suitcase.nw"
  
//line 324 "Suitcase.nw"
  public BreadthFirstIterator(Component root) {
    if (root == null) throw new IllegalArgumentException("root");
    queue.add(root);
  }
//line 307 "Suitcase.nw"
  
//line 332 "Suitcase.nw"
  @Override
  public boolean hasNext() {
    return !queue.isEmpty();
  }
//line 308 "Suitcase.nw"
  
//line 342 "Suitcase.nw"
  @Override
  public Component next() {
    if (queue.isEmpty()) throw new NoSuchElementException();
    Component current = queue.removeFirst();
    if (current instanceof Composite) {
      for (Component child : ((Composite) current).getChildren()) {
        queue.addLast(child);
      }
    }
    return current;
  }
//line 309 "Suitcase.nw"
  
//line 359 "Suitcase.nw"
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
//line 310 "Suitcase.nw"
}
