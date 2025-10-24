package exercicios_1;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class AcerteONumero {
    public static void main(String[] args) {
        int escolhaComputador=-1, escolhaJogador=-1, numMax = 10, numTentativas=3;
        boolean loop;

        Random random = new Random();
        Scanner reader = new Scanner(System.in);

        escolhaComputador = random.nextInt(numMax+1);

        for(int i = numTentativas; i>0; i--) {

            do {
                loop = false;
                try {
                    System.out.print("Escola um número de 0 a 10: ");
                    escolhaJogador = reader.nextInt();

                    if (escolhaJogador > 10 || escolhaJogador < 0) {
                        System.out.println("Escolha inválida.");
                        reader.nextLine();
                        loop = true;
                    }
                } catch(InputMismatchException e) {
                    System.out.println("Entrada inválida.");
                    reader.nextLine();
                    loop = true;
                }
            } while(loop);

            reader.nextLine();

            if(escolhaJogador < escolhaComputador) {
                System.out.println("O seu número é menor que o escolhido pelo computador.");
            } else if (escolhaJogador > escolhaComputador) {
                System.out.println("O seu número é maior que o escolhido pelo computador.");
            } else {
                System.out.printf("Parabéns! O número escolhido foi: %d\n", escolhaComputador);
                reader.close();
                return;
            }
        }

        System.out.printf("Você perdeu. O número escolhido foi: %d\n", escolhaComputador);
        reader.close();
    }
}
