package ex2.task2;

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


        /*
         * A Function<T, R>
         * T - Input
         * R - Result
         *
         * R apply.(T t);
         */

        // Function to increase salary by INCREASED_SALARY;
        Function<Employee, Integer> increasedSalary =
                employee -> employee.getSalary() + INCREASED_SALARY;

        // Function to increase salary by PERCENTAGE_INCREASE;
        Function<Employee, Integer> increasedByPercentage =
                employee -> employee.getSalary() + (employee.getSalary()*PERCENTAGE_INCREASE/100);

        // Function to increase salaries < 600_000 by INCREASED_LOW_SALARY
        Function<Employee, Integer> increaseLowSalary =
                employee -> employee.getSalary() < 600_000 ? (employee.getSalary() + INCREASED_LOW_SALARY) : employee.getSalary();

        // Function to increase salary by PERCENTAGE_INCREASE_MALE if the employee is MALE;
        Function<Employee, Integer> increaseForMale =
                employee -> employee.getGender() == Gender.MALE ? (employee.getSalary() + employee.getSalary()*PERCENTAGE_INCREASE_MALE/100) : employee.getSalary();



        // Base list
        printAll(employeeList);

        // Increase all salaries by 50_000
        System.out.println("Increase all salaries by 50_000");
        salaryAdjustment(employeeList, increasedSalary);
        printAll(employeeList);
        System.out.println();

        // Increase all salaries by 7%
        System.out.println("Increase all salaries by 7%");
        salaryAdjustment(employeeList, increasedByPercentage);
        printAll(employeeList);
        System.out.println();

        // Increase salaries < 600_000 by INCREASED_LOW_SALARY
        System.out.println("Increase salaries < 600_000 by INCREASED_LOW_SALARY");
        salaryAdjustment(employeeList, increaseLowSalary);
        printAll(employeeList);
        System.out.println();

        // Increase salary by 15% if the employee is MALE
        System.out.println("Increase salary by 15% if the employee is MALE");
        salaryAdjustment(employeeList, increaseForMale);
        printAll(employeeList);
        System.out.println();
    }


    private static void salaryAdjustment(List<Employee> employeeList, Function<Employee, Integer> function) {
        /**
         * TODO: Comment
         */
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
