import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String isWinning(int n, String config) {
        // Return WIN or LOSE depending on whether you will win
        if (config.indexOf('I') == -1){
            return "LOSE";
        }
        if (config.indexOf('I') == config.lastIndexOf('I')){
            return "WIN";
        }
        if (config.indexOf('I')+1 < config.length() && config.charAt(config.indexOf('I')+1) == 'I'){
            String sequencia = config.replaceFirst("II","XX");
            return isWinning(sequencia.length(),sequencia).equals("WIN") ? "LOSE":"WIN";
        }else{
            String sequencia = config.replaceFirst("I","X");
            return isWinning(sequencia.length(),sequencia).equals("WIN")? "LOSE":"WIN";
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pinAmount = scan.nextInt();
        scan.nextLine();
        String config = scan.nextLine();
        System.out.println(isWinning(pinAmount,config));
    }
}