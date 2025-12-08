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
                System.out.print("Informe um número inteiro positivo ou negativo: ");
                typedNumber = KeyboardReader.readInt();
                if (typedNumber == 0) {
                    System.out.println("O valor informado não é válido.");
                    continue;
                }

                vectorInt[i] = typedNumber;
                
                if (i >= 9) keepLoop = false;
                i++;

            } catch(InputMismatchException e) {
                System.out.println("O valor informado não é válido.");
                KeyboardReader.readLine();
            }
        } while (keepLoop);

        i = 0;
        for (int number : vectorInt) {
            if (number < 0) {
                vectorIntNegative[j] = number;
                j++;
            } else {
                vectorIntPositive[i] = number;
                i++;
            }
        }
    }
}
