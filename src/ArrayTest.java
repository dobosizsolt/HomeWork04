import java.util.Random;

public class ArrayTest {

    private int min = -10;
    private int max = 20;

    private static int[] array = new int[20];
    private static int[][] matrix = new int[5][5];

    public void initArray() {

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            int numbers = random.nextInt(max - min + 1) + min;
            array[i] = numbers;
        }
    }

    public static int getSecondHighest() {

        int max = array[0];
        int secondMax = array[0];

        for (int i = 1; i < array.length; i++) {
            if ((array[i] > max) && (array[i] < secondMax)) {
                secondMax = max;
                max = array[i];
            } else if ((array[i] < max) && (array[i] > secondMax)) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }

    public static void initMatrix() {

        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void searchNotNullRows() {

        /**Deklaráltam egy isNullInRows nevű boolean tipusú változót
         * a sorok vizsgálatának az eredményére és for ciklussal megvizsgáltam
         * a sorokat, deklaráltam egy isNullIn nevű boolean változót
         * az oszlopok vizsgálatának az eredményére. Ha nem talált 0 elemet,
         * akkor kiírja konzolra melyik sorban nincs 0 elem. Ha minden sorban van 0 elem
         * akkor azt írja ki.*/

        boolean isNullInRows = false;
        for (int i = 0; i < matrix.length; i++) {

            boolean isNullIn = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    isNullIn = true;
                }
            }
            if (!isNullIn) {
                isNullInRows = true;//Találat esetén nem hajtódik végre az "if(!isNillInRows)" feltétel.
                System.out.println("A " + i + ". sor(ok)ban nincs 0 elem.");
            }

        }
        if (!isNullInRows) {
            System.out.println("Nincs olyan sor, amiben ne lenne 0 elem.");
        }

    }


}
