package _05_netflix;

public class NetflixRunner {

	public static void main(String[] args) {
		Movie motionPicture = new Movie("Star Trek: The Motion Picture", 2);
		Movie wrathOfKhan = new Movie("Star Trek II: The Wrath of Khan", 4);
		Movie searchForSpock = new Movie("Star Trek III: The Search for Spock", 3);
		Movie voyageHome = new Movie("Star Trek IV: The Voyage Home", 5);
		Movie finalFrontier = new Movie("Star Trek V: The Final Frontier", 1);
		Movie undiscoveredCountry = new Movie("Star Trek VI: The Undiscovered Country", 4);
		System.out.println(wrathOfKhan.getTicketPrice());
		NetflixQueue queue = new NetflixQueue();
		queue.addMovie(motionPicture);
		queue.addMovie(wrathOfKhan);
		queue.addMovie(searchForSpock);
		queue.addMovie(voyageHome);
		queue.addMovie(finalFrontier);
		queue.addMovie(undiscoveredCountry);
		queue.sortMoviesByRating();
		queue.printMovies();
		System.out.println("The best movie is " + queue.getBestMovie() + ".");
		System.out.println("The second best movie is " + queue.getMovie(1) + ".");
	}

}
