package algorithm.sort;

public class InsertSort {
	//每次从无序表中取出第一个元素，把它插入到有序表的合适位置，使有序表仍然有序。
    public static void insertSort(int a[], int n) {
        int t;
        for (int i=1;i<n;i++) {
            t = a[i];//把待排序元素赋给t
            int j;
            for (j=i;j>0 && t<a[j-1];j--) {
                a[j] = a[j-1];//顺序比较和移动
            }
            a[j] = t;
        }
    }
    
    public static void printArray(int a[]) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{15,3,11,7,4,6,20,9};
        insertSort(arr, 8);
        printArray(arr);
    }
}
