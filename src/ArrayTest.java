import java.util.Random;

public class ArrayTest {

    private int min = -10;
    private int max = 20;

    private static int[] array = new int[20];

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
            }
            else if ((array[i] < max) && (array[i] > secondMax)) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }
}
