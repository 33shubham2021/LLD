package random;
import java.util.*;
public class RandomTest {
    public static void main(String[] args) {
        Deque<Integer> st = new  ArrayDeque<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.addLast(4);
        printDeque(st);


    }

    public static void printDeque(Deque<Integer> arr){
        for (Integer i : arr){
            System.out.println(i);
        }
    }
}
