import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private static final double DEFAULT_COAST_OF_COURSE = 600;
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private List<String> courses;
    private double tuitionBalance = 0;
    private Scanner scanner;
    private static int id = 1000;

    public Student() {
        this.courses = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = scanner.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = scanner.nextLine();

        System.out.println("Enter student class level: ");
        System.out.printf("1 - Freshmen%n2 - Sophomore%n3 - Junior%n4 - Senior%n");
        this.gradeYear = scanner.nextInt();

        setStudentID();
    }

    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void enroll() {
        System.out.printf("Enter course to Enroll:%nOptions: History 101,%nMathematics 101,%nChemistry 101,%nComputer Science 101,%nQ to quit%n");
        do {
            System.out.print("Enter course to Enroll (Q to quit): ");
            this.scanner = new Scanner(System.in);
            String course = scanner.nextLine();

            if (!course.equals("Q")) {
                courses.add(course);
                tuitionBalance += DEFAULT_COAST_OF_COURSE;
            } else {
                System.out.println("You quit!");
                break;
            }
        } while (1 != 0);

        System.out.println("Balance: " + tuitionBalance);
        System.out.print("Enrolled in: ");
        courses.forEach(c -> System.out.printf("%s ", c));
        System.out.println();
    }

    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        this.scanner = new Scanner(System.in);
        double studentPayment = Double.parseDouble(scanner.nextLine());

        if (tuitionBalance >= studentPayment) {
            tuitionBalance -= studentPayment;
            viewBalance();
        } else {
            double change = studentPayment - tuitionBalance;
            double toPay = studentPayment - change;
            tuitionBalance -= toPay;
            System.out.println("Your change: $" + change);
        }

        System.out.println("Thank you for your payment: $" + studentPayment);
        viewBalance();
    }

    public String showInfo() {
        StringBuilder sb = new StringBuilder();


        sb.append("Student Name: " + firstName + " " + lastName).append(System.lineSeparator());
        sb.append("Student ID: ").append(studentID).append(System.lineSeparator());
        sb.append("Grade Level: ").append(gradeYear).append(System.lineSeparator());
        sb.append("Courses Enrolled: ");
        courses.forEach(c -> sb.append(c).append(" "));
        sb.append(System.lineSeparator());
        sb.append("Your Balance: $").append(tuitionBalance);

        return sb.toString();
    }
}
