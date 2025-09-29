package lab1;
import java.util.Scanner;

public class MovieDriver_Task2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String cont = "y";

  while (cont.equalsIgnoreCase("y")) {
  System.out.print("Enter the name of a movie: ");
  String title = keyboard.nextLine();

System.out.print("Enter the movie rating: ");
 String rating = keyboard.nextLine();

 System.out.print("Enter the number of tickets sold: ");
 int soldTickets = keyboard.nextInt();
  keyboard.nextLine(); 

Movie myMovie = new Movie(title, rating, soldTickets);

 System.out.println(myMovie.toString());

 System.out.print("Do you want to enter another? (y/n): ");
 cont = keyboard.nextLine();
        }

        System.out.println("Goodbye!");
        keyboard.close();
    }
}
