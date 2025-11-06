package quoridor.controller;

import quoridor.model.ObservableModel; 
import quoridor.view.MyView;

public class MainObserver {
  public static void main(String[] args) {
    ObservableModel model = new ObservableModel();
    MyView view = new MyView(model);


    model.addObserver(view);

    // samma controller som förut – nu räcker det att controller kör drag på modellen
    new QuoridorControl(model, view).run();
  }
}