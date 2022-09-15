package ex2.task1.part1a;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> intList = Arrays.asList("10", "1", "20", "110", "21", "12");

        /**
         * Sort the list of Strings with in ascending order based on the Integer value
         * Utilize a lambda expression as a comparator in the Collections.sort() method.
         *
         * Basic lambda:
         * (x, y) -> x.Attribute().compareTo(y.Attribute());
         */

        /*
         * Collections.sort(list, new Comparator<Integer>() {
         * @Override
         * public int compare(String s1, String s2) {
         *     return s1.compareTo(s2);
         *     }
         *  });
         * ----------------- OR -----------------
         * Collections.sort(list, String::compareTo);
         *
         */

        /*
         * Collections.sort(listToSort, (compareX, compareY) -> {
         *      type x = typeCast.compareX
         *      type y = typeCast.compareY
         *      return x.compareTo(y)
         * }
         */

        // Collections.sort(intList, (x,y) -> Integer.parseInt(x) - Integer.valueOf(y));

        // Collections.sort(intList, (x,y) -> {
        //      return x.compareTo(y);
        // });

        Collections.sort(intList, (x, y) -> {
            Integer x1 = Integer.parseInt(x);
            Integer y1 = Integer.parseInt(y);

            return x1.compareTo(y1);
        });
        System.out.println(intList);
    }
}
