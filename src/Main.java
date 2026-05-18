import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Password Strength Checker - Detailed Report Version");        System.out.print("Enter your password: ");
        String password = input.nextLine();

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