package ex2.task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    // TODO: Fast kronetillegg
    private final static int INCREASED_SALARY = 50_000;

    // TODO: fast prosenttillegg
    private final static int PERCENTAGE_INCREASE = 7;

    // TODO: fast kronetillegg for lav lønn
    private final static int INCREASED_LOW_SALARY = 30_000;

    // TODO: fast prosentttillegg hvis du er mann
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
    printAll(employeeList);
    }

    // TODO: Create functions for adjustments of salary

    /*
     * A Function<T, R>
     * T - Input
     * R - Result
     *
     * R apply.(T t);
     */

    Function<Employee, Integer> increasedSalary =
            employee -> employee.getSalary() + INCREASED_SALARY;

    private static void salaryAdjustment(List<Employee> employeeList, Function<Employee, Integer> function) {

    }

    private static void printAll(List<Employee> employeeList) {
        /*
         * A bit redundant, but it looks nice when calling the print all
         */
        System.out.print(employeeList);
    }
}
