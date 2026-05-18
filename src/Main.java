import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Password Strength Checker");
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
        }

        int score = 0;

        boolean hasLength = password.length() >= 8;
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+=-].*");

        if (hasLength) score++;
        if (hasUppercase) score++;
        if (hasLowercase) score++;
        if (hasNumber) score++;
        if (hasSpecial) score++;

        System.out.println("Score: " + score + "/5");

        System.out.println("\nDetailed Report:");
        System.out.println("Length: " + (hasLength ? "Found" : "Missing"));
        System.out.println("Uppercase Letters: " + (hasUppercase ? "Found" : "Missing"));
        System.out.println("Lowercase Letters: " + (hasLowercase ? "Found" : "Missing"));
        System.out.println("Numbers: " + (hasNumber ? "Found" : "Missing"));
        System.out.println("Special Characters: " + (hasSpecial ? "Found" : "Missing"));

        if (isCommon) {
            System.out.println("Password Strength: Very Weak");
        } else if (score <= 2) {
            System.out.println("Password Strength: Weak");
        } else if (score <= 4) {
            System.out.println("Password Strength: Medium");
        } else {
            System.out.println("Password Strength: Strong");
        }

        input.close();
    }
}