package homework.sort;

public class Main {

    public static void main (String[] args) {
        int [] array = new int [] {};
        // new BubbleSort().sortIntArray(array);
        // new SelectionSort().sortIntArray(array);
        new InsertSort().sortIntArray(array);
        System.out.println("Sorted array:");
        for (int i: array) {
            System.out.print(i+" ");
        }

    }
}
