package quoridor.model;

interface myObservable {
  void addObserver(myObserver o);
  void removeObserver(myObserver o);
  void notifyObservers();  
}