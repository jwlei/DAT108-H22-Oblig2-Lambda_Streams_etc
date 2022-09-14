package ex2.task1.part1b;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        int sum1 = 12;
        int sum2 = 13;

        int stoerst1 = -5;
        int stoerst2 = 3;

        int absolutt1 = 54;
        int absolutt2 = 45;

        BiFunction<Integer, Integer, Integer> summerFunksjon = (a, b) -> {
            return a + b;
        };

        BiFunction<Integer, Integer, Integer> stoerstFunksjon = (a, b) -> {
            return a.compareTo(b) > 0 ? a : b;
        };

        BiFunction<Integer, Integer, Integer> absoluttFunksjon = (a, b) -> {
            return Math.abs(a - b);
        };

        int sum = beregn(sum1, sum2, summerFunksjon);
        int stoerst = beregn(stoerst1, stoerst2, stoerstFunksjon);
        int absoluttVerdi = beregn(absolutt1, absolutt2, absoluttFunksjon);

        System.out.println(sum);
        System.out.println(stoerst);
        System.out.println(absoluttVerdi);
    }

    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> func) {
        return func.apply(a, b);
    }
}
