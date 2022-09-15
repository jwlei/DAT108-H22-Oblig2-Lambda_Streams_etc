package ex2.task3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {

    private final static int INCREASED_SALARY = 50_000;
    private final static int PERCENTAGE_INCREASE = 7;
    private final static int INCREASED_LOW_SALARY = 30_000;
    private final static int PERCENTAGE_INCREASE_MALE = 15;

    public static void main(String[] args) {

        /*
         * Create a list with dummy data to perform operations on
         */
        List<Employee> employeeList = Arrays.asList(
                new Employee("Tom",     "Hansen",   Gender.MALE,    "Boss",         1_000_000),
                new Employee("Kari",    "Nielsen",  Gender.THEY,    "Sales",        500_000),
                new Employee("Ole",     "Karlsen",  Gender.MALE,    "Sales",        500_000),
                new Employee("Per",     "Crowo",    Gender.MALE,    "FullStack",    700_000),
                new Employee("Mona",    "Aarsen",   Gender.FEMALE,  "BackEnd",      500_000),
                new Employee("Lise",    "Aanstad",  Gender.FEMALE,  "FrontEnd",     600_000),
                new Employee("Jurgen",  "Hansen",   Gender.MALE,    "FrontEnd",     500_000)
        );

        // TODO
        // Task a - List of lastNames

        // Task b - Number of Gender.FEMALE

        // Task c - Average salary of Gender.FEMALE

        // Task d - Give all "Bosses" a 7% raise. Print the list after

        // Task e - Return boolean if anyone has a salary greater than 800_000

        // Task f - Print the employee list with System.out.println() without using a loop

        // Task g - Find the employee(s) with the lowest salary

        // Task h - Find the sum of all whole numbers [1 < 1000] divisible by 3 || 5
    }



    private static void salaryAdjustment(List<Employee> employeeList, Function<Employee, Integer> function) {
        employeeList.forEach(employee -> employee.setSalary(function.apply(employee)));
    }

    private static void printAll(List<Employee> employeeList) {
        /*
         * A bit redundant, but it looks nice when calling the print all
         */
        System.out.print(employeeList);
        System.out.println();
    }
}
