
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {

    private static final String COLORS_FILE = "colors.txt"; // Place colors.txt in the same folder as this program
    private static final int OPTION_ALL = 1;
    private static final int OPTION_TEN = 2;
    private static final int OPTION_FIVE = 3;
    private static final int OPTION_EXIT = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> colors = loadColors(COLORS_FILE);

        if (colors.size() < 16) {
            System.out.println("Error: colors.txt must contain at least 16 colors (one per line). Found: " + colors.size());
            System.out.println("Please update the file and run again.");
            return;
        }

        while (true) {
            printMenu();
            int choice = readMenuChoice(scanner);
            if (choice == OPTION_EXIT) {
                System.out.println("Goodbye!");
                break;
            }

            int limit = switch (choice) {
                case OPTION_ALL -> 16;
                case OPTION_TEN -> 10;
                case OPTION_FIVE -> 5;
                default -> 0;
            };

            // Build the working list according to the chosen limit
            List<String> subset = new ArrayList<>(colors.subList(0, limit));

            // Display available colors
            System.out.println("\nAvailable colors (" + limit + "):");
            for (int i = 0; i < subset.size(); i++) {
                System.out.printf("%2d. %s%n", i + 1, subset.get(i));
            }

            // Computer randomly selects a color from the subset
            Random rand = new Random();
            String secret = subset.get(rand.nextInt(subset.size()));

            // Ask the user to guess
            System.out.print("\nGuess the computer's color (type the color name as shown): ");
            String guess = scanner.nextLine().trim();

            if (guess.equalsIgnoreCase(secret)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct color was: " + secret);
            }

            // Optional: pause before returning to menu
            System.out.print("\nPress Enter to return to the menu...");
            scanner.nextLine();
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== ESP (Extrasensory Perception) =====");
        System.out.println("1) Read & display the first 16 colors");
        System.out.println("2) Read & display the first 10 colors");
        System.out.println("3) Read & display the first 5 colors");
        System.out.println("4) Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    private static int readMenuChoice(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(line);
                if (choice >= OPTION_ALL && choice <= OPTION_EXIT) {
                    return choice;
                }
            } catch (NumberFormatException ignored) { }
            System.out.print("Invalid choice. Please enter a number 1-4: ");
        }
    }

    private static List<String> loadColors(String fileName) {
        Path path = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(path);
            List<String> cleaned = new ArrayList<>();
            for (String s : lines) {
                String t = s.trim();
                if (!t.isEmpty()) {
                    cleaned.add(t);
                }
            }
            return cleaned;
        } catch (IOException e) {
            System.out.println("Error: Unable to read '" + fileName + "'. " +
                    "Make sure the file exists in the same folder as this program.");
            return List.of();
        }
    }
}
