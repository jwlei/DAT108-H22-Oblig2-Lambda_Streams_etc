package ex2.task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static ex2.task2.Gender.*;

public class Main {
    private final static int INCREASED_SALARY = 50_000;
    private final static int PERCENTAGE_INCREASE = 7;
    private final static int INCREASED_LOW_SALARY = 30_000;
    private final static int PERCENTAGE_INCREASE_MALE = 15;

    public static void main(String[] args) {

        /*
         * The task:
         * We have a list of employees which we want to create a method to perform a salary adjustment.
         *
         * The salary adjustment should be performed as a function parameter in a method salaryAdjustment
         * so that the salaryAdjustment method is generic and does not depend on the type of calculation.
         *
         * Use lambda expressions for the different types of salary adjustments (described per Function<>)
         */


        // Create a list with dummy data to perform operations on
        List<Employee> employeeList = Arrays.asList(
                new Employee("Tom",     "Hansen",   MALE,    "Boss",         1_000_000),
                new Employee("Kari",    "Nielsen",  THEY,    "Sales",        500_000),
                new Employee("Ole",     "Karlsen",  MALE,    "Sales",        500_000),
                new Employee("Per",     "Crowo",    MALE,    "FullStack",    700_000),
                new Employee("Mona",    "Aarsen",   FEMALE,  "BackEnd",      500_000),
                new Employee("Lise",    "Aanstad",  FEMALE,  "FrontEnd",     600_000),
                new Employee("Jurgen",  "Hansen",   MALE,    "FrontEnd",     500_000)
        );


        /*
         * Function<T, R>
         * T - Input
         * R - Result
         *
         * R apply.(T t);
         */

        // Function to increase salary by INCREASED_SALARY;
        Function<Employee, Integer> increasedSalary =
                // For each employee, getSalary, add INCREASED_SALARY
                employee -> employee.getSalary() + INCREASED_SALARY;

        // Function to increase salary by PERCENTAGE_INCREASE;
        Function<Employee, Integer> increasedByPercentage =
                // For each employee, getSalary, add (salary*7%)
                // employee -> employee.getSalary() + (employee.getSalary()*PERCENTAGE_INCREASE/100);

                // Alternatively using a helper method [int raiseByPercentage(int salary, int percent)] which returns Salary*percent
                employee -> employee.getSalary() + raiseByPercentage(employee.getSalary(), PERCENTAGE_INCREASE);

        // Function to increase salaries <= 600_000 by INCREASED_LOW_SALARY
        Function<Employee, Integer> increaseLowSalary =
                // For each employee, if salary is equal or lower than 600_000, get salary and add INCREASED_LOW_SALARY, else just get the salary
                employee -> employee.getSalary() <= 600_000 ? (employee.getSalary() + INCREASED_LOW_SALARY) : employee.getSalary();

        // Function to increase salary by PERCENTAGE_INCREASE_MALE if the employee is MALE;
        Function<Employee, Integer> increaseForMale =
                // For each employee, if the gender is male, apply a % raise, else just get salary
                // employee -> employee.getGender() == MALE ? (employee.getSalary() + employee.getSalary()*PERCENTAGE_INCREASE_MALE/100) : employee.getSalary();

                // Alternatively using a helper method [int raiseByPercentage(int salary, int percent)] which returns Salary*percent
                employee -> employee.getGender() == MALE ? employee.getSalary() + (raiseByPercentage(employee.getSalary(), PERCENTAGE_INCREASE_MALE)) : employee.getSalary();



        // Base list
        System.out.println("[TASK 2] - The list of employees before any adjustments:");
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
         * The method takes in a list, and performs the setSalary forEach applicable employee
         * as described in the lambda expression of the function by calling function.apply(object).
         */
        employeeList.forEach(employee -> employee.setSalary(function.apply(employee)));
    }

    private static void printAll(List<Employee> employeeList) {
        /*
         * A bit redundant, but it looks nice when calling the print all
         */
        System.out.print(employeeList + "\n");
    }

    private static int raiseByPercentage (int salary, int percent) {
        /**
         * Helper method to return the additional salary based on a percentage
         * of the supplied salary
         */
        return (salary * percent) / 100;
    }
}
