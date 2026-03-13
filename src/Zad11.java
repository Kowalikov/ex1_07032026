import java.util.Scanner;
import java.util.Arrays;


public class Zad11 {
    static boolean sprawdz_pangram(String sentence) {
        boolean[] occur_tab = new boolean[26];
        Arrays.fill(occur_tab, false);

        for (int i = 0; i < 26; i++) {
            char letter = (char) ('a' + i);

            for (int j=0; j<sentence.length(); j++) {
                if (Character.toLowerCase(sentence.charAt(j)) == letter) {
                    occur_tab[i] = true;
                    break;
                }
            }
        }

        boolean palindrome_flag = true;
        for (boolean b: occur_tab) {
            if (!b) {
                palindrome_flag = false;
                break;
            }
        }

        return palindrome_flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence;
        try {
            sentence = sc.nextLine();
        } catch (Exception e) {
            System.out.print("BŁĄD");
            return;
        }

        if (sprawdz_pangram(sentence)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}