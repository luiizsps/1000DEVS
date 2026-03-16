import java.util.ArrayList;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int NC = reader.nextInt();

        for (int i = 0; i < NC; i++) {
            int soldiersNumber = reader.nextInt();
            int jumpLength = reader.nextInt();

            ArrayList<Integer> soldiers = new ArrayList<>();
            for (int j = 0; j < soldiersNumber; j++) {
                soldiers.add(j + 1);
            }

            int j = (jumpLength - 1) % soldiers.size();

            while (soldiers.size() > 1) {
                soldiers.remove(j);
                j = (j + jumpLength - 1) % soldiers.size();
            }

            System.out.printf("Case %d: %d\n", i + 1, soldiers.get(0));
        }
        reader.close();
    }
}