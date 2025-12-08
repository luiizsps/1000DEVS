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

        System.out.println("Números Negativos: ");

        for (int number : vectorInt) {
            if (number < 0) {
                vectorIntNegative[j] = number;
                System.out.println(number);
                j++;
            }
        }

        System.out.println("Números Positivos: ");

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

        System.out.printf("Quantidade de números positivos: %d\n", i);
        System.out.printf("Quantidade de números negativos: %d\n", j);
        
        System.out.printf("Porcentagem de números positivos: %.2f%%\nPorcentagem de números negativos: %.2f%%\n", percentagePos, percentageNeg);
    }
}
