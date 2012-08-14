package algorithm.sort;

/**
 * @author kaibin
 * http://www.wutianqi.com/?p=1820
 * http://blog.csdn.net/midgard/article/details/4070074
 */

public class HeapSort {
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void adjust(int a[], int pos, int len) {
        int temp = a[pos];
        int index = pos * 2 + 1;
        while (index < len) {
            //记录左右节点最大的数组元素下标 
            if (index + 1 < len && a[index] < a[index + 1]) {
                index += 1; 
            }
            //建立局部最大堆，
            if (a[pos] < a[index]) {
                a[pos] = a[index]; ////将大者放到根节点
                pos = index; //pos下移
                index = 2 * pos + 1;
            } else {
                break;
            }
            a[pos] = temp;
            
        }
    }
    
   /* 
    * 将数组看成完全二叉树，建立最大堆
    * */ 
    public static void buildheap(int a[], int len) {
        // 自底向上建堆
        int pos = (len - 1) / 2;
        for (int i = pos; i >= 0; i--) {
            adjust(a, i, len);
        }
    }
    
    public static void heapsort(int a[], int len) {
        //建立初始的大根堆
        buildheap(a, len);
        for (int i = 0;i < len;i++) {
            //将最大数组元素a[0]换到无序区的最后
            swap(a, 0, len-1-i);
            //调整无序区
            adjust(a, 0, len-1-i);
            //打印中间过程
            printArray(a);
        }
    }
    
    public static void printArray(int a[]) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String args[]){  
        int[]a={15,24,25,68,12,10,45,18,27};  
        heapsort(a,a.length);  
    }  
}
