package ex2.task1.part1a;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
         * The task:
         * Sort the list of Strings with in ascending order based on the Integer value
         * Utilize a lambda expression as a comparator in the Collections.sort() method.
         */

        /*
         * By using Collections.sort(list<>, comparator(actionToCompare))
         * Collections.sort(intList, (x,y) -> Integer.valueOf(x).compareTo(Integer.valueOf(y)));
         */
        List<String> intList = Arrays.asList("10", "1", "20", "110", "21", "12");

        Collections.sort(intList, (x,y) -> Integer.valueOf(x).compareTo(Integer.valueOf(y)));

        // ALTERNATIVELY using a comparator.comparing and function call to Integer.valueOf()
        // Collections.sort(intList, Comparator.comparing(Integer::valueOf));

        // ----------------- OR -----------------

        // Collections.sort(intList, (x, y) -> {
        //    Integer x1 = Integer.parseInt(x);
        //    Integer y1 = Integer.parseInt(y);
        //
        //    return x1.compareTo(y1);
        // });

        System.out.println("[TASK 1A] - A sorted list using Collections.sort(list, comparator) \n" + intList);


        // --------------------- Misc notes ---------------------
        /*
         * Basic lambda:
         * () -> Action
         * (param1) -> action(param1)
         * (param1, param2) -> action(param1, param2)
         */

        /*
         * Collections.sort(list<>, new Comparator<Integer>() {
         * @Override
         * public int compare(String s1, String s2) {
         *     return s1.compareTo(s2);
         *     }
         *  });
         * ----------------- OR -----------------
         * Collections.sort(list<>, String::compareTo);
         *
         */










    }
}
