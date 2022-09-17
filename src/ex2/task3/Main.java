package ex2.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ex2.task3.Gender.*;

public class Main {
    private final static int PERCENTAGE_INCREASE = 7;

    public static void main(String[] args) {

        /*
         * Create a list with dummy data to perform operations on
         */
        List<Employee> employeeList = Arrays.asList(
                new Employee("Tom",     "Hansen",   MALE,    "Boss",         1_000_000),
                new Employee("Kari",    "Nielsen",  THEY,    "Sales",        500_000),
                new Employee("Ole",     "Karlsen",  MALE,    "Sales",        500_000),
                new Employee("Per",     "Crowo",    MALE,    "FullStack",    700_000),
                new Employee("Mona",    "Aarsen",   FEMALE,  "BackEnd",      500_000),
                new Employee("Lise",    "Aanstad",  FEMALE,  "FrontEnd",     600_000),
                new Employee("Jurgen",  "Hansen",   MALE,    "FrontEnd",     500_000)
        );

        System.out.println("[INITIAL LIST] - \n" + employeeList + "\n");


        // Task a - List of lastNames
        var ans_list = employeeList.stream()
                // .map(employee -> employee.getlName())
                // TODO: Comment .map, .collect
                .map(Employee::getlName)
                .toList();
                System.out.println("[TASK A] - The list consisting of only lastnames is: \n" + ans_list + "\n");


        // Task b - Number of Gender.FEMALE
        var numFemales = employeeList.stream()
                // TODO: Comment .filter, .count
                .filter(gender -> gender.getGender() == FEMALE)
                .count();
                System.out.format("[TASK B] - The number of FEMALE employees is %d \n\n", numFemales);


        // Task c - Average salary of Gender.FEMALE
        var averageSalaryForFemale = employeeList.stream()
                // TODO: Comment .mapToInt, .average
                .filter(employee -> employee.getGender() == FEMALE)
                .mapToInt(Employee::getSalary)
                .average().getAsDouble();
                System.out.format("[TASK C] -The average salary for FEMALE employees is %.0f \n\n", averageSalaryForFemale);


        // Task d - Give all "Bosses" a 7% raise. Print the list after
        employeeList.stream()
                // TODO: Comment forEach
                .filter(employee -> employee.getPosition().equalsIgnoreCase("Boss"))
                .forEach(employee -> employee.setSalary( (int) (employee.getSalary() * 1.07)));
                System.out.format("[TASK D] - The list of employees after [Boss] has received a %d percent increase in salary:\n", PERCENTAGE_INCREASE);
                System.out.println(employeeList + "\n");


        // Task e - Return boolean if anyone has a salary greater than 800_000
        var greaterThanSalary = employeeList.stream()
                // TODO: Comment anyMatch
             // .map(salary -> employee.getSalary())
                .map(Employee::getSalary)
                .anyMatch(salary -> salary > 800_000);
                System.out.println("[TASK E] - It is [" + greaterThanSalary + "] that someone has a salary > 800.000\n");


        // Task f - Print the employee list with System.out.println() without using a loop
        System.out.println("[TASK F] - Printed using a pre-created toString() method in the Employee-class \n" + employeeList);
        System.out.println("[TASK F cont.] - Printed using a stream with a .forEach call \n");
        employeeList.stream()
                .forEach(System.out::println);
                System.out.println();


        // Task g - Find the employee(s) with the lowest salary
        var employeeLowSalary = employeeList.stream()
                // TODO: Comment comparator
                .min(Comparator.comparingInt(Employee::getSalary));
                System.out.println("[TASK G] - The lowest salary of all employees is: \n"+ employeeLowSalary + "\n");

        var employeesWithLowestSalary = employeeList.stream()
                // TODO: Comment .get(), toList()
                .filter(e -> e.getSalary() == employeeLowSalary.get().getSalary())
                .toList();
                System.out.println("[TASK G cont.] - The employees sharing the lowest salary is: \n" + employeesWithLowestSalary + "\n");


        // Task h - Find the sum of all whole numbers [1 <= 1000] divisible by 3 || 5
//        int[] numList = IntStream.rangeClosed(1, 1000).toArray();
//        // TODO: Comment Intstream . justification for toArray()
//
//        int sum_3 = Arrays.stream(numList)
//                // TODO: Comment Arrays.stream(array[])
//                .filter(i -> i % 3 == 0)
//                .sum();
//
//        int sum_5 = Arrays.stream(numList)
//                .filter(i -> i % 5 == 0)
//                .sum();
//
//        int sum_3_5 = Arrays.stream(numList)
//                .filter(i -> i % 3 == 0)
//                .filter(i -> i % 5 == 0)
//                .sum();
//
//        var sumDivisible = (sum_3 + sum_5) - sum_3_5;
//        System.out.println("The sum of numbers between [1, ... 1000] divisible by 3 or 5 is: " + sumDivisible);
//
        var sumDivisible = Stream.iterate(1, n -> n + 1).limit(1000)
                .toList()
                .stream().filter(i -> i % 5 == 0 || i % 3 == 0)
                .reduce(0, Integer::sum);
              //.reduce(0, (sum, i) -> sum + i);
                System.out.println("The sum of numbers between [1, ... 1000] divisible by 3 or 5 is: " + sumDivisible);
    }

    private static void printAll(List<Employee> employeeList) {
        /*
         * A bit redundant, but it looks nice when calling the print all
         */
        System.out.print(employeeList);
        System.out.println();
    }
}
