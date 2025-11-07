package quoridor.controller;

import quoridor.model.ObservableModel; 
import quoridor.view.MyView;

public class MainObserver {
  public static void main(String[] args) {
    ObservableModel model = new ObservableModel();
    MyView view = new MyView(model);


    model.addObserver(view);

    // Controller kör drag på modellen
    new QuoridorControl(model, view).run();
  }
}