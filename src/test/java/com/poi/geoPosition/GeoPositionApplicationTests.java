package com.poi.geoPosition;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@SpringBootTest
class GeoPositionApplicationTests {

	@Test
	void contextLoads() {
		LocalDateTime startDate = LocalDateTime.of(2015, 2, 20, 2,20,10);

		LocalDateTime endDate = LocalDateTime.of(2015, 3, 21, 1,20,10);

		Duration duration = Duration.between(startDate, endDate );


		System.out.println("Duração dias: "+ duration.toDays() + " horas: "+duration.toHours() +
				           " minutos: "+duration.toMinutes() + " segundos: "+duration.getSeconds());
	}

}
