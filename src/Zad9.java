public class Zad9 {
    static boolean sprawdz_palindrom_v0(String slowo) {
        boolean palindrome_flag = true;

        int comp_lenght = (slowo.length() - slowo.length()%2)/2;
        String part_1 = slowo.substring(0, comp_lenght);
        String part_2 = slowo.substring(slowo.length()-comp_lenght);

        for (int i=0; i<comp_lenght; i++) {
            if (part_1.charAt(i)!=part_2.charAt(comp_lenght-1-i)) {
                palindrome_flag = false;
                break;
            }
        }

        return palindrome_flag;
    }

    static boolean sprawdz_palindrom() {
        boolean palindrome_flag = true;

        int length;
        int i=0;
        while ((int) n[i]!=0) {
            i++;
            if (i>=limit) {
                break;
            }
        }
        length = i-1;


        int comp_length = (length - length%2)/2;
        for (i=0; i<comp_length; i++) {
        // Zakładamy, że wszystkie znaki są z małej litery (nie rozpatrujemy przypadku, że występują duże litery)
            if (Character.toLowerCase(n[i]) != Character.toLowerCase(n[length-1-i])) {
                palindrome_flag = false;
                break;
            }
        }

        return palindrome_flag;
    }

    static int limit=100;
    static char n[] = new char[limit];
    public static void main(String[] args) {

        int i=0;
        try {
            int c;
            // do until we reach hard-coded limit or it reads the EOF sing
            while (i < limit && (c = System.in.read()) != -1) {
                if (c!=13) {
                    n[i] = (char) c;
                    i+=1;
                }
            }
            // if last element is new_line -> remove it
            if ((int) n[i-1]==10) {
                n[i]=(char) 0;
            }
        }
        catch (Exception e) {
            return;
        }

        if (sprawdz_palindrom()) {
            System.out.print("TAK");
        } else {
            System.out.print("NIE");
        }
    }
}