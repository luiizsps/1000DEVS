package time_format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class DifDate {
    public static void main(String[] args) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime firstDate = LocalDateTime.parse("01/01/2024 08:00:00", dateFormatter);
        LocalDateTime secondDate = LocalDateTime.parse("10/02/2025 10:00:00", dateFormatter);

        Duration timeBetween = Duration.between(firstDate, secondDate);

        long seconds = timeBetween.getSeconds();
        double minutes = seconds / 60;
        double hours = minutes / 60;
        double days = hours / 24;

        System.out.printf("Dias: %.0f\nHoras: %.0f\nMinutos: %.0f\nSegundos: %d\n", days, hours, minutes, seconds);
    }
}
