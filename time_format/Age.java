import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Age {
	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String birthDateString = "10/06/2002";
		LocalDate nextBirthday = null;

		LocalDate birthDate = LocalDate.parse(birthDateString, dateFormatter);
		Period period = Period.between(birthDate, currentDate);
		
		System.out.printf("O usuário tem %d anos %d meses e %d dias.", period.getYears(), period.getMonths(), period.getDays());

		LocalDate birthdayCurrentYear =  LocalDate.of(currentDate.getYear(), birthDate.getDayOfMonth(), birthDate.getMonthValue());
		
		if(currentDate.isAfter(birthdayCurrentYear)) {
			nextBirthday = birthdayCurrentYear.plusYears(1);
		} else {
			nextBirthday = birthdayCurrentYear;
		}
		System.out.printf("O seu próximo aniversário é "+ nextBirthday.format(dateFormatter));
	}
}
