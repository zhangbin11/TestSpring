package prs.test;

/**
 * Created by zhangbin on 2017/11/17.
 */
public class TestSort {

    public static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int tmp = 0;
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                }
            }
        }
        printArray(numbers);
    }

    public static void main(String[] args) {
        int[] numbers = getrandomarray(10);
        bubbleSort(numbers);
    }

    public static void printArray(int[] numbers) {
        for (int i : numbers) {
            System.out.println("" + i);
        }
    }

    public static int[] getrandomarray(int log) {
        int[] result = new int[log];
        for (int i = 0; i < log; i++) {
            result[i] = i;
        }
        for (int i = 0; i < log; i++) {
            int random = (int) (log * Math.random());
            int temp = result[i];
            result[i] = result[random];
            result[random] = temp;
        }
        return result;
    }
}
