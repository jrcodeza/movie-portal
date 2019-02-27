package sk.portal.movie.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sk.portal.movie.model.Genre;
import sk.portal.movie.repository.GenreRepository;
import sk.portal.movie.repository.MovieRepository;
import sk.portal.movie.rest.model.Movie;

@RestController
@RequestMapping("/api/movies")
public class MoviesResource {

	private final MovieRepository movieRepository;

	private final Mapper mapper;

	private final GenreRepository genreRepository;

	public MoviesResource(MovieRepository movieRepository, GenreRepository genreRepository, Mapper mapper) {
		this.movieRepository = movieRepository;
		this.genreRepository = genreRepository;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Movie> crateMovie(@RequestBody @Valid Movie movie) {
		sk.portal.movie.model.Movie dbMovie = mapper.map(movie, sk.portal.movie.model.Movie.class);
		Optional<Genre> genre = genreRepository.findById(movie.getGenreId());
		if (genre.isPresent()) {
			dbMovie.setGenre(genre.orElse(null));
			movieRepository.save(dbMovie);
			return new ResponseEntity<>(movie, HttpStatus.OK);
		}
		return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
	}

	@GetMapping
	public List<Movie> getMovies() {
		List<Movie> result = new ArrayList<>();
		movieRepository.findAll().forEach(movie -> result.add(mapper.map(movie, Movie.class)));
		return result;
	}

}
