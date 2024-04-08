import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private int id;

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    enterStudentList(scanner);
                    break;
                case 2:
                    findStudentsByLastName(scanner);
                    break;
                case 3:
                    findAndEditStudentsByFullName(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void enterStudentList(Scanner scanner) {
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Student student = new Student(firstName, lastName, id);
            studentList.add(student);
        }
        System.out.println("Student list entered successfully.");
    }

    private static void findStudentsByLastName(Scanner scanner) {
        System.out.print("Enter last name to search for: ");
        String lastName = scanner.nextLine();
        boolean found = false;
        for (Student student : studentList) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Found student: " + student.getFirstName() + " " + student.getLastName() + " (ID: " + student.getId() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with last name '" + lastName + "'");
        }
    }

    private static void findAndEditStudentsByFullName(Scanner scanner) {
        System.out.print("Enter full name to search for: ");
        String fullName = scanner.nextLine();
        boolean found = false;
        for (Student student : studentList) {
            String studentFullName = student.getFirstName() + " " + student.getLastName();
            if (studentFullName.equalsIgnoreCase(fullName)) {
                System.out.println("Found student: " + studentFullName + " (ID: " + student.getId() + ")");
                System.out.println("Enter new details:");
                System.out.print("New First Name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("New Last Name: ");
                String newLastName = scanner.nextLine();
                System.out.print("New ID: ");
                int newId = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                student.setFirstName(newFirstName);
                student.setLastName(newLastName);
                student.setId(newId);

                System.out.println("Student details updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with full name '" + fullName + "'");
        }
    }

}