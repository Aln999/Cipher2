import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class md{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Enter the string to hash:");
        String input = scanner.nextLine();

        try {
            // Create a MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Update the MessageDigest with the input string
            md.update(input.getBytes());

            // Get the hash's bytes
            byte[] digest = md.digest();

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Print the hexadecimal string
            System.out.println("MD5 hash of \"" + input + "\": " + hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

