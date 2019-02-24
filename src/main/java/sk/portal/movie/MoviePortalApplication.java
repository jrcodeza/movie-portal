package sk.portal.movie;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import sk.portal.movie.model.MovieComment;
import sk.portal.movie.model.Genre;
import sk.portal.movie.model.Movie;
import sk.portal.movie.repository.CommentRepository;
import sk.portal.movie.repository.GenreRepository;
import sk.portal.movie.repository.MovieRepository;

@SpringBootApplication
public class MoviePortalApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MoviePortalApplication.class, args);
		initializeMovies(context);
	}

	private static void initializeMovies(ConfigurableApplicationContext context) {
		GenreRepository genreRepository = context.getBean(GenreRepository.class);
		genreRepository.saveAll(
				Stream.of(
						createGenre("Comedy", "Comedy description"),
						createGenre("Drama", "Drama description"),
						createGenre("Horror", "Horror description"),
						createGenre("Action", "Action description")
				).collect(Collectors.toList())
		);

		MovieRepository movieRepository = context.getBean(MovieRepository.class);
		movieRepository.saveAll(
			Stream.of(
					createMovie("Now you see me", "Short movie description", genreRepository.findGenreByName("Action"), 2003, 120),
					createMovie("Avengers", "Avengers movie", genreRepository.findGenreByName("Action"), 2019, 107),
					createMovie("Dumb and dumber to", "Comedy movie", genreRepository.findGenreByName("Comedy"), 2014, 113),
					createMovie("Forrest gump", "Short movie description", genreRepository.findGenreByName("Drama"), 1994, 97),
					createMovie("Lady bird", "Another movie description", genreRepository.findGenreByName("Drama"), 2017, 120),
					createMovie("The godfather 2", "Mafian story", genreRepository.findGenreByName("Drama"), 1974, 110),
					createMovie("The nun", "Horror movie description", genreRepository.findGenreByName("Horror"), 2018, 135)
			).collect(Collectors.toList())
		);

		CommentRepository commentRepository = context.getBean(CommentRepository.class);
		commentRepository.saveAll(
				Stream.of(
						createComment("john", "This movie was great!", movieRepository.findMovieByTitle("Avengers")),
						createComment(null, "I didn't like it it was very boring.", movieRepository.findMovieByTitle("Avengers")),
						createComment("bob", "Nothing special.", movieRepository.findMovieByTitle("Avengers")),
						createComment(null, "Another short comment to be used.", movieRepository.findMovieByTitle("Now you see me")),
						createComment(null, "Some longer comment to be shown in the user interface for example.",
								movieRepository.findMovieByTitle("Now you see me"))
				).collect(Collectors.toList())
		);
	}

	private static MovieComment createComment(String from, String message, Movie movie) {
		MovieComment movieComment = new MovieComment();
		movieComment.setAuthor(from);
		movieComment.setMessage(message);
		movieComment.setMovie(movie);
		return movieComment;
	}

	private static Movie createMovie(String title, String description, Genre genre, Integer year, Integer duration) {
		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setDescription(description);
		movie.setGenre(genre);
		movie.setYear(year);
		movie.setDuration(duration);
		return movie;
	}

	private static Genre createGenre(String name, String description) {
		Genre genre = new Genre();
		genre.setName(name);
		genre.setDescription(description);
		return genre;
	}

}
