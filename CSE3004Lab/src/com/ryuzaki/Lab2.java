package com.ryuzaki;

public class Lab2 {
    public class MergeSort {
        private static void merge(String[] arr, int l, int r, int m) {
            int n1 = m-l+1;
            int n2 = r-m;

            String[] L = new String[n1];
            for (int i=0; i<n1; ++i) {L[i] = arr[l+i];}
            String[] R = new String[n2];
            for (int j=0; j<n2; ++j) {R[j] = arr[m+j+1];}

            int i=0, j=0, k=l;

            while (i<n1 && j<n2) {
                if (L[i].compareTo(R[j])<=0) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i<n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            while (j<n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        private static void sort(String[] arr, int l, int r) {
            if (l<r) {
                int m = l+(r-l)/2;

                sort(arr, l, m);
                sort(arr, m+1, r);

                merge(arr, l, r, m);
            }
        }

        public static void mergeSort(String[] arr) {
            int l = 0;
            int r = arr.length-1;

            if (l<r) {
                int m = l+(r-1)/2;

                sort(arr, l, m);
                sort(arr, m+1, r);

                merge(arr, l, r, m);
            }
        }
    }

    public class QuickSort {
        public static void quickSort(String[] arr) {
            sort(arr, 0, arr.length-1);
        }

        private static void sort(String[] arr, int low, int high) {
            if (low < high) {
                int partitionIndex = partition(arr, low, high);
                sort(arr, low, partitionIndex - 1);
                sort(arr, partitionIndex + 1, high);
            }
        }

        private static int partition(String[] arr, int low, int high) {
            String pivot = arr[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (arr[j].compareTo(pivot) <= 0) {
                    i++;
                    swap(arr, i, j);
                }
            }

            swap(arr, i + 1, high);
            return i + 1;
        }

        private static void swap(String[] array, int i, int j) {
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void printArray(String[] arr){
        for (String ele:arr) {System.out.print(ele+' ');}
        System.out.println();
    }

    public static void printArray(int[] arr){
        for (int ele:arr) {System.out.print(ele+" ");}
        System.out.println();
    }

    public static void main(String[] args) {
        String[] arr = {"gaurav", "dhruv", "tarun", "nidhi", "jai"};
        printArray(arr);
        MergeSort.mergeSort(arr);
        printArray(arr);

        String[] arr2 = {"gaurav", "dhruv", "tarun", "nidhi", "jai"};
        printArray(arr2);
        QuickSort.quickSort(arr2);
        printArray(arr2);
    }
}
