package ex2.task1.part1b;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {

        /*
         * The task:
         * Create a method to perform whole numbers calculations
         * -> public static int calculate(int x, int y, BiFunction<T, U, R>) {}
         * Use the method to calculate the sum of 12, 13
         *                   Find the greatest value of -5 and 3
         *                   Find the absolute distance between 54 and 45
         *
         * The third parameter of the method should be input as a parameter
         * e.g. int sum = calculate(12, 13, getSum);
         */


        // part i
        int sumX = 12, sumY = 13;

        // part ii
        int largestX = -5, largestY = 3;

        // part iii
        int distanceX = 54, distanceY = 45;


        /*
         * Misc, syntax etc.
         * We create a BiFunction which
         * BiFunction<T, U, R> nameOfFunction = ... {}
         * T = First argument
         * U = Second argument
         * R = returnable result
         */

        // part i
        BiFunction<Integer, Integer, Integer> getSum = (x, y) -> {
            /**
             * We use the BiFunction to return the result of summing
             * integers X and Y.
             */
            return (x + y);
        };

        // part ii
        BiFunction<Integer, Integer, Integer> getLargest = (x, y) -> {
            /*
             * (We Check) ? returnIfTrue : returnIfFalse
             * x.compareTo(y) returns 1 if true, -1 if false
             * so if x.compareTo(y) > 0 is true, return x, else y
             */
            return x.compareTo(y) > 0 ? x : y;
        };

        // part iii
        BiFunction<Integer, Integer, Integer> getDistance = (x, y) -> {
            /*
             * The absolute value of x. If x is negative (including -0), returns -x. Otherwise, returns x.
             * e.g. -54 - (-54) = 54
             * Since Math.abs(x - y) does not produce negative numbers, we get the
             * absolute distance between int X and Y by using Math.abs(x - y);
             */
            return Math.abs(x - y);
        };


        /*
         * Use each BiFunction to calculate the result using their respective
         * integer values (i, ii, iii).
         */
        int ansI = calculate(sumX, sumY, getSum);
        int ansII = calculate(largestX, largestY, getLargest);
        int ansIII = calculate(distanceX, distanceY, getDistance);

        System.out.format("The sum of %d and %d is [%d]. \n", sumX, sumY, ansI);
        System.out.format("The largest value of %d and %d is [%d]. \n", largestX, largestY, ansII);
        System.out.format("The absolute distance between %d and %d is [%d] \n", distanceX, distanceY, ansIII);
    }

    public static int calculate (int x, int y, BiFunction<Integer, Integer, Integer> bf) {
        /**
         * TODO: Comment
         */
        return bf.apply(x, y);
    }
}
