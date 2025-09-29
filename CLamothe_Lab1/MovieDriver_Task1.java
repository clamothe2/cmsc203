package lab1;
import java.util.Scanner;

public class MovieDriver_Task1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

System.out.print("Enter the name of a movie: ");
 String title = keyboard.nextLine();

System.out.print("Enter the movie rating: ");
String rating = keyboard.nextLine();

 System.out.print("Enter the number of tickets sold: ");
int soldTickets = keyboard.nextInt();

 Movie myMovie = new Movie(title, rating, soldTickets);

 System.out.println(myMovie.toString());

keyboard.close();
    }
}
