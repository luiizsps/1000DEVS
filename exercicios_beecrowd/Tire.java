package exercicios_beecrowd;

import java.io.IOException;
import java.util.Scanner;

public class Tire {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        
        int desiredPump = reader.nextInt();
        int readPump = reader.nextInt();
        int pumpDiff;
        
        reader.close();
        
        pumpDiff = desiredPump - readPump;
        
        System.out.println(pumpDiff);
    }
 
}
