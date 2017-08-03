package common;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Elmira Andreeva on 8/1/17.
 */
public class Base {
    public static void printList(Iterator it) {
        if (it == null || !it.hasNext()) {
            println("Array is empty");
            return;
        }
        for (; it.hasNext(); ) {
            print(it.next().toString() + ",");
        }
    }

    public static void printList(Iterable array) {
        if (array == null || array.iterator() == null || !array.iterator().hasNext()) {
            println("Array is empty");
            return;
        }
        for (Iterator it = array.iterator(); it.hasNext(); ) {
            print(it.next().toString() + ",");
        }
        println("");
    }

    public static void printListBinary(Iterable<Integer> array) {
        if (array == null || array.iterator() == null || !array.iterator().hasNext()) {
            println("Array is empty");
            return;
        }
        for (Iterator<Integer> it = array.iterator(); it.hasNext(); ) {
            print(Integer.toBinaryString(it.next()) + ",");
        }
        println("");
    }

    public static void printListList(List<List> array) {

        if (array == null || array.iterator() == null || !array.iterator().hasNext()) {
            println("List is empty");
            return;
        }
        for (Iterator it = array.iterator(); it.hasNext(); ) {
            printList(it);
        }
        println("");
    }

    public static void printArray(Object[] array) {
        printArray(array, ",");
    }

    public static void printArray(Object[] array, String delim) {
        if (array == null || array.length == 0) {
            println("Array is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            print(array[i] + delim);
        }
    }

    public static void printArray(boolean[] array) {
        if (array == null || array.length == 0) {
            println("Array is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            print(array[i] + ",");
        }
    }

    public static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            println("Array is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            print(array[i] + ",");
        }
    }

    public static void printArray(long[] array) {
        if (array == null || array.length == 0) {
            println("Array is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            print(array[i] + ",");
        }
    }

    public static void printArray(char[] array) {
        if (array == null || array.length == 0) {
            println("Array is empty");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            print(array[i] + ",");
        }
    }

    public static void printMatrix(int[][] array) {
        if (array == null || array.length == 0) {
            println("Array is empty");
            return;
        }
        int N = array.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < array[i].length; j++) {
                print(array[i][j] + " ");
            }
            println("");
        }
    }

    public static void printBooleanMatrix(boolean[][] array) {
        if (array == null || array.length == 0) {
            println("Array is empty");
            return;
        }
        int N = array.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < array[i].length; j++) {
                print(array[i][j] ? "* " : "- ");
            }
            println("");
        }
    }

    public static void printCharMatrix(char[][] array) {
        if (array == null || array.length == 0) {
            println("Array is empty");
            return;
        }
        int N = array.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < array[i].length; j++) {
                print(array[i][j] + " ");
            }
            println("");
        }
    }

    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}
