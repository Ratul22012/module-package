package com.university.admission;

import java.util.*;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class InvalidDepartmentException extends Exception {
    public InvalidDepartmentException(String message) {
        super(message);
    }
}

public class ageDepartmentValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to start validation? (YES/NO): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                System.out.println("Program ended.");
                break;
            }

            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter department: ");
            String department = sc.nextLine();

            boolean hasError = false;

            try {
                if (age < 18) {
                    throw new InvalidAgeException("Invalid age: Not eligible for university.");
                }
            } catch (InvalidAgeException e) {
                System.out.println("Caught Exception: " + e.getMessage());
                hasError = true;
            }

            try {
                if (!department.equalsIgnoreCase("ICT")) {
                    throw new InvalidDepartmentException("Invalid department: Only ICT is allowed.");
                }
            } catch (InvalidDepartmentException e) {
                System.out.println("Caught Exception: " + e.getMessage());
                hasError = true;
            }

            if (!hasError) {
                System.out.println("Valid age: " + age);
                System.out.println("Valid department: " + department);
            }

            System.out.println();
        }

    }
}