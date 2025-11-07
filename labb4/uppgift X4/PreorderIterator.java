//line 369 "Suitcase.nw"
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PreorderIterator implements Iterator<Component> {
  
//line 388 "Suitcase.nw"
  private final Deque<Component> stack = new ArrayDeque<>();
//line 377 "Suitcase.nw"
  
//line 395 "Suitcase.nw"
  public PreorderIterator(Component root) {
    if (root == null) throw new IllegalArgumentException("root");
    stack.push(root);
  }
//line 378 "Suitcase.nw"
  
//line 403 "Suitcase.nw"
  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }
//line 379 "Suitcase.nw"
  
//line 413 "Suitcase.nw"
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
//line 380 "Suitcase.nw"
  
//line 431 "Suitcase.nw"
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
//line 381 "Suitcase.nw"
}
