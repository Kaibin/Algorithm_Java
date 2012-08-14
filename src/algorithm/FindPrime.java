package algorithm;

public class FindPrime {
    /*    
     * 只要检查从2到sqrt（n）之间的数就可以了，
     * 因为如果一个数有因子的话，那么它必定有一个因子不大于该数的平方根。
    */    
    public static void findPrime(int num) {
        for (int i=3;i<num;i++){
            boolean isPrime = true;
            for (int j=2;j<=Math.sqrt(i);j++) {
                if (i%j == 0) {
                    isPrime = false;
                    break;//有因子证明是合数，马上退出循环。
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
