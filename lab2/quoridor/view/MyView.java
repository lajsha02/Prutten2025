package quoridor.view;

import quoridor.model.QuoridorModel; 
import quoridor.model.myObserver;

public class  MyView extends QuoridorView implements myObserver {

  public MyView(QuoridorModel model) {
    super(model);
  }
  
  @Override
  public void update() {
      this.render();
    }
}
