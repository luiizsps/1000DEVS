package exercicios_1;

import java.util.Scanner;

/* Exercício 04: Faça um algoritmo para ler o salário de um funcionário e 
aumentá-lo em 15%. Após o aumento, desconte 11% de INSS e 8% de FGTS. 
Imprima o salário inicial, o salário com o aumento, o salário final, 
o desconto do INSS, o desconto do FGTS e o Total de Descontos (INSS+FGTS). */

public class Aumento {
    public static void main(String[] args) {
        double salario, descontoINSS, descontoFGTS, salarioComAumento, salarioFinal, totalDescontos;
        float aumentoPorcentagem = 1.15f;
        float descontoINSSPorcentagem = 0.11f;
        float descontoFGTSPorcentagem = 0.08f;

        Scanner r = new Scanner(System.in);

        System.out.print("Informe seu salário: ");
        salario = r.nextDouble();

        r.close();

        salarioComAumento = salario * aumentoPorcentagem;

        descontoFGTS = salarioComAumento * descontoFGTSPorcentagem;
        descontoINSS = salarioComAumento * descontoINSSPorcentagem;
        totalDescontos = descontoFGTS + descontoINSS;

        salarioFinal = salarioComAumento - totalDescontos;

        System.out.printf("Salário incial: %.2f\nSalário após aumento: %.2f\nSalário final: %.2f\nDesconto INSS: %.2f\nDesconto FGTS: %.2f\nTotal descontos: %.2f\n", salario, salarioComAumento, salarioFinal, descontoINSS, descontoFGTS, totalDescontos);

    }
}
