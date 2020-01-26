package homework.sort;

/**
 * Class for insert sort
 */
public class InsertSort implements IntArray {
    /**
     * Method for int array sort using insert sort
     * @param array int
     * @return sorted array
     */
    @Override
    public int[] sortIntArray(int [] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        return array;
    }

}
