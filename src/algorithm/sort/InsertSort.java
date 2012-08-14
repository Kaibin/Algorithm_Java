package algorithm.sort;

public class InsertSort {
    public static void insertSort(int a[], int n) {
        int t;
        for (int i=0;i<n;i++) {
            t = a[i];//�Ѵ�����Ԫ�ظ���t
            int j = i-1;
            for (j=i-1;j>=0 && t<a[j];j--) {
                a[j+1] = a[j];//˳��ȽϺ��ƶ�
            }
            a[j+1] = t;
        }
    }
    
    public static void printArray(int a[]) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,7,4,6,2,9};
        insertSort(arr, 7);
        printArray(arr);
    }
}
