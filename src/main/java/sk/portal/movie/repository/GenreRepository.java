package sk.portal.movie.repository;

import org.springframework.data.repository.CrudRepository;

import sk.portal.movie.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

	Genre findGenreByName(String name);

}
