import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exerc1 {
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
