package stackandqueue;

import java.util.PriorityQueue;

/**
 * 
 * @description LeetCode 295, level: Hard
 *
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {
    
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>();
        min = new PriorityQueue<>((x, y) -> y - x);
    }
    
    public void addNum(int num) {
        if(max.isEmpty()) {
            max.add(num);
            return;
        }
        
        if(max.size() == min.size()) {
            if(num < max.peek()) {
                min.add(num);
            }
            else {
                max.add(num);
            }
        }
        else if(max.size() < min.size()) {
            if(num >= min.peek()) {
                max.add(num);
            }
            else {
                min.add(num);
                max.add(min.poll());
            }
        }
        else {
            if(num <= max.peek()) {
                min.add(num);
            }
            else {
                max.add(num);
                min.add(max.poll());
            }
        }
    }
    
    public double findMedian() {
        if(max.size() > min.size()) {
            return max.peek();
        }
        else if (max.size() < min.size()) {
            return min.peek();
        }
        return (max.peek() + min.peek()) / 2.0;
    }
    
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(0);
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

}
