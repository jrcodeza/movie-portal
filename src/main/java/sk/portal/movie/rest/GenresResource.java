package sk.portal.movie.rest;


import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.portal.movie.repository.GenreRepository;
import sk.portal.movie.rest.model.Genre;

@RestController
@RequestMapping("/api/genres")
public class GenresResource {

	private final GenreRepository genreRepository;

	private final Mapper mapper;

	public GenresResource(GenreRepository genreRepository, Mapper mapper) {
		this.genreRepository = genreRepository;
		this.mapper = mapper;
	}

	@GetMapping
	public List<Genre> getAllGenres() {
		List<Genre> result = new ArrayList<>();
		genreRepository.findAll().forEach(genre -> result.add(mapper.map(genre, Genre.class)));
		return result;
	}
}
