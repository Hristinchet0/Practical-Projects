import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of new students to enroll: ");
        int numberOfNewStudent = Integer.parseInt(scanner.nextLine());

        Student[] students = new Student[numberOfNewStudent];

        for (int i = 0; i < numberOfNewStudent; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            System.out.println("************************************************");
//            System.out.println(students[i].showInfo());
        }

        for (int i = 0; i < numberOfNewStudent; i++) {
            System.out.println(students[i].showInfo());
            System.out.println("************************************************");
        }
    }
}
