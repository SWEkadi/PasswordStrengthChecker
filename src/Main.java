import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Password Strength Checker - Common Password Check Version");
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        String[] commonPasswords = {
            "123456",
            "12345678",
            "1234567890",
            "password",
            "admin",
            "admin123",
            "welcome",
            "guest123",
            "qwerty123",
            "abc123",
            "000000",
            "111111"
        };

        boolean isCommon = false;
        for (String common : commonPasswords) {
            if (password.equalsIgnoreCase(common)) {
                isCommon = true;
                break;
            }
        }

        if (isCommon) {
            System.out.println("Warning: This is a commonly used weak password.");
            System.out.println("Password Strength: Very Weak");
            input.close();
            return;
        }

        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()_+=-].*")) score++;

        System.out.println("Score: " + score + "/5");

        if (score <= 2) {
            System.out.println("Password Strength: Weak");
        } else if (score <= 4) {
            System.out.println("Password Strength: Medium");
        } else {
            System.out.println("Password Strength: Strong");
        }

        input.close();
    }
}