package com.prple;

import java.util.Comparator;

public class Student {

    //initializing student class fields
    private String name;
    private String address;
    double GPA;

    public Student() {
    }

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student name: " + this.name + "\n" +
                "Student address: " + this.address + "\n" +
                "GPA: " + this.GPA + "\n";
    }

    //Comparator for sorting student by name
    public static Comparator<Student> nameComparator = new Comparator<Student>() {
        public int compare(Student stu1, Student stu2) {
            String s1 = stu1.getName().toUpperCase();
            String s2 = stu2.getName().toUpperCase();

            return s1.compareTo(s2);
        }
    };

}
