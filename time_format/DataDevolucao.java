package time_format;

import time_format.KeyboardReader;
import java.util.InputMismatchException;
// import java.time.LocalDate; LocalDate.now() returns the current date
// import java.time.LocalTime; LocalTime.now() returns the current time
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("unused")
public class DataDevolucao {
    public static void main(String[] args) {
        boolean validInput = false;
        int loanDays = 0;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while(!validInput) {
            try {
                System.out.print("Informe a quantidade de dias de empréstimo: ");
                loanDays = KeyboardReader.readInt();
                validInput = true;
            } catch(InputMismatchException e)  {
                System.out.println("Inválido. Digite apenas números.");
                KeyboardReader.readLine();
            }
        }

        date = date.plusDays(loanDays);

        String formatedDate = date.format(dateTimeFormatter);

        System.out.println("Data de devolução: " + formatedDate);
    }
}

