package homework.sortarray;

import java.util.Comparator;

public interface Sort {
    <T> void sort(T[] array, Comparator<? super T> comparator);

    <T extends Comparable<? super T>> void sort(T[] array);
}
