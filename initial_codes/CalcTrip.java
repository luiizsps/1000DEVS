package initial_codes;
import java.util.Scanner;

public class CalcTrip {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);

        int avgSpeed, distance;
        double fuelPrice, timeTrip, fuelConsumption, finalFuelPrice;

        System.out.print("Avg speed (km/h): ");
        avgSpeed = r.nextInt();

        // clear buffer
        r.nextLine();

        System.out.print("Distance (km): ");
        distance = r.nextInt();

        // clear buffer
        r.nextLine();

        System.out.print("Fuel price: ");
        fuelPrice = r.nextDouble();

        // clear buffer
        r.nextLine();

        System.out.print("Liters consumed per km: ");
        fuelConsumption = r.nextDouble();

        // close reader
        r.close();
        
        // calc trip
        timeTrip = distance / avgSpeed;

        // fuel price (cost per km * consuption per km * distance)
        finalFuelPrice = fuelPrice * fuelConsumption * distance;

        System.out.print("Time traveled: "+timeTrip+"\nCost: R$"+finalFuelPrice+"\n");
    }
}