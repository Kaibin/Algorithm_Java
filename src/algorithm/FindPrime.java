package algorithm;

public class FindPrime {
    /*    
     * ֻҪ����2��sqrt��n��֮������Ϳ����ˣ�
     * ��Ϊ���һ���������ӵĻ�����ô���ض���һ�����Ӳ����ڸ�����ƽ������
    */    
    public static void findPrime(int num) {
        for (int i=3;i<num;i++){
            boolean isPrime = true;
            for (int j=2;j<=Math.sqrt(i);j++) {
                if (i%j == 0) {
                    isPrime = false;
                    break;//������֤���Ǻ����������˳�ѭ����
                }
            }
            if (isPrime) {
                System.out.println(i + "  a prime num");
            }
        }
    }
    
    public static void main(String[] args) {
        findPrime(100);
    }
}
