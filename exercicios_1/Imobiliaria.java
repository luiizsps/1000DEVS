package exercicios_1;

import java.util.Scanner;

/*  Exercício 01: Uma imobiliária vende apenas terrenos retangulares. 
Faça um algoritmo para imprimir a área do terreno e o valor de venda
do mesmo. Para isto será necessário o usuário informar as dimensões 
em metros (frente e lateral) do terreno além do valor cobrado pelo metro quadrado. */

public class Imobiliaria {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        double comprimento, largura, precoPorMetroQuadrado, area, precoFinal;

        System.out.print("Comprimento: ");
        comprimento = r.nextDouble();

        r.nextLine();

        System.out.print("Largura: ");
        largura = r.nextDouble();

        r.nextLine();

        System.out.print("Preço por m²: ");
        precoPorMetroQuadrado = r.nextDouble();

        r.close();

        area = largura * comprimento;
        precoFinal = area * precoPorMetroQuadrado;

        // System.out.print("Área do terreno (m²): "+area+"\nValor de venda: R$"+precoFinal+"\n");
        System.out.printf("Área do terreno: %.2f m²\nValor de venda R$ %.2f\n", area, precoFinal);
    }
}
