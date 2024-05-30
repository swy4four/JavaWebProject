package com.icss.day09;

public class Person {
    private int id;
    private String name;
    private int age;

    // Constructor
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ToString method
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // Bubble sort method to sort Person array by age
    public static void sortByAge(Person[] people) {
        int n = people.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (people[j].getAge() > people[j + 1].getAge()) {
                    // swap temp and people[i]
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Creating an array of Person objects
        Person[] people = new Person[5];
        people[0] = new Person(1, "Alice", 25);
        people[1] = new Person(2, "Bob", 35);
        people[2] = new Person(3, "Charlie", 21);
        people[3] = new Person(4, "David", 28);
        people[4] = new Person(5, "Eve", 18);

        // Sorting the array by age
        sortByAge(people);

        // Printing the sorted array
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

