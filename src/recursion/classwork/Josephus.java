package recursion.classwork;

public class Josephus {
    public static int josephus(int n, int k) {
        if (n == 1) return 0;
        return (josephus(n - 1, k) + k ) % n ;
    }

    public static void main(String[] args) {
        System.out.println("josephus(5,3) = " + josephus(5, 3));
    }

}
