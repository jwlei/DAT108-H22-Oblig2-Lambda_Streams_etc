package ex2.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static ex2.task3.Gender.*;

public class Main {
    private final static int PERCENTAGE_INCREASE = 7;

    public static void main(String[] args) {

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

        // Print initial list before any alterations
        System.out.println("[INITIAL LIST] - \n" + employeeList + "\n");

        task_A(employeeList);
        task_B(employeeList);
        task_C(employeeList);
        task_D(employeeList);
        task_E(employeeList);
        task_F(employeeList);
        task_G(employeeList);
        task_H(employeeList);
    }


    private static void task_A (List<Employee> employeeList){
        // Task a - List of lastNames
        var lnameList = employeeList.stream()
                // .map(employee -> employee.getlName())
                // Alternatively by performing a function call on each employee in the list
                .map(Employee::getlName)
                .sorted() // Optional
                .toList();

        System.out.println("[TASK A] - The list consisting of only lastnames is: \n" + lnameList + "\n");
    }


    private static void task_B (List<Employee> employeeList){
        // Task b - Number of Gender.FEMALE
        var numFemales = employeeList.stream()
                .filter(gender -> gender.getGender() == FEMALE)
                .count();

        System.out.format("[TASK B] - The number of FEMALE employees is %d \n\n", numFemales);
    }


    private static void task_C (List<Employee> employeeList){
        var averageSalaryForFemale = employeeList.stream()
                .filter(employee -> employee.getGender() == FEMALE)
                .mapToInt(Employee::getSalary)
                .average();

        if (averageSalaryForFemale.isPresent()) {
            System.out.format("[TASK C] - The average salary for FEMALE employees is %.0f \n\n", averageSalaryForFemale.getAsDouble());
        }
    }


    private static void task_D (List<Employee> employeeList){
        // Task d - Give all "Bosses" a 7% raise. Print the list after
        employeeList.stream()
                .filter(employee -> employee.getPosition().equalsIgnoreCase("Boss"))
                //.forEach(employee -> employee.setSalary((int) (employee.getSalary() * 1.07)));
                // Alternatively using a helper method
                .forEach(employee -> employee.setSalary(employee.getSalary() + raiseByPercentage(employee.getSalary(), PERCENTAGE_INCREASE)));

        System.out.format("[TASK D] - The list of employees after [Boss] has received a %d percent increase in salary:\n", PERCENTAGE_INCREASE);
        System.out.println(employeeList + "\n");
    }


    private static void task_E (List<Employee> employeeList){
        // Task e - Return boolean if anyone has a salary greater than 800_000
        var greaterThanFlag = employeeList.stream()
                // .map(salary -> employee.getSalary())
                .map(Employee::getSalary)
                .anyMatch(salary -> salary > 800_000);
        // Alternatively skip the mapping
        // .anyMatch (salary -> employee.getSalary() > 800_000);

        System.out.println("[TASK E] - It is [" + greaterThanFlag + "] that someone has a salary > 800.000\n");
    }


    private static void task_F (List<Employee> employeeList){
        // Task f - Print the employee list with System.out.println() without using a loop
        System.out.println("[TASK F] - Printed using a pre-created toString() method in the Employee-class \n" + employeeList + "\n");
        System.out.println("[TASK F cont.] - Printed using a stream with a .forEach call");
        employeeList.stream()
                .forEach(System.out::print);
        System.out.println();
    }


