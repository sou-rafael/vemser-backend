import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        LocalDate hj = LocalDate.now();
//
//        System.out.print("Digite a data do seu nascimento: ");
//        String data = sc.nextLine();
//
//        LocalDate aniv = convertToLocalDate(data);
//        // caso a data seja digitada errada  ele retorna null - usar isso num while
//
//        LocalDate localDateAniv = LocalDate.of(hj.getYear(), aniv.getMonthValue(), aniv.getDayOfMonth());
//        LocalDate localDateHj = hj;
//
//        if (localDateAniv.isBefore(localDateHj)) {
//            Period periodo = Period.between(localDateAniv, localDateHj);
//            System.out.println("Faltam\n" +
//                    periodo.getYears() + " Anos\n" +
//                    periodo.getMonths() + " Meses\n" +
//                    periodo.getDays() + " Dias\n" +
//                    "para o seu aniversario.");
//        } else {
//            Period periodo = Period.between(localDateHj, localDateAniv);
//            System.out.println("Faltam\n" +
//                    periodo.getYears() + " Anos\n" +
//                    periodo.getMonths() + " Meses\n" +
//                    periodo.getDays() + " Dias\n" +
//                    "para o seu aniversario.");
//        }
////  ==========================================================================================================
//        System.out.print("Digite a primeira data: ");
//        String data1 = sc.nextLine();
//
//        System.out.print("Digite a segunda data: ");
//        String data2 = sc.nextLine();
//
//        LocalDate data1LocalDate = convertToLocalDate(data1);
//        LocalDate data2LocalDate = convertToLocalDate(data2);
//
//        if (data1LocalDate.isBefore(data2LocalDate)) {
//            Period periodo = Period.between(localDateAniv, localDateHj);
//            System.out.println(periodo.getYears() + " Anos " + periodo.getMonths() + " Meses " + periodo.getDays() + " Dias");
//        } else {
//            Period periodo = Period.between(localDateHj, localDateAniv);
//            System.out.println(periodo.getYears() + " Anos " + periodo.getMonths() + " Meses " + periodo.getDays() + " Dias");
//        }
////  ===========================================================================================================
//        LocalDateTime hoje = LocalDateTime.now();
//        LocalDateTime futuro = hoje.plusDays(15).plusHours(10);
//        System.out.println("Dia da semana: "+futuro.getDayOfWeek()+
//                "Dia do ano: "+futuro.getDayOfYear());
////  ===========================================================================================================

        ZoneId fusoHorarioDeLondres = ZoneId.of("Europe/London");
        LocalDateTime dataDoEventoEmLondres = LocalDateTime.of(2024,9,14,18,30);

        LocalDateTime now = LocalDateTime.now();

        long nowMili = now.atZone(ZoneId.systemDefault())
                .toInstant() // Instant object
                .toEpochMilli(); // milisegundos ja no fuso de londres
        long dataDoEventoMili = dataDoEventoEmLondres.atZone(fusoHorarioDeLondres)
                .toInstant() // Instant object
                .toEpochMilli(); // milisegundos ja no fuso de londres

        long diferenca = dataDoEventoMili - nowMili;
        Instant instant = Instant.ofEpochMilli(diferenca);
        LocalDateTime diff = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(diff.getYear() + " Anos "+
                        diff.getMonthValue() + " Meses "+
                        diff.getDayOfMonth() + " Dias "+
                diff.getHour()+ " Horas "+
                diff.getMinute()+ "Minutos "+
                diff.getSecond()+ "Segundos");

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

//    public static LocalDateTime convertToLocalDateTimeViaMilisecond(long dateToConvert) {
//        LocalDateTime.
//        return Instant.ofEpochMilli(dateToConvert).to;
//    }
}
//        long anos = ChronoUnit.YEARS.between(nowInLondres,dataDoEventoEmLondres);
//        long meses = ChronoUnit.MONTHS.between(dataDoEventoEmLondres,nowInLondres);
//        long dias = ChronoUnit.DAYS.between(dataDoEventoEmLondres,nowInLondres);
//        long horas = ChronoUnit.HOURS.between(dataDoEventoEmLondres,nowInLondres);
//        long minutos = ChronoUnit.MINUTES.between(dataDoEventoEmLondres,nowInLondres);
//        long segundos = ChronoUnit.SECONDS.between(dataDoEventoEmLondres,nowInLondres);
