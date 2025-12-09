package vetores;
import time_format.KeyboardReader;
import java.util.InputMismatchException;

public class WordsVector {
    public static void main(String[] args) {
        boolean keepLoop = true;
        String words[] = new String[5];
        String input;
        int biggestWordLength=0;
        int i = 0;

        do {
            try {
                System.out.print("Input any word: ");
                input = KeyboardReader.readLine();

                words[i] = input;

                if (biggestWordLength <= input.length()) {
                    biggestWordLength = input.length();
                }

                i++;
                if(i >= (words.length)) keepLoop = false;
                
            } catch(InputMismatchException e) {
                System.out.println("Invalid input.");
                KeyboardReader.readLine();
            }
        } while (keepLoop);

        char wordsAligned[][] = new char[words.length][biggestWordLength];

        // fill words vector with blank spaces
        for (i=0; i < words.length; i++) {
            for (int j = 0; j < biggestWordLength; j++) {
                wordsAligned[i][j] = ' ';
            }
        }

        // replace the blank spaces for the letters in the correct positions
        for (i=0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                wordsAligned[i][(biggestWordLength - word.length) + j] = word[j];
            }
        }

        // print out
        for (i = 0; i < words.length; i++) {
            for (int j = 0; j < biggestWordLength; j++) {
                System.out.print(wordsAligned[i][j]);
            }
            System.out.println();
        }
    }
}
