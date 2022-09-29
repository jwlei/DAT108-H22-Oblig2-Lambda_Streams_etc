package ex2.task1.part1a;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

        System.out.println("Før sortering: " + listen);


        Collections.sort(listen, (a, b) -> (Integer.valueOf(a)).compareTo(Integer.valueOf(b)));

        System.out.println("Etter sortering: " + listen);


    }
}
