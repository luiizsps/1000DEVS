package time_format;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import time_format.KeyboardReader;

@SuppressWarnings("unused")
public class Age {
	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String birthDateString = "";
		LocalDate birthDate = null;
		LocalDate nextBirthday = null;

		try {
			System.out.print("Informe sua data de nascimento: ");
			birthDateString = KeyboardReader.readLine();
			birthDate = LocalDate.parse(birthDateString, dateFormatter);

		} catch (DateTimeParseException e) {
			System.out.println("Erro ao converter data: " + e.getMessage());
		}

		Period period = Period.between(birthDate, currentDate);
		
		System.out.printf("O usuário tem %d anos %d meses e %d dias.\n", period.getYears(), period.getMonths(), period.getDays());

		LocalDate birthdayCurrentYear =  LocalDate.of(currentDate.getYear(), birthDate.getMonthValue(), birthDate.getDayOfMonth());
		
		if(currentDate.isAfter(birthdayCurrentYear)) {
			nextBirthday = birthdayCurrentYear.plusYears(1);
		} else {
			nextBirthday = birthdayCurrentYear;
		}

		long daysToNextBirthday = ChronoUnit.DAYS.between(currentDate, nextBirthday);
		System.out.printf("O seu próximo aniversário é "+ nextBirthday.format(dateFormatter)+". Faltam %d dias.\n", daysToNextBirthday);
	}
}