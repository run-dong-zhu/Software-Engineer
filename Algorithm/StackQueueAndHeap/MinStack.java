package stackandqueue;

import java.util.Stack;

/**
 * 
 * @description LeetCode 155, level: Easy
 *
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {
    private Stack<Integer> dataStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    
    void push(int x) {
        dataStack.push(x);
        if(minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        }
        else {
            minStack.push(minStack.peek());
        }
    }
    
    void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    int top() {
        return dataStack.peek();
    }
    
    int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(1);
        ms.push(-2);
        ms.push(3);
        ms.push(-5);
        
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }

}
