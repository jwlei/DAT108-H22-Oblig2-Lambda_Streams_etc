package ex2.task1.part1a;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");


        Collections.sort(listen, (a,b) -> {
            return a.compareTo(b);
        });

        System.out.println(listen);

    }
}
