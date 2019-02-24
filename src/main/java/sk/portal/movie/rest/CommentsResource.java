package sk.portal.movie.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.portal.movie.exception.NotFoundException;
import sk.portal.movie.model.Movie;
import sk.portal.movie.model.MovieComment;
import sk.portal.movie.repository.MovieRepository;

@RestController
@RequestMapping("/movies/{movieId}")
public class CommentsResource {

	private final MovieRepository movieRepository;

	public CommentsResource(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@GetMapping("/comments")
	public List<MovieComment> getComments(@PathVariable("movieId") Long movieId) {
		Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new NotFoundException(movieId));
		return movie.getComments();
	}

}
