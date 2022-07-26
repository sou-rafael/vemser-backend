import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exerc2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a primeira data: ");
        String data1 = sc.nextLine();

        System.out.print("Digite a segunda data: ");
        String data2 = sc.nextLine();

        LocalDate data1LocalDate = convertToLocalDate(data1);
        LocalDate data2LocalDate = convertToLocalDate(data2);

        if (data1LocalDate.isBefore(data2LocalDate)) {
            Period periodo = Period.between(data1LocalDate, data2LocalDate);
            System.out.println(periodo.getYears() + " Anos " + periodo.getMonths() + " Meses " + periodo.getDays() + " Dias");
        } else {
            Period periodo = Period.between(data2LocalDate, data1LocalDate);
            System.out.println(periodo.getYears() + " Anos " + periodo.getMonths() + " Meses " + periodo.getDays() + " Dias");
        }
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
