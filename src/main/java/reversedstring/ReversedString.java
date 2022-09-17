package reversedstring;

public class ReversedString {

    public static String reverse(String s) {
        char[] letters = new char[s.length()];
        int letterIndex = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            letters[letterIndex] = s.charAt(i);
            letterIndex++;
        }
        String reverse = "";
        for (int i = 0; i < s.length(); i++) {
            reverse += letters[i];
        }
        return reverse;
    }

    public static void main(String[] args) {
        String r = reverse("Example test string!");
        System.out.println(r);
    }
}
