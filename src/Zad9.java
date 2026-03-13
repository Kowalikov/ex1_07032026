public class Zad9 {
    static boolean sprawdz_palindrom() {
        boolean palindrome_flag = true;

        int i=0;
        while ((int) n[i]!=0) {
            i++;
            if (i>=limit) {
                break;
            }
        }
        int length = i-1;

        int comp_length = (length - length%2)/2;
        for (i=0; i<comp_length; i++) {
        // Zakładamy, że wszystkie znaki są z małej litery (nie rozpatrujemy przypadku, że występują duże litery)
            if (n[i] != n[length-1-i]) {
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