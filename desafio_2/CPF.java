package desafio_2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CPF {
    private String CPF;
    public static void main(String[] args) {
        CPF c = new CPF();

        c.readCPF();
        if(c.verifyCPF(c.getCPF())) {
            System.out.println("CPF válido");
        } else {
            System.out.println("CPF inválido");
        }
    }

    private boolean verifyCPF(String CPF) {
        ArrayList<Integer> CPFNumbers = new ArrayList<Integer>();
        ArrayList<Character> CPFElements = new ArrayList<Character>();

        // remove special characters
        CPF = CPF.replace(" ", ""); // remove blank spaces
        CPF = CPF.replace("-", ""); // remove hyphen
        CPF = CPF.replace(".", ""); // remove dots

        for(char element : CPF.toCharArray()) {
            if (!CPFElements.contains(element)) {
                CPFElements.add(element);
            }
            
            CPFNumbers.add(Character.getNumericValue(element));
        }

        // verify if the CPF has 11 numbers
        if(CPFNumbers.size() != 11) return false;
        // verify if the CPF is not just 1 number repeated 11 times
        if(CPFElements.size() == 1) return false;

        return verifytDigits(CPFNumbers);
    }

    public void readCPF() {
        Scanner reader = new Scanner(System.in);
        try {
            System.out.print("INFORME O CPF: ");
            setCPF(reader.nextLine());
        } catch(InputMismatchException e) {
            System.out.print("CPF inválido");
        } finally {
            reader.close();
        }
    }

    public boolean verifytDigits(ArrayList<Integer> CPFNumbers) {
        int rest, sumMultipliedNumbers = 0;

        // verify first digit
        int j = 0;
        for(int i=10; i >= 2; i--) {
            sumMultipliedNumbers += (CPFNumbers.get(j) * i);
            j++;
        }
        
        rest = sumMultipliedNumbers % 11;

        if (rest < 2) {
            if(CPFNumbers.get(j) != 0) return false;
  
        } else {
            if(CPFNumbers.get(j) != (11 - rest)) return false;
        }


        // verify second digit
        j = 0;
        sumMultipliedNumbers = 0;
        for(int i=11; i >= 2; i--) {
            sumMultipliedNumbers += (CPFNumbers.get(j) * i);
            j++;
        }
        
        rest = sumMultipliedNumbers % 11;

        if (rest < 2) {
            if(CPFNumbers.get(j) != 0) return false;
  
        } else {
            if(CPFNumbers.get(j) != (11 - rest)) return false;
        }

        return true;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCPF() {
        return this.CPF;
    }
}
