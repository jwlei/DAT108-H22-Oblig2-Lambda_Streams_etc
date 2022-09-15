package ex2.task3;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import java.util.stream.Collectors;

import static ex2.task3.Gender.*;

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
                new Employee("Tom",     "Hansen",   MALE,    "Boss",         1_000_000),
                new Employee("Kari",    "Nielsen",  THEY,    "Sales",        500_000),
                new Employee("Ole",     "Karlsen",  MALE,    "Sales",        500_000),
                new Employee("Per",     "Crowo",    MALE,    "FullStack",    700_000),
                new Employee("Mona",    "Aarsen",   FEMALE,  "BackEnd",      500_000),
                new Employee("Lise",    "Aanstad",  FEMALE,  "FrontEnd",     600_000),
                new Employee("Jurgen",  "Hansen",   MALE,    "FrontEnd",     500_000)
        );

        // Create a placeholder list to print the answers
        List<String> ans_list;

        // Task a - List of lastNames
        ans_list = employeeList.stream()
             // .map(employee -> employee.getlName())
                .map(Employee::getlName)
                .collect(Collectors.toList());

        System.out.println("The list consisting of only lastnames is: \n" + ans_list + "\n");


        // Task b - Number of Gender.FEMALE
        var numFemales = employeeList.stream()
                .filter(gender -> gender.getGender() == FEMALE)
                .count();
                System.out.format("The number of FEMALE employees is %d \n\n", numFemales);


        // Task c - Average salary of Gender.FEMALE
        var averageSalaryForFemale = employeeList.stream()
                .filter(employee -> employee.getGender() == FEMALE)
                .mapToInt(Employee::getSalary)
                .average().getAsDouble();
                System.out.format("The average salary for FEMALE employees is %.0f \n\n", averageSalaryForFemale);


        // Task d - Give all "Bosses" a 7% raise. Print the list after
        employeeList.stream()
                .filter(employee -> employee.getPosition().equalsIgnoreCase("Boss"))
                .forEach(employee -> employee.setSalary( (int) (employee.getSalary() * 1.07)));
                System.out.format("The list of employees after [Boss] has received a %d percent increase in salary:\n", PERCENTAGE_INCREASE);
                System.out.println(employeeList);


        // Task e - Return boolean if anyone has a salary greater than 800_000



        // Task f - Print the employee list with System.out.println() without using a loop



        // Task g - Find the employee(s) with the lowest salary



        // Task h - Find the sum of all whole numbers [1 < 1000] divisible by 3 || 5



    }


    private static void printAll(List<Employee> employeeList) {
        /*
         * A bit redundant, but it looks nice when calling the print all
         */
        System.out.print(employeeList);
        System.out.println();
    }
}
