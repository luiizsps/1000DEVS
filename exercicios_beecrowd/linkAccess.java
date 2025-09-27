package exercicios_beecrowd;

import java.io.IOException;
import java.util.Scanner;

public class linkAccess {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        
        int t = reader.nextInt();
        int numberFirstLink;
        
        reader.close();
        
        numberFirstLink = 4*t;
        
        System.out.println(numberFirstLink);
        
    }
 
}