package emailApp;

import java.security.SecureRandom;
import java.util.Scanner;

public class Email {

    private static final int DEFAULT_PASSWORD_LENGTH = 10;
    private static final String DEFAULT_COMPANY_SUFFIX = "company.com";
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private int mailBoxCapacity = 500;
    private String alternativeEmail;

    //Constructor to receive first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

//        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        //Call a method asking for the department -> return the department
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        //Call a method that returns a random password
        this.password = generateRandomPassword(DEFAULT_PASSWORD_LENGTH);
        System.out.println("Your Password is: " + this.password);

        //Combine the elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + DEFAULT_COMPANY_SUFFIX;
        System.out.println("Your email is: " + email);
    }

    //Ask for department
    private String setDepartment() {
        System.out.println("Hello " + this.firstName + " " + this.lastName + " !");
        System.out.println("Enter department code: ");
        System.out.printf("1 for Sales%n2 for Development%n3 for Accounting%n0 for none%n");

        Scanner scanner = new Scanner(System.in);
        int departmentChoice = Integer.parseInt(scanner.nextLine());

        switch (departmentChoice) {
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    }

    //Generate random password
    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$.";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    //Set the mailbox capacity
    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    //Set the alternative email
    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    //Change the password
    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("You changed your password!");
        System.out.println("Your new password is: " + this.password);
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInformation() {
        return String.format("DISPLAY NAME: %s %s%n" +
                "\tCOMPANY EMAIL: %s%n" +
                "\tALTERNATIVE EMAIL: %s%n" +
                "\tMAILBOX CAPACITY : %d mb", this.firstName, this.lastName, this.email, this.alternativeEmail, this.mailBoxCapacity);
    }
}
