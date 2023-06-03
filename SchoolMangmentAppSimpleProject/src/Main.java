import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Teacher nakov = new Teacher(1, "Nakov", 500);
        Teacher topuzakova = new Teacher(2, "Topuzakova", 1000);
        Teacher bankin = new Teacher(3, "Bankin", 800);

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(nakov);
        teachers.add(topuzakova);
        teachers.add(bankin);

        Student racheva = new Student(1, "Racheva", 5);
        Student alichkov = new Student(2, "Alichkov", 5);
        Student gineva = new Student(3, "Gineva", 5);
        Student velikova = new Student(4, "Velikova", 5);

        List<Student> students = new ArrayList<>();
        students.add(racheva);
        students.add(alichkov);
        students.add(gineva);
        students.add(velikova);

        School softuni = new School(teachers, students);

        Teacher mitkov = new Teacher(4, "Mitkov", 900);

        softuni.addTeacher(mitkov);

        racheva.payFees(5000);
        gineva.payFees(6000);

        System.out.println("Softuni has earned $" + softuni.getTotalMoneyEarned());

        topuzakova.receiveSalary(topuzakova.getSalary());
        System.out.printf("Softuni has spend for salary to %s%n and now has $%d total money.%n", topuzakova.getName(), softuni.getTotalMoneyEarned());

        bankin.receiveSalary(bankin.getSalary());
        System.out.printf("Softuni has spend for salary to %s%n and now has $%d total money.%n", bankin.getName(), softuni.getTotalMoneyEarned());

        System.out.println(racheva);

        topuzakova.receiveSalary(topuzakova.getSalary());
        System.out.println(topuzakova);
    }
}
