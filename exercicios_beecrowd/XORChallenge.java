import java.util.Scanner;

public class XORChallenge {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextLong()) {
            long a = reader.nextLong();
            long b = reader.nextLong();
            System.out.println(a ^ b); // exact, no floating point involved
        }
        reader.close();
    }
}