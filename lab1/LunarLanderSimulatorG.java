import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import lunarLanderPackage.*;

// ============ HUVUDKLASS ================
/* Hanterar autopilot och användarinput. Simulerar Lunarlanderspel i en grafisk interface */
public class LunarLanderSimulatorG extends JFrame
  implements LunarLanderListener, ActionListener, KeyListener {
    private String currentState; // klassattribut för att hålla koll på landarens status
    private final JButton b = new JButton("Start Simulation"); // knappen som startar simuleringen
    private final JTextArea statusArea = new JTextArea(10, 10);
    private final LunarLander lander = new LunarLander();

    private boolean gameOver = false;
    private boolean GenerateAutopilot;
    private final int OVERRIDE_MS = 4000;          // hur länge användaren har kontroll
    private long manualOverrideExpiresAt = 0;      // timestamp i ms
    private void touchManualOverride() { // nu + 4000 = sluttid av användarens input
        manualOverrideExpiresAt = System.currentTimeMillis() + OVERRIDE_MS;
    }
    private boolean isManualOverrideActive() { // jämför om nu är före sluttiden. Om ja → manuell kontroll.
        return System.currentTimeMillis() < manualOverrideExpiresAt;
    }

    // ============ KONSTRUKTOR ================
  public LunarLanderSimulatorG(boolean GenerateAutopilot){
    this.GenerateAutopilot = GenerateAutopilot;

        // --- Grundläggande fönsterinställningar ---
        setTitle("Lunar Lander Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null); // centrera på skärmen


        // --- Statusrutan ---
        statusArea.setEditable(false);     // visa bara text
        statusArea.setFocusable(false);    // sno inte fokus från ramen
        statusArea.setBackground(Color.pink);
        statusArea.setFont(statusArea.getFont().deriveFont(22f));

        // --- Knapp ---
        b.addActionListener(this);
        b.setFocusable(false);             // knappen får aldrig fokus

        // --- Layout ---
        add(b, "North");
        add(new JScrollPane(statusArea), "Center");

        // --- Lyssnare ---
        addKeyListener(this);     // lyssna på piltangenter på ramen
        setFocusable(true);       // ramen måste vara fokusbar
        lander.setListener(this); // koppla listener till landersimulation

        // --- Visa och säkra fokus ---
        setVisible(true);         // visa fönstret
        requestFocusInWindow();   // be om fokus till ramen (så key events kommer hit)
    }

    // ============ FROM ACTIONLISTENER ================
  @Override
  public void actionPerformed(ActionEvent e) {
    String label = e.getActionCommand();

    // Kollar vilken knapp som trycktes och utför motsvarande åtgärd
    switch (label) {  
      case "Start Simulation":
          lander.run();
          b.setText("Start Engine"); // Ändrar knapptexten
          break;

      case "Start Engine":
          touchManualOverride();
          lander.startEngine();
          b.setText("Shut Down Engine"); // Ändrar knapptexten
          break;

      case "Shut Down Engine":
          touchManualOverride();
          lander.shutDownEngine();
          b.setText("Start Engine"); // Ändrar knapptexten
          break; 

      case "Exit":
        System.exit(0);
        break;

    }
  }

  // ============ FROM KEYLISTENER ================
  @Override
  public void keyPressed(KeyEvent e) { // Kollar om användaren trycker på tangenter

  }

  @Override
  public void keyReleased(KeyEvent e) { // Kollar om användaren släpper på tangenter
    int code = e.getKeyCode();
    // Kollar vilken tangent som släpptes och utför motsvarande åtgärd
    if (code == KeyEvent.VK_UP) {
      touchManualOverride();
      lander.startEngine();
      if (!gameOver) b.setText("Shut Down Engine"); // Ändrar knapptexten
    } 
    else if (code == KeyEvent.VK_DOWN) {
      touchManualOverride();
      lander.shutDownEngine();
      if (!gameOver) b.setText("Start Engine"); // Ändrar knapptexten
      }

  }

  @Override
  public void keyTyped(KeyEvent e) { // Kollar om användaren skriver med tangentbordet

  }

  // ============ FROM SHIPEVENT ================
  @Override
  public void onShipUpdate(ShipEvent e) {
      String action = null; 

      if (GenerateAutopilot && !isManualOverrideActive()) {
          action = Autopilot(e);
      }
      // Kollar om autopiloten är aktiv eller om användaren har kontroll
      String control;
      if (isManualOverrideActive()) {
          control = "USER"; }
      else if (GenerateAutopilot) {
          control = "AUTOPILOT"; }
      else { control = "USER"; }

      String base = "Ship Height: " + e.getHeight() + "\n" +
                    "Ship Velocity: " + e.getVelocity() + "\n" +
                    "Ship Fuel: " + e.getFuel() + "\n" +
                    "Ship State: " + e.getState() + "\n" +
                    "Control: " + control;

      // Uppdaterar autopilotens status i statusrutan
          statusArea.setText(base);
          if (action != null) {
            statusArea.append("\nAutopilot: " + action);
          }
        if (!"hovering".equals(e.getState())) {
            gameOver = true;
            b.setText("Exit");
        }
}

// ==================== AUTOPILOT ========================
  public String Autopilot(ShipEvent e) {
    double vTarget;
    if (e.getHeight() > 50) {
      vTarget = -3.5; }
    else if (e.getHeight() > 20) {
      vTarget = -2.0; }
    else if (e.getHeight() > 5) {
      vTarget = -1.2; }
    else { vTarget = -0.8; }

      if (e.getVelocity() < vTarget) {
        lander.startEngine();
        if (!gameOver) b.setText("Shut Down Engine"); 
        return "Engine ON"; }

      else if (e.getVelocity() > vTarget) {
        lander.shutDownEngine();
        if (!gameOver) b.setText("Start Engine");
        return "Engine OFF";
      }

      return null; 
    }


  public static void main(String[] args) {
    // Kollar om autopilot ges som ett argument
    boolean GenerateAutopilot = args.length > 0 && args[0].equals("autopilot");
    LunarLanderSimulatorG window = new LunarLanderSimulatorG(GenerateAutopilot);
}
}