//line 316 "Suitcase.nw"
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BreadthFirstIterator implements Iterator<Component> {
  private final Deque<Component> queue = new ArrayDeque<>();

  // starta med roten i kön
  public BreadthFirstIterator(Component root) {
    queue.add(root);
  }

  @Override
  public boolean hasNext() {
    return !queue.isEmpty();
  }

  @Override
  public Component next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Component current = queue.removeFirst();
    if (current instanceof Composite) {
      for (Component child : ((Composite) current).getChildren()) {
        queue.addLast(child);
      }
    }
    return current;
  }

  @Override
  public void remove() {
    // används inte i den här labben
  }
}