    private static void task_G (List<Employee> employeeList){
        // Task g - Find the employee(s) with the lowest salary
        var employeeLowSalary = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getSalary));

        System.out.println("\n[TASK G] - The lowest salary of all employees is: \n"+ employeeLowSalary + "\n");

        var employeesWithLowestSalary = employeeList.stream()
                .filter(e -> e.getSalary() == employeeLowSalary.get().getSalary())
                .toList();

        System.out.println("[TASK G cont.] - The employees sharing the lowest salary is: \n" + employeesWithLowestSalary + "\n");
    }


    private static void task_H (List<Employee> employeeList){
        // Task h - Find the sum of all whole numbers [1 <= 1000] divisible by 3 || 5
        var sumDivisible = Stream.iterate(1, n -> n + 1).limit(1000)
                .toList()
                .stream()
                .filter(i -> i % 5 == 0 || i % 3 == 0)
                //.reduce(0, (sum, i) -> sum + i);
                // Alternatively by using a function call to the sum function
                .reduce(0, Integer::sum);

        System.out.println("The sum of numbers [1, ... 1000] divisible by 3 or 5 is: " + sumDivisible);
    }


    private static void printAll(List<Employee> employeeList) {
        /*
         * A bit redundant, but it looks nice when calling the print all
         */
        System.out.print(employeeList);
        System.out.println();
    }

    private static int raiseByPercentage (int salary, int percent) {
        /**
         * Helper method to return the additional salary based on a percentage
         * of the supplied salary
         */
        return (salary * percent) / 100;
    }


    /*
     * ---------------------- MISC Documentation commentary ---------------------------
     * Streams      -   https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
     * Collectors   -   https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
     * Optional     -   https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
     *
     * ---------------------- Stream Pipeline  ----------------------------------------
     * source -> intermediate operations -> terminal operations
     *
     * source - The data source of the stream
     *
     * intermediate operations - returns a new modified stream
     *
     * terminal operations - Can only use one terminal operation per stream
     *                       They can return a primitive value (boolean or long), a concrete type (Optional value object), or void (creating side effect).
     *                       A terminal operation is always the last operation in a Stream pipeline.
     *
     *
     * ---------------------- Parallel Streams ----------------------------------------
     * If the source of a stream is something other than a Collection or an array, the parallel() method should be used
     *
     * Stream<Product> streamOfCollection = productList.parallelStream();
     * boolean isParallel = streamOfCollection.isParallel();
     * boolean bigPrice = streamOfCollection
     *      .map(product -> product.getPrice() * 12)
     *      .anyMatch(price -> price > 200);
     *
     * IntStream intStreamParallel = IntStream.range(1, 150).parallel();
     * boolean isParallel = intStreamParallel.isParallel();
     *
     * When using streams in parallel mode, avoid blocking operations.
     * It is also best to use parallel mode when tasks need a similar amount of time to execute.
     * If one task lasts much longer than the other, it can slow down the complete app’s workflow.
     *
     * The stream in parallel mode can be converted back to the sequential mode by using the sequential() method:
     * IntStream intStreamSequential = intStreamParallel.sequential();
     * boolean isParallel = intStreamSequential.isParallel();
     *
     *
     * ---------------------- Types of streams ----------------------------------------
     * Collection (Collection, List, Set)
     * Collection<String> collection = Arrays.asList("a", "b", "c");
     * Stream<String> streamOfCollection = collection.stream();
     *
     * Array
     * Stream<String> streamOfArray = Stream.of("a", "b", "c");
     * We can also create a stream out of an existing array or of part of an array:
     * String[] arr = new String[]{"a", "b", "c"};
     * Stream<String> streamOfArrayFull = Arrays.stream(arr);
     * Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
     *
     *
     * ----------------------Generating streams ---------------------------------------
     * Stream.generate()
     * Stream<String> streamGenerated =
     * Stream.generate(() -> "element").limit(10);
     *
     * Stream.iterate()
     * Stream<Integer> streamIterated = Stream.iterate(START_INT, n -> n + 1).limit(MAX_INT);
     *
     *
     * Stream of Primitives:
     * IntStream, LongStream, DoubleStream
     * e.g. IntStream stream = IntStream.rangeClosed(1,1000);
     *                                   range(int startInclusive, int endExclusive)
     *                                   rangeClosed(int startInclusive, int endInclusive)
     *
     * Stream of String:
     * IntStream streamOfChars = "abc".chars();
     * Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");
     *
     *
     * ----------------------Referencing a stream -------------------------------------
     * We can instantiate a stream, and have an accessible reference to it, as long as only intermediate operations are called.
     * Executing a terminal operation makes a stream inaccessible.
     *      e.g. .forEach, .collect
     *
     * As the IllegalStateException is a RuntimeException, a compiler will not signalize about a problem.
     * So it is very important to remember that Java streams can't be reused.
     *
     *
     * ---------------------- Stream reduction -----------------------------------------
     * To reduce a stream we can use
     * .reduce()
     * .collect()
     * See the respective methods under terminal operations
     *
     *
     * ---------------------- Intermediate operations ----------------------------------
     * .skip()
     * Skips element (e) when creating a stream
     *
     * .map()
     * Returns a stream consisting of the results of the lambda function to the elements of this stream
     * e.g. .map( i -> i >= 0)
     *
     * .mapToInt()
     * maps the elements to int values
     *
     * .filter()
     * The filter method is used to select elements as per the Predicate passed as argument.
     *
     *
     * .stream()
     * Creates a new stream
     *
     * .toList()
     * Returns an immutable list
     *
     * Comparator
     * used to compare element x and y when processing elements in a stream
     *
     *
     * ---------------------- Terminal operations -------------------------------------
     * .collect(Collections.toList()) --> See Collectors documentation
     * Returns a mutable list
     * The collect method is used to return the result of the intermediate operations performed on the stream.
     * List number = Arrays.asList(2,3,4,5,3);
     * Set square = number.stream().map(x->x*x).collect(Collectors.toSet());
     *
     *
     * .reduce()
     * The reduce method is used to reduce the elements of a stream to a single value.
     * .reduce(identity, accumulator, combiner)
     * identity – the initial value for an accumulator, or a default value if a stream is empty and there is nothing to accumulate
     *
     * accumulator – a function which specifies the logic of the aggregation of elements. As the accumulator creates a new value
     * for every step of reducing, the quantity of new values equals the stream's size and only the last value is useful.
     * This is not very good for the performance.
     *
     * combiner – a function which aggregates the results of the accumulator.
     * We only call combiner in a parallel mode to reduce the results of accumulators from different threads.
     *
     *
     * .forEach();
     * Perform the action forEach(expression -> expression > someValue)
     *
     * .anyMatch()
     * .allMatch()
     * .findAny()
     * .findFirst()
     *
     * .count()
     * .min()
     * .max()
     *
     * .toArray()
     */
}
