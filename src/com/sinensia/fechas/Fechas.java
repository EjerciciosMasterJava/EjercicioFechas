package com.sinensia.fechas;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Fechas {

	public static void main(String[] args) {
		// 1 Presentar fecha y hora actual
		LocalDateTime fechaActual = LocalDateTime.now();
		System.out.println("1 - Fecha actual = " + fechaActual);

		// 2 Presentar fecha y hora en Europa/Madrid
		ZonedDateTime fechaEnMadrid = fechaActual.atZone(ZoneId.of("Europe/Madrid"));
		System.out.println("2 - " + fechaEnMadrid);

		// 3 Presentar fecha del 10/12/2022 con este formato
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate fecha1022 = LocalDate.of(2022, 12, 10);
		System.out.println("3 - Fecha formateada" + dft.format(fecha1022));

		// 4 Indicar a que mes corresponde el 7/12/2020, en numero y el nombre
		LocalDate cuatro = LocalDate.of(2020, 12, 7);
		System.out.println("4 - numero mes " + cuatro.getMonthValue() + " nombre mes: " + cuatro.getMonth().name());

		// 5 Comprobar si el año 2022 es bisiesto
		Year anho2022 = Year.of(2022);
		System.out.println("5 - Es bisiesto el 2022 = " + anho2022.isLeap());

		// 6 Comprobar si puedo poner el dia 29 a 2/2020
		try {
			LocalDate seis = LocalDate.of(2022, 2, 29);
			System.out.println("6 - " + seis);
		} catch (Exception e) {
			System.out.println("6 - No se puede establecer el dia 29 en febrero del 22.");
		}

		// 7 Ver que fecha es 30 días después del 20/2/2010
		LocalDate siete = LocalDate.of(2010, 2, 20).plusDays(30);
		System.out.println("7 - " + siete);

		// 8 Ver que fecha es 1 mes después del 15/12/2009
		LocalDate ocho = LocalDate.of(2009, 12, 15).plusMonths(1);
		System.out.println("8 - " + ocho);

		LocalDateTime fecha1 = LocalDate.of(2001, 10, 7).atStartOfDay();
		LocalDateTime fecha2 = LocalDate.of(2004, 5, 10).atStartOfDay();
		
		// 9 Calcular cuantos días han pasado entre el 7/10/2001 y el 10/5/2004
		System.out.println("9 - Dias transcurridos = " + Duration.between(fecha1, fecha2).toDays());

		// 10 Calcular cuantos meses han pasado entre el 7/10/2001 y el 10/5/2004
		System.out.println("10 - meses = " + ChronoUnit.MONTHS.between(fecha1, fecha2));
		
		// 11 Calcular cuantos años han pasado entre el 7/10/2001 y el 10/5/2004
		System.out.println("11 - Anhos = " + ChronoUnit.YEARS.between(fecha1, fecha2));
		
		//12 Calcular cuantas horas han pasado entre el 7/10/2001 y el 10/5/2004
		System.out.println("12 - horas = " + ChronoUnit.HOURS.between(fecha1, fecha2));
		
		//13 Calcular el periodo que existe entre 3/2/2020 y el 5/7/2021
		Period periodo = Period.between(LocalDate.of(2020, 3, 2), LocalDate.of(2021, 5, 7));
		LocalDate nuevaFecha = LocalDate.of(periodo.getYears(), periodo.getMonths(), periodo.getDays());
		System.out.println("13 - periodo = " + nuevaFecha);
		
		// 14 Ver que fecha sale si sumamos el periodo anterior a la fecha 12/11/2022
		System.out.println("14 - " + 
		LocalDate.of(2022, 11, 12)
			.plusYears(nuevaFecha.getYear())
			.plusMonths(nuevaFecha.getMonthValue())
			.plusDays(nuevaFecha.getDayOfWeek()
					.getValue()));
		
		// 15 Ver que día de la semana era el 22/4/2022
		System.out.println("15 - " + LocalDate.of(2022, 4, 22).getDayOfWeek().name());

		// 16 Ver que día de la semana era hace tres días
		System.out.println("16 - " + LocalDate.now().minusDays(3).getDayOfWeek().name());
		
		// 17 Indicar el nombre en castellano del mes actual
		System.out.println("17 - " + LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase());
		
		// 18 Ver que día de la semana era el primer día del mes de octubre de 1940
		System.out.println("18 - " + LocalDate.of(1940, 10, 1).getDayOfWeek().name());
		
		// 19 Presentar la fecha correspondiente al día 253 del año 1989
		System.out.println("19 - " + LocalDate.ofYearDay(1989, 253));
		
		// 20 Cuantos segundos han pasado desde las 10:15 hasta las 12:30
		System.out.println("20 - " + ChronoUnit.SECONDS.between(LocalTime.of(10, 15), LocalTime.of(12, 30)) + " segundos.");
	}
}
