package exercicios_beecrowd;

import java.io.IOException;
import java.util.Scanner;
 
public class calcGrade {
 
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        double firstGrade, secondGrade, finalGrade;
        float firstGradeWeight = 3.5f;
        float secondGradeWeight = 7.5f;
        
        firstGrade = reader.nextDouble();
        secondGrade = reader.nextDouble();

        reader.close();
        
        finalGrade = (firstGradeWeight*firstGrade + secondGradeWeight*secondGrade) / (firstGradeWeight + secondGradeWeight);
    
        System.out.printf("MEDIA = %.5f\n", finalGrade);
    }
 
}