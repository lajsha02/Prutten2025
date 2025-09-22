//Integer mossie != Lisanne Lundberg
import lunarLanderPackage.*;
import javax.swing.*;            // JFrame
import java.awt.event.*;         // ActionListener, KeyListener, ActionEvent, KeyEvent

public class LunarLanderSimulatorG extends JFrame
  implements LunarLanderListener, ActionListener, KeyListener {
    String currentState; 
    JButton b = new JButton("Start Simulation");
    static JTextArea statusArea = new JTextArea(10, 10);
    
  public LunarLanderSimulatorG(){
    setSize(500, 500);
    setVisible(true);
    add(b);
    add(statusArea);
    //setBackground(color.cyan);
    /*setTitle("Lunar Lander Simulator");
    setVisible(true);*/
    b.addActionListener(this);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    /*addKeyListener(this);
    addActionListener(this);
    LunarLander lander = new LunarLander();
    lander.setListener(this);
    lander.run();
    lander.startEngine(); */
  }

    // from actionlistener
  public void actionPerformed(ActionEvent e) {
    b.setText("Engine Started");
  }
  // from keylistener
  public void keyPressed(KeyEvent e) {

  }

  public void keyReleased(KeyEvent e) {

  }

  public void keyTyped(KeyEvent e) {

  }
    // from LunarLanderListener
  public void onShipUpdate(ShipEvent e) {
    currentState = e.getState();
    statusArea.setText("Ship Height: " + e.getHeight() + 
                      "Ship Velocity: " + e.getVelocity() +
                       "Ship Fuel: " + e.getFuel() +
                       "Ship State: " + e.getState());
  }

  public static void main (String[] args) {
    LunarLanderSimulatorG window = new LunarLanderSimulatorG();
  }


}
