package recursion.homework;

public class PowerFunction {

    public static int power(int a, int b) {
        if (b == 0) return 1;
        return (power(a, b - 1) * a);
    }

    public static int fastPower(int a, int b) {
        if (b == 0) return 1;
        // reduce recursive call by half
        if (b % 2 == 0) return fastPower(a * a, b / 2); // even
        return a * fastPower(a, b - 1); // odd
    }

    public static long fastPowerWithModulo(double a, int b, int m) {
        if (b == 0) return 1;
        long half = fastPowerWithModulo(a, b / 2, m);
        long halfMod = (half * half) % m; // prevent overflow

        if (b % 2 == 0) {
            return halfMod; // even
        } else {
            return (long) ((a * halfMod) % m); // odd
        }
    }


    public static void main(String[] args) {
        System.out.println("power(5, 4) = " + power(5, 4));
        System.out.println("fastPower(5, 4) = " + fastPower(5, 4));
        int m = (int) (1e9 + 7);
        System.out.println("fastPowerWithModulo(5,4,m) = " + fastPowerWithModulo(5, 4, m));
    }
}
