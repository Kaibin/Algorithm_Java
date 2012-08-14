package algorithm;

// TODO: Auto-generated Javadoc
/**
 * The Class BinarySearch.
 */
public class BinarySearch {
    
    /**
     * Binary search.
     *
     * @param array ��������
     * @param des ����Ԫ��
     * @return des�������±꣬û�ҵ�����-1
     */
    public static int binarySearch(int array[],int des) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = array.length -1;
        
        while (start <= end) {
            int middle = (start + end)/2;
            if (array[middle] == des) {
                return middle;
            } else if (des < array[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int array[]  = new int[]{1,3,5,7,9,11,12,13};
        int result = binarySearch(array, 3);
        System.out.println("The index is: " + result);
    }
}
