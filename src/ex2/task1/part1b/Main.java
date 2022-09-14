package ex2.task1.part1b;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {


        // part i
        int sumX = 12, sumY = 13;

        // part ii
        int largestX = -5, largestY = 3;

        // part iii
        int distanceX = 54, distanceY = 45;

//        calculate(x, y, bf);
//        calculate(x, y, bf);
//        calculate(x, y, bf);

        public static int calculate (int x, int y, BiFunction<Integer, Integer, Integer> bf) {
            return bf.apply(x, y);
        }



        /**
         * We create a BiFunction which
         * BiFunction<T, U, R> nameOfFunction = ... {}
         * T = First argument
         * U = Second argument
         * R = returnable result
         */

        // part i
        BiFunction<Integer, Integer, Integer> add = (x, y) -> {
            /**
             * We use the BiFunction to return the result of summing
             * integers X and Y.
             */
            return (x + y);
        };

        // part ii
        BiFunction<Integer, Integer, Integer> getLargest = (x, y) -> {
            /**
             * (We Check) ? returnIfTrue : returnIfFalse
             */
            return x.compareTo(y) > 0 ? x : y;
        };

        // part iii
        BiFunction<Integer, Integer, Integer> getDistance = (x, y) -> {
            /**
             * The absolute value of x. If x is negative (including -0), returns -x. Otherwise, returns x.
             * e.g. -54 -(-54) = 4
             * Since Math.abs(x - y) does not produce negative numbers, we get the
             * absolute distance between int X and Y by using Math.abs(x - y);
             */
            return Math.abs(x - y);
        };


    }
}
