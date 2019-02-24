package sk.portal.movie.repository;

import org.springframework.data.repository.CrudRepository;

import sk.portal.movie.model.MovieComment;

public interface CommentRepository extends CrudRepository<MovieComment, Long> {
}
