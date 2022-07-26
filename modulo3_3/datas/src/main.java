import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate hj = LocalDate.now();

        System.out.print("Digite a data do seu nascimento: ");
        String data = sc.nextLine();

        LocalDate aniv = convertToLocalDate(data);

        LocalDate localDateAniv = LocalDate.of(hj.getYear(), aniv.getMonthValue(), aniv.getDayOfMonth());
        LocalDate localDateHj = hj;

        if (localDateAniv.isBefore(localDateHj)) {
            Period periodo = Period.between(localDateAniv, localDateHj);
            System.out.println("Faltam\n" +
                    periodo.getYears() + " Anos\n" +
                    periodo.getMonths() + " Meses\n" +
                    periodo.getDays() + " Dias\n" +
                    "para o seu aniversario.");
        } else {
            Period periodo = Period.between(localDateHj, localDateAniv);
            System.out.println("Faltam\n" +
                    periodo.getYears() + " Anos\n" +
                    periodo.getMonths() + " Meses\n" +
                    periodo.getDays() + " Dias\n" +
                    "para o seu aniversario.");
        }
//  ==========================================================================================================
        System.out.print("Digite a primeira data: ");
        String data1 = sc.nextLine();

        System.out.print("Digite a segunda data: ");
        String data2 = sc.nextLine();

        LocalDate data1LocalDate = convertToLocalDate(data1);
        LocalDate data2LocalDate = convertToLocalDate(data2);

        if (data1LocalDate.isBefore(data2LocalDate)) {
            Period periodo = Period.between(localDateAniv, localDateHj);
            System.out.println(periodo.getYears() + " Anos " + periodo.getMonths() + " Meses " + periodo.getDays() + " Dias");
        } else {
            Period periodo = Period.between(localDateHj, localDateAniv);
            System.out.println(periodo.getYears() + " Anos " + periodo.getMonths() + " Meses " + periodo.getDays() + " Dias");
        }
//  ===========================================================================================================
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime futuro = hoje.plusDays(15).plusHours(10);
        System.out.println("Dia da semana: "+futuro.getDayOfWeek()+
                "Dia do ano: "+futuro.getDayOfYear());
//  ===========================================================================================================

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

    public static LocalDate convertToLocalDate(String date) {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateConvert = LocalDate.parse(date, format);
            return dateConvert;
        } catch (Exception p) {
            System.out.println(p.getStackTrace());
        }
        return null;
    }
}
