package ArrayList;



public class Nomes {
    public String toTittle(String frase) {
        String[] words = frase.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++){
            sb.append(words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase());
            sb.append(" ");
        }
        return sb.toString();
    }
}