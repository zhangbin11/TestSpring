package prs.test;

/**
 * Created by zhangbin on 2017/11/17.
 */
public class TestQuickSort {

    public static void quickSort(int numbers[] ,int low ,int high){
        if(low < high){
            int pivot = numbers[low];
            int left = low;
            int right = high;
            while(left < right) {
                while (left < right && numbers[right] > pivot) {
                    right--;
                }
                numbers[left] = numbers[right];
                while (left < right && numbers[left] < pivot) {
                    left++;
                }
                numbers[right] = numbers[left];
            }
            numbers[left] = pivot;
            quickSort(numbers, low, left - 1);
            quickSort(numbers, left + 1, high);
        }

    }

    public static void quicksort(int[] v, int left, int right){
        if(left < right){
            int key = v[left];
            int low = left;
            int high = right;
            while(low < high){
                while(low < high && v[high] > key){
                    high--;
                }
                v[low] = v[high];
                while(low < high && v[low] < key){
                    low++;
                }
                v[high] = v[low];
            }
            v[low] = key;
            quicksort(v, left, low - 1);
            quicksort(v, low + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] numbers = TestSort.getrandomarray(10);
        quickSort(numbers, 0, numbers.length - 1);
        TestSort.printArray(numbers);
    }
}
