package fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static int fib(int n) {

        int elementA = 0;
        int elementB =1;
        int result = 0;

        if (n < 2) return n;

        for (int i = 2; i <= n - 1; i++) {
            result = elementA + elementB;
            elementA = elementB;
            elementB = result;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Which element of the fibonacci.Fibonacci sequence to calculate?");

        int n = sc.nextInt();
        System.out.println(n + " element of the fibonacci.Fibonacci sequence is: " + fib(n));
    }
}
