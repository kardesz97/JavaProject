package hu.ak_akademia.datetimeapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeApiDemo {

	public static void main(String[] args) {
		// LocalDate - csak dátumot reprezentál
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate yesterday = today.minusDays(1);
		System.out.println(yesterday);
		LocalDate current = today;
		for (int i = 0; i < 30; i++) {
			current = current.plusDays(1);
			System.out.println(current);
		}
		LocalDate specialDay = LocalDate.of(2020, 2, 29);
		System.out.println(specialDay);
		System.out.println(specialDay.minusYears(1));
		specialDay = today.withYear(2000);
		System.out.println(specialDay);

		// dátum -> String konverzió
		String formattedDate = today.format(DateTimeFormatter.ofPattern("YYYY. MM. dd."));
		System.out.println(formattedDate);

		// String -> dátum konverzió
		String myBirthday = "11/06/1984";
		LocalDate myRealBirthday = LocalDate.parse(myBirthday, DateTimeFormatter.ofPattern("MM/dd/uuuu"));
		System.out.println(myRealBirthday);
		// szökőév van-e idén
		System.out.println(LocalDate.now()
				.isLeapYear());

		// LocalTime - csak időt reprezentál
		LocalTime thisMoment = LocalTime.now();
		System.out.println(thisMoment);
		LocalTime fourOclock = LocalTime.of(16, 0, 0);
		System.out.println(fourOclock);

		// idő -> String konverzió
		String myFormattedTime = thisMoment.format(DateTimeFormatter.ofPattern("HH : mm : ss . SSSS"));
		System.out.println(myFormattedTime);

		// String -> idő konverzió
		String teaTime = "151914";
		LocalTime parsedTime = LocalTime.parse(teaTime, DateTimeFormatter.ofPattern("HHmmss"));
		System.out.println(parsedTime);

		// LocalDateTime
		LocalDateTime todayAtThisVeryMoment = LocalDateTime.now();
		System.out.println(todayAtThisVeryMoment);

		// dátum-idő -> String konverzió
		String myFormattedDateTime = todayAtThisVeryMoment.format(DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm:ss"));
		System.out.println(myFormattedDateTime);

		// String --> dátum-idő konverzió
		String inputText = "20191224_035901";
		LocalDateTime myParsedDateTime = LocalDateTime.parse(inputText, DateTimeFormatter.ofPattern("uuuuMMdd_HHmmss"));
		System.out.println(myParsedDateTime);

		// időzónák kezelése
		ZonedDateTime hereTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(ZoneId.SHORT_IDS.get("ECT")));
		ZonedDateTime thereTime = hereTime.withZoneSameInstant(ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
		System.out.println(hereTime);
		System.out.println(thereTime);

		// Period
		LocalDate firstDate = LocalDate.of(2020, 2, 5);
		LocalDate secondDate = LocalDate.of(2020, 3, 22);
		Period between = Period.between(firstDate, secondDate);
		System.out.println(between);

		// Duration
		LocalTime firstTime = LocalTime.of(16, 4, 17);
		LocalTime secondTime = LocalTime.of(19, 20, 4);
		Duration duration = Duration.between(firstTime, secondTime);
		System.out.println(duration);

		// Instant
//		Instant startTime = Instant.now();
//		for (int i = 0; i < 300_000; i++) {
//			System.out.println(i);
//		}
//		Instant endTime = Instant.now();
//		System.out.println(Duration.between(startTime, endTime));
	}

}
