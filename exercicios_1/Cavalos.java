package exercicios_1;

import java.util.Scanner;

/* Exercício 03: Faça um algoritmo para calcular quantas ferraduras são necessárias
para equipar todos os cavalos comprados para um haras. O usuário devera informar a 
quantidade de cavalos adquiridos. */

public class Cavalos {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);

        double custoFerradura, custoTotal;
        int qtdCavalos, qtdFerraduras;

        System.out.print("Informe a quantidade de cavalos: ");
        qtdCavalos = r.nextInt();

        System.out.print("Informe o custo por ferradura: ");
        custoFerradura = r.nextDouble();

        r.close();

        qtdFerraduras = qtdCavalos * 4;
        custoTotal = qtdFerraduras * custoFerradura;

        System.out.printf("Quantidade de ferraduras: %d\nCusto total: %.2f\n", qtdFerraduras, custoTotal);
    }
}