package algorithm;

import java.util.Random;
import java.util.Stack;

public class StackMin {
    
    private final  Stack<Integer> dataStack = new Stack<Integer>();
    private final  Stack<Integer> indexStack = new Stack<Integer>();
    
    // get the last element
    public int top(){
        return Integer.valueOf(dataStack.pop()); 
    }
    
    public void push(int value) {
       // append the data into the end 
       dataStack.push(Integer.valueOf(value));
       
       //set the index of minimum element in mainStack
       if(indexStack.size() == 0) {
           indexStack.push(0);
       } else {
           if (value < dataStack.elementAt(indexStack.lastElement().intValue())) {
               indexStack.push(Integer.valueOf(dataStack.size()-1));
           }
       }
    }
    
    // erease the element at the end of stack
    public void pop() {
        if (indexStack.empty())
            return;
        if (indexStack.lastElement().intValue() == dataStack.size()-1)
            dataStack.pop();
        dataStack.pop();
    }
    
    public int min() {
        return dataStack.elementAt(indexStack.lastElement().intValue());
    }
    
    public static void main(String[] args) {
        StackMin stack = new StackMin();
        Random random = new Random();
       
        for (int i=0;i<10;i++) {
            int r = random.nextInt(20);
            stack.push(r);
            System.out.print(r + " ");
        }
        
        System.out.println(); 
        System.out.println(stack.min());
        
        
    }
}
