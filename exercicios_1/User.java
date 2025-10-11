package exercicios_1;

import java.util.InputMismatchException;
import java.lang.Math;
import java.util.Scanner;

public class User {
    private float weight;
    private float height;
    private double IMC;
    private String IMCCLassification;

    public static void main(String[] args) {
        User user = new User();

        user.setUserInformation();
        user.setIMC();
        user.setIMCCLassification();
        
        System.out.printf("IMC: %f\nIMC classification: %s\n", user.IMC, user.IMCCLassification);
    }

    // set user information
    private void setUserInformation() {
        Scanner reader = new Scanner(System.in);

        try {
            // get height
            System.out.print("Height: ");
            this.height = reader.nextFloat();

            // get weight
            System.out.print("Weight: ");
            this.weight = reader.nextFloat();

        } catch (InputMismatchException e) {
            System.out.println(e);
        } finally {
            reader.close();
        }
    }

    // calculate and set IMC value
    private void setIMC() {
        try {
            this.IMC = this.weight / Math.pow(this.height, 2);
        } catch(ArithmeticException e) {
            System.out.println(e);
        }
    }

    // set IMC classification
    private void setIMCCLassification() {
        if (this.IMC < 18.5f) {
            this.IMCCLassification = "Underweight";
        } else if (this.IMC <= 24.9f) {
            this.IMCCLassification = "Normal weight";
        } else if (this.IMC <= 29.9f) {
            this.IMCCLassification = "Overweight";
        } else if (this.IMC <= 34.9f) {
            this.IMCCLassification = "Obersity class I";
        } else if (this.IMC <= 39.9f) {
            this.IMCCLassification = "Obesity class II";
        } else {
            this.IMCCLassification = "Obesity class III";
        }
    }
}