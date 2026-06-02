package input.scanner;


import java.util.ArrayDeque;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        String[] parts = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        System.out.println('C' - 'A');

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(arr[0]);
        queue.offer(arr[1]);
        queue.offer(arr[2]);
        queue.offerFirst(arr[3]);
        queue.pollLast();
        printQueue(queue);


    }

    private static void printQueue(ArrayDeque<Integer> queue) {
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
    }

    public static void printArray(int[] arr) {
        System.out.println("Printing the array elements");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
