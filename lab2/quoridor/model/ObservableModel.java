package quoridor.model;

import java.util.*;

public class ObservableModel extends QuoridorModel implements myObservable {
  private final List<myObserver> observers = new ArrayList<>();
  
  @Override
  public void addObserver(myObserver o) {
    if (o != null && !observers.contains(o)) observers.add(o);
  }
  @Override
  public void removeObserver(myObserver o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    for (myObserver o : observers) {
      o.update();
    }
  }
  
  @Override
    public void movePlayer(BoardState s, int player, int toR, int toC) {
        BoardState before = this.boardState;   // referensen före
        super.movePlayer(s, player, toR, toC); // bas-klassen gör jobbet
        if (this.boardState != before) {       // ändrades state så gör vi ny instans
            notifyObservers();
        }
    }

    @Override
    public void placeWall(BoardState s, int player, int i, int j, boolean vertical) {
        BoardState before = this.boardState;
        super.placeWall(s, player, i, j, vertical);
        if (this.boardState != before) {
            notifyObservers();
        }
      
    }

}