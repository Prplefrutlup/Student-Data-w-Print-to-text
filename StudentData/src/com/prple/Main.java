package com.prple;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static void studentInfo(LinkedList students) {
        boolean quit = false; // field used to exit program

        printMenu();

        // while loop to prompt user on which action to take
        while (!quit) {
            int action = sc.nextInt(); // used to get menu item chosen by user
            sc.nextLine(); // used to catch enter

            switch (action) {
                case 0:
                    System.out.println("Program Terminated");
                    sc.close();
                    quit = true;
                    break;
                case 1:
                    setStudentsInfo(students);
                    printMenu();
                    quit = false;
                    break;
                case 2:
                    printToTextFile(students);
                    printMenu();
                    quit = false;
                    break;
                default:
                    System.out.println("Pick an option from the menu below: ");
                    printMenu();

            }
        }
    }

    private static void sortLinkedList(LinkedList students) {
        // used to sort linked list
        Collections.sort(students, Student.nameComparator);
    }

    private static void setStudentsInfo(LinkedList studentsInfo) {
        // instantiate student objects via user input
        int numberStudents;

        System.out.println("Enter number of student records to enter: ");
        numberStudents = sc.nextInt(); //denotes how many student records to input

        //while loop to get student data from user
        int i = 0;
        while (i < numberStudents) {
            String name;
            String addy;
            double GPA;

            System.out.println("Enter student name: ");

            //used to catch enter on 1st loop
            if (i == 0) {
                sc.nextLine();
            }

            name = sc.nextLine();//accepts user input for name field

            System.out.println("Enter student GPA: ");
            GPA = sc.nextDouble(); // accepts user input
            sc.nextLine();// used to catch enter

            System.out.println("Enter student address: ");
            addy = sc.nextLine();// accepts user input

            studentsInfo.add(new Student(name, addy, GPA)); // creates student object with user info and adds to
            // students list

            i++; // increments i variable to iterate through students to enter
        }
    }

    private static void printMenu() {
        System.out.println("Available Actions: \n " + "Press 0 to quit \n" + "1 -  Enter Student Data \n"
                + "2 -  Print data to .txt file");
    }

    //used to print out elements in the list if needed
    private static void printList(LinkedList linkedList) {
        // initialize object to an array
        Object[] array = linkedList.toArray();

        // loops through array and prints elements
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(array[i]);
        }

    }

    private static void printToTextFile(LinkedList linkedList) {
        // instantiates FileWriter and writes file to CSC372_Portfolio_Project.txt
        FileWriter locFile = null;

        // sorts linked list in alphabetical ascending order
        sortLinkedList(linkedList);
        try {

            locFile = new FileWriter("CSC372_Portfolio_Project.txt");
            for (Object student : linkedList.toArray()) {
                locFile.write(student.toString() + "\n");
            }
            System.out.println("Successfully printed Students to CSC372_Portfolio_Project.txt");
            locFile.close();
        } catch (IOException e) {
            System.out.println("Failed to write file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LinkedList<Student> studentLinkedList = new LinkedList<>();

        studentInfo(studentLinkedList);

    }
}
