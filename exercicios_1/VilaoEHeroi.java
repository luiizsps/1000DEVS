package exercicios_1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class VilaoEHeroi {
    public static void main(String[] args) {
        int escolhaJogador=-1, escolhaComputador=-1;
        boolean loop;
        String resultadoFinal = "";

        String[][] regras = {
            {"Atacar", "Atacar", "Os dois se ferem!"},
            {"Atacar", "Defender", "O vilão bloqueia seu ataque!"},
            {"Atacar", "Fugir", "Você acerta o vilão pelas costas!"},
            {"Defender", "Atacar", "Você bloqueia o ataque do vilão!"},
            {"Defender", "Defender", "Ambos ficam em posição defensiva... ninguém se fere."},
            {"Defender", "Fugir", "O vilão foge enquanto você se protege."},
            {"Fugir", "Atacar", "Você escapa por pouco do ataque!"},
            {"Fugir", "Defender", "Você foge com sucesso, o vilão nem tenta seguir."},
            {"Fugir", "Fugir", "Ambos fogem... ninguém vence."}
        };
        String[] opcoes = {"Atacar", "Defender", "Fugir"};

        Scanner reader = new Scanner(System.in);
        Random seletor = new Random();

        escolhaComputador = seletor.nextInt(opcoes.length);

        // recebe escolha do usuário
        do {
            loop = false;
            try {
                System.out.print("Escolha:\n[1] Atacar\n[2] Defender\n[3] Fugir\n:");
                escolhaJogador = reader.nextInt();

            } catch(InputMismatchException  e) {
                System.out.println("Entrada inválida.");
                reader.nextLine(); // limpa buffer
                loop = true;
            }
        } while(loop);

        reader.close();

        System.out.printf("Jogador escolheu: %s\nComputador escolheu: %s\n", opcoes[escolhaJogador-1], opcoes[escolhaComputador]);

        for(String[] resultado : regras) {
            if (resultado[0] == opcoes[escolhaJogador-1] && resultado[1] == opcoes[escolhaComputador]) {
                resultadoFinal = resultado[opcoes.length-1];
                break;
            }
        }
        System.out.println(resultadoFinal);
    }
}
