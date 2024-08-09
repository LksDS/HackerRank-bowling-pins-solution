import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String isWinning(int n, String config) {

        if (!config.contains("I")) {
            return "LOSE";
        }

        for (int i = 0; i < n; i++) {
            if (config.charAt(i) == 'I') {

                String newConfig = config.substring(0, i) + 'X' + config.substring(i + 1);
                if (isWinning(n, newConfig).equals("LOSE")) {
                    return "WIN";
                }

                if (i + 1 < n && config.charAt(i + 1) == 'I') {
                    newConfig = config.substring(0, i) + "XX" + config.substring(i + 2);
                    if (isWinning(n, newConfig).equals("LOSE")) {
                        return "WIN";
                    }
                }
            }
        }

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
