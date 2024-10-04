package reference.sortingalgorithm;

import java.util.Scanner;

public class SortingAlgorithm {

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selectionSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void bubbleSort(int a[], int n) {
        for (int i = 0; i < n; i++) {
            boolean swaped = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swaped = false;
                }
            }
            if (swaped) {
                break;
            }
        }
    }

    public static void insertionSort(int a[], int n) {
        for (int i = 1; i < n; i++) {
            int pos = i - 1, x = a[i];
            while ((pos >= 0) && (a[pos] > x)) {
                a[pos + 1] = a[pos];
                pos--;
            }
            a[pos + 1] = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // selectionSort(arr, n);
        // bubbleSort(arr, n);
        insertionSort(arr, n);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
