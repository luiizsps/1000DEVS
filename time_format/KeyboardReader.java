package time_format;

import java.util.Scanner;
import java.util.InputMismatchException;

public class KeyboardReader {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() throws InputMismatchException{
        return scanner.nextLine();
    }

    public static int readInt() throws InputMismatchException {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static double readDouble() throws InputMismatchException {
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }
}
