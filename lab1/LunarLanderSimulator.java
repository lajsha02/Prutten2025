import java.util.Scanner;
import lunarLanderPackage.*;

    public class LunarLanderSimulator implements LunarLanderListener {
        String currentState = "hovering"; 
        // Implementerar LunarLanderListener
    /* getHeight() → aktuell höjd i meter
    getVelocity() → aktuell hastighet i m/s
    getFuel() → återstående bränsle i procent
    getState()*/

        public void onShipUpdate(ShipEvent e) {
            currentState = e.getState();
            System.out.println("Ship Height: " + e.getHeight() + 
                              "Ship Velocity: " + e.getVelocity() +
                               "Ship Fuel: " + e.getFuel() +
                               "Ship State: " + e.getState());
            if (!currentState.equals("hovering")) {
                System.out.println("Final State: " + e.getState());
                System.exit(0);
            }
        }


        public static void main(String[] args) {
            System.out.println("Lunar Lander Simulator");      
            LunarLander lander = new LunarLander();
            LunarLanderSimulator simulator = new LunarLanderSimulator();
            lander.setListener(simulator);
            lander.run();

            Scanner input = new Scanner(System.in);
            System.out.println("Press P to start the engine and A to shut it down: ");
            // Så länge som state är hovering så kan användaren styra
            while (simulator.currentState.equals("hovering")) {
                String S = input.nextLine();
                if (S.equals("P")) {
                    lander.startEngine();
                    System.out.println("Engine Started");
                }
                else if (S.equals("A")) { 
                    lander.shutDownEngine();
                    System.out.println("Engine Shutdown");
                }

            }
            input.close();
    }
    }