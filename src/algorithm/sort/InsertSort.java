package algorithm.sort;

public class InsertSort {
	//ÿ�δ��������ȡ����һ��Ԫ�أ��������뵽�����ĺ���λ�ã�ʹ�������Ȼ����
    public static void insertSort(int a[], int n) {
        int t;
        for (int i=1;i<n;i++) {
            t = a[i];//�Ѵ�����Ԫ�ظ���t
            int j;
            for (j=i;j>0 && t<a[j-1];j--) {
                a[j] = a[j-1];//˳��ȽϺ��ƶ�
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
