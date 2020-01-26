package homework.sort;

/**
 * Class for bubble sort
 */
public class BubbleSort implements IntArray{
    /**
     * Method for int array sort using bubble sort
     * @param array int
     * @return sorted array
     */
    @Override
    public int[] sortIntArray(int [] array) {
        for(int i = array.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++) {
                if( array[j] > array[j+1] ) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }
}
