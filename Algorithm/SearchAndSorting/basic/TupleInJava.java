package basic;
/**
 * 
 * @author zhurundong
 *
 * This class trying to implement tuple (Python data structure) in Java
 * 
 * Comparison of Tuples vs Lists/Arrays
 * Tuple is often compared with List as it looks very much like a list. But they differ in some aspects.
 * 1. A tuple is an object that can contain heterogeneous data. Lists are designed to store elements of a single type.
 * 2. Out of all data structures, a tuple is considered to be the fastest and they consume the least amount of memory.
 * 3. While array and list are mutable which means you can change their data value and modify their structures, a tuple is immutable.
 * 4. Like an array, a tuple is also fixed in size. That is why tuples aims to replace array completely as they are more efficient in all parameters.
 * 5. If you have a dataset which will be assigned only once in lifetime and its value should not change again, you need a tuple.
 */
public class TupleInJava {
    
    class Tuple<A, B> {
        public final A a;
        public final B b;
        
        public Tuple(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
