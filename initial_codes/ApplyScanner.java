package initial_codes;
import java.util.Scanner;


public class ApplyScanner {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);

        String name = r.nextLine();
        String last_name = r.nextLine();

        r.close();

        System.out.printf("User name:"+name+"\nUser last name: "+last_name+"\n");
    }
}
