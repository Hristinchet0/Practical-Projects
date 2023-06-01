package emailApp;

public class EmailApp {
    public static void main(String[] args) {

        Email email = new Email("Hristina", "Racheva");

        email.setAlternativeEmail("test@mail.com");
        System.out.println(email.showInformation());
        email.changePassword("alabala123");
    }
}
