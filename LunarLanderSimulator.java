import java.util.Scanner;
import lunarLanderPackage.*;

public class LunarLanderSimulator implements LunarLanderListener {
    // Implementerar LunarLanderListener
/* getHeight() → aktuell höjd i meter

getVelocity() → aktuell hastighet i m/s

getFuel() → återstående bränsle i procent

getState()*/
    
    public void onShipUpdate(ShipEvent e) {
        System.out.println("Ship Height: " + e.getHeight() + 
                          "Ship Velocity: " + e.getVelocity() +
                           "Ship Fuel: " + e.getFuel() +
                           "Ship State: " + e.getState());
    }

    
    public static void main(String[] args) {
        System.out.println("Lunar Lander Simulator");      
        LunarLander lander = new LunarLander();
        //shutdown = new shutDownEngine();
        LunarLanderSimulator simulator = new LunarLanderSimulator();
        lander.setListener(simulator);
        lander.run();
    }
}