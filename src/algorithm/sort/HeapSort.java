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
            //��¼���ҽڵ���������Ԫ���±� 
            if (index + 1 < len && a[index] < a[index + 1]) {
                index += 1; 
            }
            //�����ֲ����ѣ�
            if (a[pos] < a[index]) {
                a[pos] = a[index]; ////�����߷ŵ����ڵ�
                pos = index; //pos����
                index = 2 * pos + 1;
            } else {
                break;
            }
            a[pos] = temp;
            
        }
    }
    
   /* 
    * �����鿴����ȫ����������������
    * */ 
    public static void buildheap(int a[], int len) {
        // �Ե����Ͻ���
        int pos = (len - 1) / 2;
        for (int i = pos; i >= 0; i--) {
            adjust(a, i, len);
        }
    }
    
    public static void heapsort(int a[], int len) {
        //������ʼ�Ĵ����
        buildheap(a, len);
        for (int i = 0;i < len;i++) {
            //���������Ԫ��a[0]���������������
            swap(a, 0, len-1-i);
            //����������
            adjust(a, 0, len-1-i);
            //��ӡ�м����
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
