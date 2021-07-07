package PojoExample;

public class Employee {
    // private variables or data members of pojo class
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private double salary;
    private boolean married;

//    Add getter and setter methods for private variables
//    Since we have created all variables as private then there should be
//    a way to manipulate or retrieve these data. Let’s add
//    getter and setter methods for each variables.
//    It is not mandatory to have getter and setter for all and depends upon need.
//    But as of now let’s add getter and setter for all in same class.
//    A getter method is to get value of a variable and a setter method is to set value of a variable from outside.

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public boolean getMarried() {
        return married;
    }
    public void setMarried(boolean married) {
        this.married = married;
    }

}
