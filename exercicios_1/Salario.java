package exercicios_1;

import java.util.Scanner;

/*Exercício 02: Faça um algoritmo que receba o valor do salário 
mínimo e o valor do salário de um funcionário, calcule e mostre 
a quantidade de salários mínimos que ganha esse funcionário.*/
public class Salario {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);

        double salarioMinimo, salarioUsuario, qtdSalariosMinimos;

        System.out.print("Salário mínimo: ");
        salarioMinimo = r.nextDouble();

        System.out.print("Seu salário: ");
        salarioUsuario = r.nextDouble();

        r.close();

        // calc quantidade de salários mínimos
        qtdSalariosMinimos = salarioUsuario / salarioMinimo;

        System.out.printf("Quantidade de salários mínimos: %.2f\n", qtdSalariosMinimos);
    }
}

