package exercicios_1;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class PedraPapelTesoura {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int escolhaComputador=-1, escolhaJogador=-1;
        boolean loop;
        Random random = new Random();
        String resultadoFinal= "";

        String[][] resultadosPossiveis = {
            {"pedra", "papel", "Computador venceu!"},
            {"pedra", "tesoura", "Você venceu!"},
            {"papel", "pedra", "Você venceu!"},
            {"papel", "tesoura", "Computador venceu!"},
            {"tesoura", "pedra", "Computador venceu!"},
            {"tesoura", "papel", "Você venceu!"}
        };
        String[] opcoes = {"pedra", "papel", "tesoura"};

        // recebe escolha do usuário
        do {
            loop = false;
            try {
                System.out.print("Escolha:\n[1] Pedra\n[2] Papel\n[3] Tesoura\n:");
                escolhaJogador = reader.nextInt();

            } catch(InputMismatchException  e) {
                System.out.println("Entrada inválida.");
                reader.nextLine(); // limpa buffer
                loop = true;
            }
        } while(loop);

        reader.close();

        // sorteia esoclha do computador
        escolhaComputador = random.nextInt(opcoes.length);


        System.out.printf("Jogador escolheu: %s\nComputador escolheu: %s\n", opcoes[escolhaJogador-1], opcoes[escolhaComputador]);

        if ((escolhaJogador-1) == escolhaComputador) {
            System.out.println("Empate.");
        } else {
            for(String[] resultado : resultadosPossiveis) {
                if (resultado[0] == opcoes[escolhaJogador-1] && resultado[1] == opcoes[escolhaComputador]) {
                    resultadoFinal = resultado[opcoes.length-1];
                    break;
                }
        
            }
        }
        System.out.println(resultadoFinal);
    }
        
}
