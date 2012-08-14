package algorithm.sort;

public class SelectSort {
    public static void selectSort(int[] a) {
        int min;
        int min_index;
        for (int i=0;i<a.length;i++) {
            min = a[i];
            min_index = i;
            for (int j=i+1;j<a.length;j++) {
                if (a[j] < min) {
                    min = a[j];
                    min_index = j;
                }
            }
            if (min_index == i) {
                continue;
            }
            swap(a,min_index,i);
        }
    }
    
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void printArray(int a[]) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] a = new int[]{3,1,8,7,6,5,4};
        selectSort(a);
        printArray(a);
        
    }
}
