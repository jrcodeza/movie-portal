package sk.portal.movie.rest.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

import sk.portal.movie.model.Movie;

@Component
public class MovieMappingBuilder extends BeanMappingBuilder {
	@Override
	protected void configure() {
		mapping(Movie.class, sk.portal.movie.rest.model.Movie.class)
				.fields("genre.id", "genreId")
				.fields("genre.name", "genreName");
	}
}
