package lab1;

public class MovieDriver {
    public static void main(String[] args) {
        Movie baseMovie = new Movie("Interstellar", "PG-13", 12000);
        System.out.println("Base Movie -> " + baseMovie.toString());

        Movie copyMovie = new Movie(baseMovie);
        System.out.println("Copy Movie -> " + copyMovie.toString());

        copyMovie.setRating("R");
        copyMovie.setSoldTickets(copyMovie.getSoldTickets() + 1000);
        System.out.println("Updated Copy -> " + copyMovie.toString());

        if (baseMovie.getSoldTickets() > copyMovie.getSoldTickets()) {
            System.out.println(baseMovie.getTitle() + " sold more tickets than its copy.");
        } else if (baseMovie.getSoldTickets() < copyMovie.getSoldTickets()) {
            System.out.println("Copy sold more tickets than " + baseMovie.getTitle());
        } else {
            System.out.println("Both movies sold the same number of tickets.");
        }
    }
}
