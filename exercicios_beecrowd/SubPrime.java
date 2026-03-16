import java.util.Scanner;

public class SubPrime {
    public static void main(String[] args) {
        int banksNumber, transactionsNumber, debtorBank, creditorBank, value;
        int[] banksReserves;

        Scanner reader = new Scanner(System.in);

        while(true) {

            banksNumber = reader.nextInt();
            transactionsNumber = reader.nextInt();

            if (banksNumber == 0 && transactionsNumber == 0) break;

            banksReserves = new int[banksNumber];

            for (int i = 0; i<banksNumber; i++) {
                banksReserves[i] = reader.nextInt();
            }

            for(int i=0; i<transactionsNumber; i++) {
                debtorBank = reader.nextInt();
                creditorBank = reader.nextInt();
                value = reader.nextInt();

                banksReserves[debtorBank - 1] -= value;
                banksReserves[creditorBank - 1] += value;
            }

            System.out.println(checkBrokenBank(banksReserves));
        }

        reader.close();
    }

    private static char checkBrokenBank(int[] banksReserves) {
        for (int reserve : banksReserves) {
            if(reserve < 0) {
                return 'N';
            }
        }

        return 'S';
    }
}
