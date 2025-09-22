//Integer mossie != Lisanne Lundberg
import lunarLanderPackage.*;
import javax.swing.*;            // JFrame
import java.awt.event.*;         // ActionListener, KeyListener, ActionEvent, KeyEvent
import java.awt.Color;

public class LunarLanderSimulatorG extends JFrame
  implements LunarLanderListener, ActionListener, KeyListener {
    String currentState; 
    JButton b = new JButton("Start Simulation");
    static JTextArea statusArea = new JTextArea(10, 10);
    LunarLander lander = new LunarLander();


  public LunarLanderSimulatorG(){
    setSize(500, 500);
    setVisible(true);
    add(b);
    setBackground(Color.GREEN);
    add(new JScrollPane(statusArea));  

    /*setTitle("Lunar Lander Simulator");
    setVisible(true);*/
    b.addActionListener(this);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    lander.setListener(this);

    /*addKeyListener(this);
    addActionListener(this);
    LunarLander lander = new LunarLander();
    lander.setListener(this);
    lander.run();
    lander.startEngine(); */
  }

    // from actionlistener
  public void actionPerformed(ActionEvent e) {
    String label = e.getActionCommand();
    switch (label) {  
      case "Start Simulation":
          new Thread(() -> lander.run()).start();  // i stället för lander.run();
          b.setText("Start Engine");
          break;

      case "Start Engine":
          lander.startEngine();
          b.setText("Shut Down Engine");
          break;

      case "Shut Down Engine":
          lander.shutDownEngine();
          b.setText("Start engine");
          break;

      case "Exit":
        System.exit(0);
        break;

    }
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

  public static void main (String[] u) {
    LunarLanderSimulatorG window = new LunarLanderSimulatorG();
  }


}
