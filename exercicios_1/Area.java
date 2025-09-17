package exercicios_1;

import java.util.Scanner;
import java.lang.Math;

public class Area {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        double PI = 3.14159;
        double area, radius;
        
        radius = r.nextDouble();
        
        r.close();
        
        area = PI*(Math.pow(radius, 2));
        
        System.out.printf("A=%.4f\n", area);
    }
}