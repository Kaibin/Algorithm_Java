package algorithm.sort;

public class QuickSort {
    public static void quickSort(int a[], int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = partition(a,low,high);
        quickSort(a, low, mid - 1);
        quickSort(a, mid + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int x = a[low]; // 同样，暂时以第一个元素进行划分  
        int i = low;  
        int j = high + 1;  
        while (true) { // 我们从左向右找到一个比 x 大数， 再从右向左找到一个比 x 小的数，交换  
            do {  
                j--;  
            } while (i < j && a[j] >= x); // 先从右向左找到一个比 x 小的数  
              
            do { // 再找一个比x 大的数， 这里不检查上一步有没找到，因为如果没找到 将会使i > j  
                i++;  
            } while (i < j && a[i] <= x);    
              
            if (i < j) { // 都找到了，就交换, 此时 [low + 1, i] <= x <= [j, high]  
                swap(a, i, j);   
            } else {  
                break;  
            }  
        }  
         
          swap(a, low, j);  
          return j;  
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
    
    public static void main(String args[]){  
        int[]a={15,24,25,68,12,10,45,18,27};  
        quickSort(a,0,a.length-1); 
        printArray(a);
    }  
}
