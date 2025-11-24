//line 362 "Suitcase.nw"
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PreorderIterator implements Iterator<Component> {
  private final Deque<Component> stack = new ArrayDeque<>();

  // börja med roten överst på stacken
  public PreorderIterator(Component root) {
    stack.push(root);
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public Component next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Component current = stack.pop();
    if (current instanceof Composite) {
      List<Component> children = ((Composite) current).getChildren();
      // lägg barnen i omvänd ordning så att första barnet kommer överst
      for (int i = children.size() - 1; i >= 0; i--) {
        stack.push(children.get(i));
      }
    }
    return current;
  }

  @Override
  public void remove() {
    // används inte i den här labben
  }
}
