package vetores;
import time_format.KeyboardReader;
import java.util.InputMismatchException;

public class VectorSplit {

    public static void main(String[] args) {
        int vectorInt[] = new int[10];
        int vectorIntPositive[] = new int[10];
        int vectorIntNegative[] = new int[10];
        int i = 0, j = 0, typedNumber;

        boolean keepLoop = true;
        
        do {
            try {
                System.out.print("Input a positive or negative integer: ");
                typedNumber = KeyboardReader.readInt();
                if (typedNumber == 0) {
                    System.out.println("Invalid input.");
                    continue;
                }

                vectorInt[i] = typedNumber;
                
                if (i >= 9) keepLoop = false;
                i++;

            } catch(InputMismatchException e) {
                System.out.println("Invalid input.");
                KeyboardReader.readLine();
            }
        } while (keepLoop);

        System.out.println("Negative numbers:");

        for (int number : vectorInt) {
            if (number < 0) {
                vectorIntNegative[j] = number;
                System.out.println(number);
                j++;
            }
        }

        System.out.println("Positive numbers:");

        i = 0;
        for (int number : vectorInt) {
            if (number > 0) {
                System.out.println(number);
                vectorIntPositive[i] = number;
                i++;
            }
        }

        float percentagePos = ((float) i/vectorInt.length) * 100;
        float percentageNeg = ((float) j/vectorInt.length) * 100;

        System.out.printf("Positive numbers count: %d\n", i);
        System.out.printf("Negative numbers count: %d\n", j);
        
        System.out.printf("Percentage of positive numbers: %.2f%%\nPercentage of negative numbers: %.2f%%\n", percentagePos, percentageNeg);
    }
}
