package time_format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class DifDate {
    public static void main(String[] args) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime firstDate = LocalDateTime.parse("01/01/2024 08:00:00", dateFormatter);
        LocalDateTime secondDate = LocalDateTime.parse("10/02/2025 10:00:00", dateFormatter);
        LocalDateTime currentDate = LocalDateTime.now();

        Duration timeBetween = Duration.between(firstDate, secondDate);
        Duration timeBetwennSecondDate = Duration.between(secondDate, currentDate);
        Duration timeBetwennFirstDate = Duration.between(firstDate, currentDate);

        long seconds = timeBetween.getSeconds();
        double minutes = seconds / 60;
        double hours = minutes / 60;
        double days = hours / 24;

        long secondSecondDateGap = timeBetwennSecondDate.getSeconds();
        long firstDateGap = timeBetwennFirstDate.getSeconds();

        System.out.printf("Dias: %.0f\nHoras: %.0f\nMinutos: %.0f\nSegundos: %d\n", days, hours, minutes, seconds);

        if (secondSecondDateGap > firstDateGap) {
            System.out.println("A primeira data é a mais recente.");
        } else {
            System.out.println("A segunda data é a mais recente");
        }
    }
}
