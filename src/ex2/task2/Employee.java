package ex2.task2;

public class Employee {

    String fName, lName, position;
    Gender gender;
    int salary;

    public Employee(String fName, String lName, Gender gender, String position, int salary) {
        /**
         * Constructor
         */
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.position = position;
        this.salary = salary;
    }

    // Getters and setters
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // toString
    @Override
    public String toString() {
        /**
         * toString method to print all employees
         */
        return "\nEmployee [Name = " + fName
                + ", Lastname = " + lName
                + ", Gender = " + gender
                + ", position = " + position
                + ", salary = "+ salary + "]";
    }
}
