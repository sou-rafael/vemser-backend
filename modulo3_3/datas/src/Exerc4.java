import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.lang.Math.abs;

public class Exerc4 {
    public static void main(String[] args) {
        ZoneId fusoHorarioDeLondres = ZoneId.of("Europe/London");
        LocalDateTime dataDoEventoEmLondres = LocalDateTime.of(2024, 9, 14, 18, 30);

        LocalDateTime nowInLondon = LocalDateTime.now(fusoHorarioDeLondres);

        int anos = dataDoEventoEmLondres.getYear() - nowInLondon.getYear();
        int meses = abs(dataDoEventoEmLondres.getMonthValue() - nowInLondon.getMonthValue());
        int dias = abs(dataDoEventoEmLondres.getDayOfMonth() - nowInLondon.getDayOfMonth());
        int horas = abs(dataDoEventoEmLondres.getHour() - nowInLondon.getHour());
        int minutos = abs(dataDoEventoEmLondres.getMinute() - nowInLondon.getMinute());
        int segundos = abs(dataDoEventoEmLondres.getSecond() - nowInLondon.getSecond());

        System.out.println(anos + " Anos " +
                meses + " Meses " +
                dias + " Dias " +
                horas + " Horas " +
                minutos + " Minutos " +
                segundos + " Segundos");
    }
}
