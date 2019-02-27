package sk.portal.movie.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.portal.movie.model.Movie;
import sk.portal.movie.repository.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MoviesResource {

	private final MovieRepository movieRepository;

	public MoviesResource(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@GetMapping
	public Iterable<Movie> getMovies() {
		return movieRepository.findAll();
	}

}
