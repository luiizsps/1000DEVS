package exercicios_1;

import java.util.Scanner;

/* Exercício 05: A granja Frangotech possui um controle automatizado 
de cada frango da sua produção. No pé direito do frango há um anel 
com um chip de identificação; no pé esquerdo são dois anéis para 
indicar o tipo de alimento que ele deve consumir. Sabendo que o anel 
com chip custa R$4,00 e o anel de alimento custa R$3,50, faça um algoritmo 
para calcular o gasto total da granja para marcar todos os seus frangos que 
deverá ser informado pelo usuário. */

//@SuppressWarnings("unused")
public class Granja {
    public static void main(String[] args) {
        int qtdGalinhas;
        double precoAnelAlimento = 3.50; // 2 aneis alimento
        double precoAnelChip = 4.00;    // 1 anel chip
        double custoPorGalinha, custoTotal;

        Scanner r = new Scanner(System.in);

        System.out.print("Informe a quantidade de galinhas: ");
        qtdGalinhas = r.nextInt();
        
        r.close();

        custoPorGalinha = precoAnelAlimento*2 + precoAnelChip;

        custoTotal = custoPorGalinha*qtdGalinhas;

        System.out.printf("Preço total: %.2f\n", custoTotal);
    }
}