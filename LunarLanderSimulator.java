//import java.util.Scanner;
import lunarLanderPackage.*;

public class LunarLanderSimulator implements LunarLanderListener {
    // Implementerar LunarLanderListener
/* getHeight() → aktuell höjd i meter

getVelocity() → aktuell hastighet i m/s

getFuel() → återstående bränsle i procent

getState()*/
    
    public void onShipUpdated(Shipevent e) {
        System.out.println("Ship Height: " + e.getHeight().toString() + 
                          "Ship Velocity: " + e.getVelocity().toString() +
                           "Ship Fuel: " + e.getFuel().toString() +
                           "Ship State: " + e.getState().toString());
    }

    
    public static void main(String[] args) {
        System.out.println("Lunar Lander Simulator");
        // Add your lunar lander logic here
    }
}
