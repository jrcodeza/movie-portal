package sk.portal.movie.repository;

import org.springframework.data.repository.CrudRepository;

import sk.portal.movie.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

	Movie findMovieByTitle(String title);

}
