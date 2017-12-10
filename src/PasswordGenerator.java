import java.util.Random;

/**Deklaráltam egy int típusú length nevű változót a jelszó
 * hosszának beállítására. Majd 4 final string változót, melyekben
 * a választható karakterek vannak, majd egy String típusú chars nevű változóban
 * konkatenáltam a karaktereket. Létrehoztam egy generatePassword metódust 1 int típusú
 * bemeneti paraméterrel. *
 * for ciklusban random kiválasztottam egy karaktert,
 * majd visszatérési értékben hozzáadtam a soronkövetkező karaktert.*/

public class PasswordGenerator {



    public static Random random = new Random();

    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SYMBOLS = "§<>#&@%!+/=*-";
    public static String chars = LETTERS + CAPITALS + NUMBERS + SYMBOLS;

    public static String generatePassword(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            int getChars = random.nextInt(chars.length());
            result += chars.charAt(getChars);
        }
        return result;
    }

}
