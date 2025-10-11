package desafio_1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Forca {
    private int errors = 0;
    private int numLettersFound = 0;
    private int chosenWordLength;
    private String chosenWord = "";
    private ArrayList<Character> typedLetters = new ArrayList<Character>();
    private ArrayList<Character> correctLetters = new ArrayList<Character>();
    private ArrayList<String> initialDrawList = new ArrayList<String>();
    private ArrayList<String> letterDrawList = new ArrayList<String>();
    private boolean gameStatus = true;

    public static void main(String[] args) {
        Forca game = new Forca();
        game.run();

    }
    // run game
    private void run() {
        char letter;

        setWord();

        if(this.chosenWord == "") return;

        setInitialGameStructure();
        drawLetterSpaces();

        System.out.println("\n\nOlá! Seja bem-vindo ao jogo da forca com linguagens de programação.\n");
        
        while (getGameStatus()) {
            System.out.printf("Você tem %d vidas.\n", 5 - this.errors);

            System.out.print("Respostas: ");
            for (char typedLetter : typedLetters) {
                System.out.print(typedLetter+" ");
            }
            System.out.print("\n");

            setGameStructure();

            // print out game structure
            for (String line : this.initialDrawList) {
                System.out.print(line);
            }

            // print out letters and spaces
            for (String line : this.letterDrawList) {
                System.out.print(line);
            }

            // get user answer from keyboard
            letter = getUserAnswer();
            if (letter == '/') {
                clearConsole();
                continue;
            }
            
            this.typedLetters.add(letter);

            // process user answer
            processAnswer(letter);

            // clear console
            clearConsole();
        }

        if (this.errors > 4) {
            System.out.println("Você perdeu. A palavra era: "+this.chosenWord);
        } else if (numLettersFound == getWordLength()) {
            System.out.println("Você venceu! A palavra era: "+this.chosenWord);
        }
    }

    // set game structure
    private void setGameStructure() {
        switch(this.errors) {
            case 0:
                this.initialDrawList.set(0,"|----- \n");
                this.initialDrawList.set(1,"|    | \n");
                this.initialDrawList.set(2,"|      \n");
                this.initialDrawList.set(3,"|      \n");
                this.initialDrawList.set(4,"|      \n");
                this.initialDrawList.set(5,"|      \n");
                this.initialDrawList.set(6,"_      \n");
                break;
            case 1:
                this.initialDrawList.set(2, "|    O \n");
                break;
            case 2:
                this.initialDrawList.set(3, "|   /|\\\\ \n");
                break;
            case 3:
                this.initialDrawList.set(4, "|    | \n");
                break;
            case 4:
                this.initialDrawList.set(5, "|   / \\\\ \n");
                break;
        }
    }

    // set initial game structure
    private void setInitialGameStructure() {
        this.initialDrawList.add("|----- \n");
        this.initialDrawList.add("|    | \n");
        this.initialDrawList.add("|      \n");
        this.initialDrawList.add("|      \n");
        this.initialDrawList.add("|      \n");
        this.initialDrawList.add("|      \n");
        this.initialDrawList.add("_      \n");
    }

    private void drawLetterSpaces() {
        for (int i=0; i<this.chosenWordLength; i++) {
            this.letterDrawList.add("__ ");
        }
        this.letterDrawList.add("\n");
    }

    private char getUserAnswer() {
        Scanner reader = new Scanner(System.in);
        String userInput;
        char letter = '/';

        try {
            System.out.print("\nDigite uma letra: ");
            userInput = reader.nextLine();
            userInput = userInput.toUpperCase();

            if(userInput.length() == 1) {
                letter = userInput.charAt(0);
            }

            //reader.close();
        } catch(InputMismatchException e) {
            System.out.println("Erro. Entrada inválida.");
        } 

        if(this.typedLetters.contains(letter)) {
            System.out.println("Essa letra já foi inserida.");
            letter = '/';
        }

        return letter;
    }

    private void processAnswer(char answer) { // 6 + ltter index
        int numCorrectLetters = 0;
        for(int i=0; i<this.chosenWordLength; i++) {
            if (this.correctLetters.get(i) == answer) {
                this.letterDrawList.set(i, answer+" ");
                numCorrectLetters++;
            }
        }

        this.numLettersFound += numCorrectLetters;

        if (numCorrectLetters == 0) {
            System.out.println("Letra incorreta.");
            this.errors++;
        }

        if (errors > 4 || numLettersFound == getWordLength()) {
            setGameStatus(false);
        }
    }

    // read the txt file containing the available words
    private static ArrayList<String> getAvailableWords() {
        String path = "desafio_1/files/words.txt";
        ArrayList<String> availableWords = new ArrayList<>();

        File file = new File(path);

        try {
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {
                availableWords.add(reader.nextLine());
            }

            reader.close();
        } catch (IOException e) {
            System.out.printf("Erro: %s\n", e.getMessage());
        }

        return availableWords;
    }

    // choose randomly one word to play
    private void setWord() {
        int chosenIndex;
        String selectedWord;
        ArrayList<String> words;

        Random rand = new Random();

        words = getAvailableWords();

        if (words.size() == 0) {
            return;
        }

        chosenIndex = rand.nextInt(words.size());
        selectedWord = words.get(chosenIndex);

        this.chosenWord = selectedWord.toUpperCase();

        for (char letter : chosenWord.toCharArray()) {
            this.correctLetters.add(letter);
        }

        setWordLength();
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }
    }

    private void setWordLength() {
        this.chosenWordLength = this.chosenWord.length();
    }

    private int getWordLength() {
        return this.chosenWordLength;
    }

    private void setGameStatus(boolean status) {
        this.gameStatus = status;
    }

    private boolean getGameStatus() {
        return this.gameStatus;
    }
}