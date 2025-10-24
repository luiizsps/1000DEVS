package exercicios_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Animal {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> values = new ArrayList<String>();
        String foundAnimal = "";

        // animals
        String[][] animals = {
            {"vertebrado", "ave", "carnivoro", "aguia"},
            {"vertebrado", "ave", "onivoro", "pomba"},
            {"vertebrado", "mamifero", "onivoro", "homem"},
            {"vertebrado", "mamifero", "herbivoro", "vaca"},
            {"invertebrado", "inseto", "hematofago", "pulga"},
            {"invertebrado", "inseto", "herbivoro", "lagarta"},
            {"invertebrado", "anelideo", "hematofago", "sanguessuga"},
            {"invertebrado", "anelideo", "onivoro", "minhoca"}
        };

        // get inputs
        values.add(reader.nextLine());
        values.add(reader.nextLine());
        values.add(reader.nextLine());

        // close reader
        reader.close();

        // find animal
        for(String[] animal : animals) {
            boolean match = true;

            for(int i=0; i<values.size(); i++) {
                if(!(animal[i].equals(values.get(i)))) {
                    match = false;
                    break;
                }
            }
            
            if(match) {
                foundAnimal = animal[values.size()];
                break;
            }
        }

        // print out found animal
        System.out.println(foundAnimal);
    }
}
