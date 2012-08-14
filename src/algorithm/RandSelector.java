package algorithm;

import java.util.Iterator;
import java.util.Vector;

/*
 * 随机选出 m 个数
*/
public class RandSelector<T> {
    public boolean getRand(Vector<T> data, int m, Vector<T> randVector) {
        int size = data.size();
        if (size < m || m == 0){
            return false;
        }
        for (int i=0,nsize=size;i<nsize;i++) {
            if (frand() <= (float)m/size) {
                randVector.add(data.elementAt(i));
                m--;
                System.out.print(data.elementAt(i) + " ");
            }
            size--;
        }
        return true;
    }
    
    public float frand() {
        return (float)Math.random();
    }
    
    public static void main(String[] args) {
        Vector<Integer> data= new Vector<Integer>();
        for (int i=0;i<100;i++) {
            data.add(Integer.valueOf(i));
        }
        
        RandSelector<Integer> selector = new RandSelector<Integer>();
        Vector<Integer> result = new Vector<Integer>();
        selector.getRand(data, 10, result);
        
        Iterator<Integer> ite = result.iterator();
        
//        while(ite.hasNext()) {
//            System.out.print(ite.next().intValue() + " ");
//        }
    }

}
