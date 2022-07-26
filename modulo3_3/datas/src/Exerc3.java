import java.time.LocalDateTime;

public class Exerc3 {
    public static void main(String[] args) {
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime futuro = hoje.plusDays(15).plusHours(10);
        System.out.println("Dia da semana: "+futuro.getDayOfWeek()+
                "Dia do ano: "+futuro.getDayOfYear());
    }
}
