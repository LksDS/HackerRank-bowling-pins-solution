import java.util.Arrays;
import java.util.Scanner;

public class Main {
public static String isWinning(int n, String config) {

    // Se não houver nenhum pino em pé o jogo está perdido
    if (!config.contains("I")) {
        return "LOSE";
    }

    // Percorre cada posição na string para encontrar todas as jogadas possíveis
    for (int i = 0; i < n; i++) {
        if (config.charAt(i) == 'I') {

            // Tentativa de jogada 1: Tentar remover um único pino na posição i
            String newConfig = config.substring(0, i) + 'X' + config.substring(i + 1);
            // Verifica se o oponente perde ao receber essa nova configuração
            if (isWinning(n, newConfig).equals("LOSE")) {
                // Se o oponente perde nessa nova configuração, você ganha
                return "WIN";
            }

            // Tentativa de jogada 2 : Remover dois pinos adjacentes
            if (i + 1 < n && config.charAt(i + 1) == 'I') {
                newConfig = config.substring(0, i) + "XX" + config.substring(i + 2);
                // Verifica se o oponente perde ao receber essa nova configuração
                if (isWinning(n, newConfig).equals("LOSE")) {
                    // Se o oponente perde nessa nova configuração, você ganha
                    return "WIN";
                }
            }
        }
    }

    // Se nenhuma das jogadas possíveis leva a uma derrota do oponente,
    // significa que qualquer jogada que você faça permitirá que ele ganhe
    return "LOSE";
}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pinAmount = scan.nextInt();
        scan.nextLine();
        String config = scan.nextLine();
        System.out.println(isWinning(pinAmount,config));
    }
}
