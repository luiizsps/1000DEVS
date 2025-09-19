package exercicios_1;

import java.util.Scanner;

/* Exercício 06: A lanchonete Gostosura vende apenas um tipo de sanduíche, 
cujo recheio inclui duas fatias de queijo, uma fatia de presunto e uma rodela 
de hambúrguer. Sabendo que cada fatia de queijo ou presunto pesa 50 gramas, e 
que a rodela de hambúrguer pesa 120 gramas, faça um algoritmo em que o dono forneça 
a quantidade de sanduíches a fazer, e a máquina informe as quantidades (em quilos) 
de queijo, presunto e carne necessários para compra. */

public class Lanchonete {
    public static void main(String[] args) {
        double pesoQueijo = 0.05;
        double pesoPresunto = 0.05;
        double pesoHamburguer = 0.12;
        double pesoTotalQueijo, pesoTotalPresunto, pesoTotalHamburguer;
        int qtdSanduiches;

        Scanner r = new Scanner(System.in);

        System.out.print("Quantidade de sanduíches: ");
        qtdSanduiches = r.nextInt();

        r.close();

        pesoTotalQueijo = pesoQueijo * 2 * qtdSanduiches;
        pesoTotalPresunto = pesoPresunto * qtdSanduiches;
        pesoTotalHamburguer = pesoHamburguer * qtdSanduiches;

        System.out.printf("Peso total queijo: %.2f kg\nPeso total presunto: %.2f kg\nPeso total hamburguer: %.2f kg\n", pesoTotalQueijo, pesoTotalPresunto, pesoTotalHamburguer);
    }
}