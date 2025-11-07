//line 371 "Suitcase.nw"
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PreorderIterator implements Iterator<Component> {
  
//line 390 "Suitcase.nw"
  private final Deque<Component> stack = new ArrayDeque<>();
//line 379 "Suitcase.nw"
  
//line 397 "Suitcase.nw"
  public PreorderIterator(Component root) {
    if (root == null) throw new IllegalArgumentException("root");
    stack.push(root);
  }
//line 380 "Suitcase.nw"
  
//line 405 "Suitcase.nw"
  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }
//line 381 "Suitcase.nw"
  
//line 415 "Suitcase.nw"
  @Override
  public Component next() {
    if (stack.isEmpty()) throw new NoSuchElementException();
    Component current = stack.pop();
    if (current instanceof Composite) {
      List<Component> children = ((Composite) current).getChildren();
      for (int i = children.size() - 1; i >= 0; i--) {
        stack.push(children.get(i));
      }
    }
    return current;
  }
//line 382 "Suitcase.nw"
  
//line 433 "Suitcase.nw"
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
//line 383 "Suitcase.nw"
}
